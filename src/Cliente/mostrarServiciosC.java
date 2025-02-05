package Cliente;

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

public class mostrarServiciosC {
    public JPanel mostrarServiciosPanel;
    private JPanel busquedaPanel;
    private JButton btnBuscar;
    private JTextField textFieldIdServicio;
    private JButton btnVolver;
    private JTable tableDatosServicio;

    public mostrarServiciosC() {
        DefaultTableModel modelTable = new DefaultTableModel();
        modelTable.addColumn("ID");
        modelTable.addColumn("NOMBRE");
        modelTable.addColumn("DESCRIPCION");
        modelTable.addColumn("PRECIO");
        tableDatosServicio.setModel(modelTable);

        mostrarServiciosPanel = new JPanel(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(tableDatosServicio);
        mostrarServiciosPanel.add(scrollPane, BorderLayout.CENTER);

        btnVolver = new JButton("Volver");
        mostrarServiciosPanel.add(btnVolver, BorderLayout.SOUTH);
        textFieldIdServicio = new JTextField(10);
        btnBuscar = new JButton("Buscar");
        busquedaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        busquedaPanel.add(textFieldIdServicio);
        busquedaPanel.add(btnBuscar);
        mostrarServiciosPanel.add(busquedaPanel, BorderLayout.NORTH);

        cargarDatos(modelTable, null);
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
                SwingUtilities.getWindowAncestor(mostrarServiciosPanel).dispose();
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idFiltro = textFieldIdServicio.getText().trim();
                cargarDatos((DefaultTableModel) tableDatosServicio.getModel(), idFiltro);
            }
        });
    }

    public static void cargarDatos(DefaultTableModel modelTable, String idFiltro) {
        System.out.println("Cargando datos en la tabla...");
        modelTable.setRowCount(0); // Limpia la tabla antes de agregar nuevas filas
        String query = "SELECT * FROM servicios";
        boolean usarFiltro = idFiltro != null && !idFiltro.isEmpty();
        if (usarFiltro) {
            query += " WHERE id_servicio = ?";
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
                        rs.getString("id_servicio"),
                        rs.getString("nombre_servicio"),
                        rs.getString("descripcion"),
                        rs.getString("precio")
                });
                rowCount++;
            }
            System.out.println("Datos cargados: " + rowCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
