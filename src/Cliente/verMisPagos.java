package Cliente;

import Empleado.sesionCorreo;
import conexion.Conexion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class verMisPagos {
    public JPanel verMisPagosPanel;
    private JTable tableHistorialPagos;
    private JButton btnVolver;

    public verMisPagos() {
        int idUsuario = sesionCorreo.getID();
        System.out.println("ID: " + idUsuario);
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Pago");
        modelo.addColumn("ID Cliente");
        modelo.addColumn("ID Reserva");
        modelo.addColumn("Fecha Pago");
        modelo.addColumn("Método Pago");
        modelo.addColumn("Estado Pago");
        modelo.addColumn("Descripción");
        tableHistorialPagos.setModel(modelo);
        cargarDatos(modelo, idUsuario);

        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Panel del Cliente");
                frame.setContentPane(new clienteBookMe().clientePanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(verMisPagosPanel).dispose();
            }
        });
    }
    public static void cargarDatos(DefaultTableModel modelo, int idUsuario){

        String query = "SELECT * FROM pagosRealizados WHERE  id_cliente =?";

        try (Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, idUsuario);
            ResultSet rs = pst.executeQuery();
            int rowCount = 0;
            while (rs.next()) {
                modelo.addRow(new Object[]{
                        rs.getString("id_pago"),
                        rs.getString("id_cliente"),
                        rs.getString("id_reserva"),
                        rs.getString("fecha_pago"),
                        rs.getString("metodo_pago"),
                        rs.getString("estado_pago"),
                        rs.getString("descripcion")
                });
                rowCount++;
            }
            System.out.println("Datos cargados: " + rowCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
