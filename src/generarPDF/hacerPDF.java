package generarPDF;

import Empleado.sesionCorreo;
import com.itextpdf.text.*;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import conexion.Conexion;

import java.sql.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;


public class hacerPDF {
    public void hacerFacturaPDF(int idReserva){

        int idCliente = sesionCorreo.getID();
        String correoCliente = sesionCorreo.getCorreo();

        // Obtener la fecha y hora actual
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        //Destino donde se guardara el PDF una vez generado
        String dest = "/Users/adrian_ramos/ideaProjects/projectBookMe/facturasPdf/Factura_"+idCliente+"_"+timeStamp+".pdf";

        try{
            var document = new Document();

            PdfWriter.getInstance(document, new FileOutputStream(dest));
            document.open();


            agregarEncabezado(document, correoCliente);
            agregarTablaServicios(document, idCliente, idReserva);

            System.out.println("Factura generada con exito");

            } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void agregarEncabezado(Document document, String correoCliente) throws DocumentException {
        var titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
        var title = new Paragraph("Factura de Servicios - SPA",titleFont);
        var spacer = new Paragraph(" ",titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);


        var textFont = new Font(Font.FontFamily.TIMES_ROMAN, 12);
        var text = new Paragraph("Cliente: " + correoCliente,textFont);
        text.setAlignment(Element.ALIGN_CENTER);
        document.add(text);
        document.add(spacer);
    }

    private static void agregarTablaServicios(Document document, int idCliente, int idReserva) throws DocumentException {
        PdfPTable table = new PdfPTable(8); // 8 columnas
        table.setWidthPercentage(100);
        Font textFont = new Font(Font.FontFamily.TIMES_ROMAN, 12);

        // Encabezados de la tabla
        table.addCell(new PdfPCell(new Paragraph("ID Servicio", textFont)));
        table.addCell(new PdfPCell(new Paragraph("Servicio", textFont)));
        table.addCell(new PdfPCell(new Paragraph("ID Reserva", textFont)));
        table.addCell(new PdfPCell(new Paragraph("ID Pago", textFont)));
        table.addCell(new PdfPCell(new Paragraph("Fecha Pago", textFont)));
        table.addCell(new PdfPCell(new Paragraph("Metodo Pago", textFont)));
        table.addCell(new PdfPCell(new Paragraph("Estado Pago", textFont)));
        table.addCell(new PdfPCell(new Paragraph("Precio", textFont)));

        // Consulta
        String query = """
        SELECT DISTINCT 
            s.id_servicio, 
            s.nombre_servicio, 
            s.precio, 
            p.id_pago, 
            r.id_reserva, 
            COALESCE(p.fecha_pago, 'N/A') AS fecha_pago, 
            COALESCE(p.metodo_pago, 'N/A') AS metodo_pago, 
            COALESCE(p.estado_pago, 'N/A') AS estado_pago
        FROM reservas r
        JOIN pagosRealizados p ON r.id_reserva = p.id_reserva
        JOIN horarios h ON r.id_horario = h.id_horario
        JOIN servicios s ON h.servicio = s.id_servicio
        WHERE r.id_cliente = ? AND r.id_reserva = ?;
    """;


        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, idCliente);
            ps.setInt(2, idReserva);
            ResultSet rs = ps.executeQuery();

            boolean hayDatos = false;

            while (rs.next()) {
                hayDatos = true;
                System.out.println("Añadiendo servicio al PDF: " + rs.getInt("id_servicio"));

                table.addCell(new PdfPCell(new Paragraph(String.valueOf(rs.getInt("id_servicio")), textFont)));
                table.addCell(new PdfPCell(new Paragraph(rs.getString("nombre_servicio"), textFont)));
                table.addCell(new PdfPCell(new Paragraph(String.valueOf(rs.getInt("id_reserva")), textFont)));
                table.addCell(new PdfPCell(new Paragraph(String.valueOf(rs.getInt("id_pago")), textFont)));
                table.addCell(new PdfPCell(new Paragraph(rs.getString("fecha_pago"), textFont)));
                table.addCell(new PdfPCell(new Paragraph(rs.getString("metodo_pago"), textFont)));
                table.addCell(new PdfPCell(new Paragraph(rs.getString("estado_pago"), textFont)));
                String precio = String.format("%.2f", rs.getDouble("precio"));
                table.addCell(new PdfPCell(new Paragraph(precio, textFont)));
            }

            if (!hayDatos) {
                System.out.println("No hay datos para el cliente ID: " + idCliente);
                document.add(new Paragraph("No hay datos disponibles para este cliente.", textFont));
            } else {
                document.add(table);
            }

            document.close();  // Cerrar documento

        } catch (SQLException | DocumentException e) {
            e.printStackTrace();
        }
    }
}
