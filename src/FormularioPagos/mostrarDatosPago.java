package FormularioPagos;
import Administrador.Pagos_Gestion.gestionPagos;
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

public class mostrarDatosPago {
    public JPanel mostrarPagosPanel;
    private JButton btnVolver;
    private JTable tableDatosPago;
    private JTextField textFieldIdPagos;
    private JButton btnBuscar;
    private JPanel busquedaPanel;

    public mostrarDatosPago() {
        DefaultTableModel modelTable = new DefaultTableModel();
        modelTable.addColumn("ID Pago");
        modelTable.addColumn("ID Cliente");
        modelTable.addColumn("ID Reserva");
        modelTable.addColumn("Fecha Pago");
        modelTable.addColumn("Método Pago");
        modelTable.addColumn("Estado Pago");
        modelTable.addColumn("Descripción");
        tableDatosPago.setModel(modelTable);

        mostrarPagosPanel = new JPanel(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(tableDatosPago);
        mostrarPagosPanel.add(scrollPane, BorderLayout.CENTER);

        btnVolver = new JButton("Volver");
        mostrarPagosPanel.add(btnVolver, BorderLayout.SOUTH);
        textFieldIdPagos = new JTextField(10);
        btnBuscar = new JButton("Buscar");
        busquedaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        busquedaPanel.add(textFieldIdPagos);
        busquedaPanel.add(btnBuscar);
        mostrarPagosPanel.add(busquedaPanel, BorderLayout.NORTH);

        cargarDatos(modelTable, null);



        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Panel de gestión de pagos");
                frame.setContentPane(new gestionPagos().gestionPagosPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(mostrarPagosPanel).dispose();
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idFiltro = textFieldIdPagos.getText().trim();
                cargarDatos((DefaultTableModel) tableDatosPago.getModel(), idFiltro);
            }
        });
    }
    public static void cargarDatos(DefaultTableModel modelTable, String idFiltro) {
        System.out.println("Cargando datos en la tabla...");
        modelTable.setRowCount(0); // Limpia la tabla antes de agregar nuevas filas
        String query = "SELECT * FROM pagosRealizados";
        boolean usarFiltro = idFiltro != null && !idFiltro.isEmpty();
        if (usarFiltro) {
            query += " WHERE id_pago = ?";
        }
        try (Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            if (usarFiltro) {
                pst.setString(1, idFiltro);
            }
            ResultSet rs = pst.executeQuery();
            int rowCount = 0;
            while (rs.next()) {
                modelTable.addRow(new Object[]{
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
