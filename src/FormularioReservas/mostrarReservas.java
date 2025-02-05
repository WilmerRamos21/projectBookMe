package FormularioReservas;

import Administrador.Reservas_Gestion.gestionReservas;
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

public class mostrarReservas {
    public JPanel mostrarReservasPanel;
    private JPanel busquedaPanel;
    private JTextField textFieldIdReserva;
    private JButton btnBuscar;
    private JButton btnVolver;
    private JTable tableDatosReservas;

    public mostrarReservas() {
        DefaultTableModel modelTable = new DefaultTableModel();
        modelTable.addColumn("ID Reserva");
        modelTable.addColumn("ID Horario");
        modelTable.addColumn("Fecha Reserva");
        modelTable.addColumn("Estado Reserva");
        modelTable.addColumn("Observaciones");
        tableDatosReservas.setModel(modelTable);

        mostrarReservasPanel = new JPanel(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(tableDatosReservas);
        mostrarReservasPanel.add(scrollPane, BorderLayout.CENTER);

        btnVolver = new JButton("Volver");
        mostrarReservasPanel.add(btnVolver, BorderLayout.SOUTH);
        textFieldIdReserva = new JTextField(10);
        btnBuscar = new JButton("Buscar");
        busquedaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        busquedaPanel.add(textFieldIdReserva);
        busquedaPanel.add(btnBuscar);
        mostrarReservasPanel.add(busquedaPanel, BorderLayout.NORTH);

        cargarDatos(modelTable,null);

        btnVolver.addActionListener(e -> {
            JFrame frame = new JFrame("Panel de gestión de reservas");
            frame.setContentPane(new gestionReservas().gestionReservasPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setPreferredSize(new Dimension(1020, 640));
            frame.pack();
            frame.setVisible(true);
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idFiltro = textFieldIdReserva.getText().trim();
                cargarDatos((DefaultTableModel) tableDatosReservas.getModel(),idFiltro);
            }
        });
    }
    public static void cargarDatos(DefaultTableModel modelTable, String idFiltro) {
        System.out.println("Cargando datos en la tabla...");
        modelTable.setRowCount(0); // Limpia la tabla antes de agregar nuevas filas
        String query = "SELECT * FROM reservas";
        boolean usarFiltro = idFiltro != null && !idFiltro.isEmpty();
        if (usarFiltro) {
            query += " WHERE id_reserva = ?";
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
                        rs.getString("id_reserva"),
                        rs.getString("id_horario"),
                        rs.getString("fecha_reserva"),
                        rs.getString("estado_reserva"),
                        rs.getString("observaciones")
                });
                rowCount++;
            }
            System.out.println("Datos cargados: " + rowCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
