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

public class mostrarHorarioC {
    public JPanel mostrarHorarioPanel;
    private JTextField textFieldIdHorario;
    private JButton btnBuscar;
    private JButton btnVolver;
    private JTable tableHorarios;
    private JPanel busquedaPanel;

    public mostrarHorarioC() {
        DefaultTableModel modelTable = new DefaultTableModel();
        modelTable.addColumn("ID Horario");
        modelTable.addColumn("ID Empleado");
        modelTable.addColumn("Dia");
        modelTable.addColumn("Hora Inicio");
        modelTable.addColumn("Hora Fin");
        modelTable.addColumn("ID Servicio");
        modelTable.addColumn("Estado");
        tableHorarios.setModel(modelTable);

        mostrarHorarioPanel = new JPanel(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(tableHorarios);
        mostrarHorarioPanel.add(scrollPane, BorderLayout.CENTER);

        btnVolver = new JButton("Volver");
        mostrarHorarioPanel.add(btnVolver, BorderLayout.SOUTH);
        textFieldIdHorario = new JTextField(10);
        btnBuscar = new JButton("Buscar");
        busquedaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        busquedaPanel.add(textFieldIdHorario);
        busquedaPanel.add(btnBuscar);
        mostrarHorarioPanel.add(busquedaPanel, BorderLayout.NORTH);

        cargarDatos((DefaultTableModel) tableHorarios.getModel(), null);

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
                SwingUtilities.getWindowAncestor(mostrarHorarioPanel).dispose();
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idFiltro = textFieldIdHorario.getText().trim();
                cargarDatos((DefaultTableModel) tableHorarios.getModel(), idFiltro);
            }
        });
    }

    public static void cargarDatos(DefaultTableModel modelTable, String idFiltro) {
        System.out.println("Cargando datos en la tabla...");
        modelTable.setRowCount(0); // Limpia la tabla antes de agregar nuevas filas
        String query = "SELECT id_horario, cedula_empleado, dia_semana, hora_inicio, hora_fin, servicio, estado FROM horarios WHERE estado = 'activo'";

        boolean usarFiltro = idFiltro != null && !idFiltro.isEmpty();
        if (usarFiltro) {
            query += " WHERE id_horario = ?";
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
                        rs.getString("id_horario"),
                        rs.getString("cedula_empleado"),
                        rs.getString("dia_semana"),
                        rs.getString("hora_inicio"),
                        rs.getString("hora_fin"),
                        rs.getString("servicio"),
                        rs.getString("estado")
                });
                rowCount++;
            }

            System.out.println("Datos cargados: " + rowCount);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
