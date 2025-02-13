package FormularioUsuarios;

import Administrador.Usuarios_Gestion.gestionUsuarios;
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

public class subLeer {
    public JPanel leerPanel;
    private JTable datosTable;
    private JButton btnVolver;
    private JTextField textFieldId;
    private JButton btnBuscar;
    public JPanel panelBusqueda;

    public subLeer() {
        DefaultTableModel modelTable = new DefaultTableModel();
        modelTable.addColumn("ID");
        modelTable.addColumn("Nombre y Apellido");
        modelTable.addColumn("Correo");
        modelTable.addColumn("Contraseña");
        modelTable.addColumn("Rol");

        datosTable = new JTable(modelTable);
        leerPanel = new JPanel(new BorderLayout()); // Cambia el layout a BorderLayout
        JScrollPane scrollPane = new JScrollPane(datosTable);
        leerPanel.add(scrollPane, BorderLayout.CENTER); // Agrega el JScrollPane al centro del panel

        btnVolver = new JButton("Volver");
        leerPanel.add(btnVolver, BorderLayout.SOUTH); // Botón en la parte inferior

        textFieldId = new JTextField(10);
        btnBuscar = new JButton("Buscar");
        panelBusqueda = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelBusqueda.add(textFieldId);
        panelBusqueda.add(btnBuscar);
        leerPanel.add(panelBusqueda, BorderLayout.NORTH);

        // Cargar datos iniciales
        cargarDatos(modelTable, null);

        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Panel de gestión de usuarios");
                frame.setContentPane(new gestionUsuarios().gestionUsuariosPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(leerPanel).dispose();
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idFiltro = textFieldId.getText().trim();
                cargarDatos((DefaultTableModel) datosTable.getModel(), idFiltro);
            }
        });
    }

    public static void cargarDatos(DefaultTableModel modelTable, String idFiltro) {
        System.out.println("Cargando datos en la tabla...");
        modelTable.setRowCount(0); // Limpia la tabla antes de agregar nuevas filas

        String query = "SELECT * FROM usuarios";
        boolean usarFiltro = idFiltro != null && !idFiltro.isEmpty();
        if (usarFiltro) {
            query += " WHERE id = ?";
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
                        rs.getString("id"),
                        rs.getString("nombre_apellido"),
                        rs.getString("correo"),
                        rs.getString("contrasenia"),
                        rs.getString("rol")
                });
                rowCount++;
            }
            System.out.println("Datos cargados: " + rowCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
