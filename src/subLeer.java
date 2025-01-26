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
    private JTextField textFieldCedula;
    private JButton btnBuscar;
    public JPanel panelBusqueda;

    public subLeer() {
        DefaultTableModel modelTable = new DefaultTableModel();
        modelTable.addColumn("Cedula");
        modelTable.addColumn("Nombre");
        modelTable.addColumn("Apellido");
        modelTable.addColumn("Correo");
        modelTable.addColumn("Contraseña");
        modelTable.addColumn("Telefono");
        modelTable.addColumn("Rol");

        datosTable = new JTable(modelTable);
        leerPanel = new JPanel(new BorderLayout()); // Cambia el layout a BorderLayout
        JScrollPane scrollPane = new JScrollPane(datosTable);
        leerPanel.add(scrollPane, BorderLayout.CENTER); // Agrega el JScrollPane al centro del panel

        btnVolver = new JButton("Volver");
        leerPanel.add(btnVolver, BorderLayout.SOUTH); // Botón en la parte inferior

        textFieldCedula = new JTextField(15);
        btnBuscar = new JButton("Buscar");
        panelBusqueda = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelBusqueda.add(textFieldCedula);
        panelBusqueda.add(btnBuscar);
        leerPanel.add(panelBusqueda, BorderLayout.NORTH);

        // Cargar datos iniciales
        cargarDatos(modelTable, null);

        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new gestionUsuarios().gestionUsuariosPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(800, 600));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(leerPanel).dispose();
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedulaFiltro = textFieldCedula.getText().trim();
                cargarDatos((DefaultTableModel) datosTable.getModel(), cedulaFiltro);
            }
        });
    }

    public static void cargarDatos(DefaultTableModel modelTable, String cedulaFiltro) {
        System.out.println("Cargando datos en la tabla...");
        modelTable.setRowCount(0); // Limpia la tabla antes de agregar nuevas filas

        String query = "SELECT * FROM usuarios";
        boolean usarFiltro = cedulaFiltro != null && !cedulaFiltro.isEmpty();
        if (usarFiltro) {
            query += " WHERE cedula = ?";
        }

        try (Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            if (usarFiltro) {
                pst.setString(1, cedulaFiltro);
            }
            ResultSet rs = pst.executeQuery();
            int rowCount = 0;
            while (rs.next()) {
                modelTable.addRow(new Object[]{
                        rs.getString("cedula"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("correo"),
                        rs.getString("contrasenia"),
                        rs.getString("telefono"),
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
