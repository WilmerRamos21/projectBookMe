import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
        leerPanel.setLayout(new BorderLayout()); // Cambia el layout a BorderLayout
        JScrollPane scrollPane = new JScrollPane(datosTable);
        leerPanel.add(scrollPane, BorderLayout.CENTER); // Agrega el JScrollPane al centro del panel
        btnVolver = new JButton("Volver");
        leerPanel.add(btnVolver, BorderLayout.SOUTH); // Botón en la parte inferior
        JTextField textFieldCedula = new JTextField(15);
        JButton btnBuscar = new JButton("Buscar");
        JPanel panelBusqueda = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelBusqueda.add(textFieldCedula);
        panelBusqueda.add(btnBuscar);
        leerPanel.add(panelBusqueda, BorderLayout.NORTH);
        //Cargar datos
        cargarDatos(modelTable);
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
                String cedulaFiltrar = textFieldCedula.getText();
                cargarDatos((DefaultTableModel) datosTable.getModel());
            }
        });

    }    public void cargarDatos(DefaultTableModel modelTable) {
        usuariosCRUD uCRUD = new usuariosCRUD();
        ArrayList<Object[]> datos = uCRUD.mostrarDatosusuarios();

        System.out.println("Cargando datos en la tabla...");
        modelTable.setRowCount(0); // Limpia la tabla antes de agregar nuevas filas


        for (Object[] fila : datos) {
            modelTable.addRow(fila);
        }

        System.out.println("Datos cargados: " + modelTable.getRowCount());
    }


}



