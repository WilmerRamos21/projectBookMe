package Empleado;

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

public class mostrarDatosE {
    public JPanel datosEPanel;
    private JTable tableUsuario;
    private JButton btnVolver;

    public mostrarDatosE() {
        String correo = sesionCorreo.getCorreo();
        System.out.println("Correo en sesión en mostrarDatosE: " + correo);

        if (correo == null || correo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: No hay un usuario autenticado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Configurar el modelo de la tabla
        DefaultTableModel modelTable = new DefaultTableModel();
        modelTable.addColumn("ID");
        modelTable.addColumn("Nombre y Apellido");
        modelTable.addColumn("Correo");
        modelTable.addColumn("Contraseña");
        modelTable.addColumn("Rol");
        tableUsuario.setModel(modelTable);
        cargarDatos(modelTable, correo);
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Panel de gestión del empleado");
                frame.setContentPane(new empleadoBookMe().empleadoPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(datosEPanel).dispose();
            }
        });
}
    public static void cargarDatos(DefaultTableModel modelTable, String correo) {
        System.out.println("Cargando datos del usuario autenticado...");
        System.out.println("Correo del usuario: " + correo);


        String query = "SELECT * FROM usuarios WHERE correo = ?";
        System.out.println("Consulta SQL: " + query);

        try (Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, correo);

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
