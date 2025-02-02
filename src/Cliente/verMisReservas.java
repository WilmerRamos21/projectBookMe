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

public class verMisReservas {
    public JPanel misReservasPanel;
    private JTable tableMisReservas;
    private JButton btnVolver;

    public verMisReservas() {
        int idUsuario = sesionCorreo.getID();
        System.out.println("ID: " + idUsuario);

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Reserva");
        modelo.addColumn("ID Cliente");
        modelo.addColumn("ID Horario");
        modelo.addColumn("Fecha Reserva");
        modelo.addColumn("Observaciones");
        tableMisReservas.setModel(modelo);
        cargarDatos(modelo, idUsuario);



        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new clienteBookMe().clientePanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(800, 600));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(misReservasPanel).dispose();
            }
        });
    }
    public static void cargarDatos(DefaultTableModel modelo, int idUsuario){

        String query = "SELECT * FROM reservas WHERE  id_cliente =?";

        try (Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, idUsuario);
            ResultSet rs = pst.executeQuery();
            int rowCount = 0;
            while (rs.next()) {
                modelo.addRow(new Object[]{
                        rs.getString("id_reserva"),
                        rs.getString("id_cliente"),
                        rs.getString("id_horario"),
                        rs.getString("fecha_reserva"),
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
