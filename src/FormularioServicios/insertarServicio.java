package FormularioServicios;

import Servicios_Gestion.gestionServicios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class insertarServicio {
    private JTextField textFieldIdServicio;
    private JTextField textFieldNombre;
    private JTextField textFieldDescripcion;
    private JTextField textFieldPrecio;
    private JButton btnInsertar;
    private JButton btnVolver;
    public JPanel ingresoServiciosPanel;

    public insertarServicio() {
        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serviciosCRUD servCRUD = new serviciosCRUD();
                servCRUD.ingresarServicio(Integer.parseInt(textFieldIdServicio.getText()),textFieldNombre.getText(),textFieldDescripcion.getText(),Integer.parseInt(textFieldPrecio.getText()));
                JOptionPane.showMessageDialog(null, "Servicio insertado correctamente");
            }
        });
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new gestionServicios().gestionServiciosPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(800, 600));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(ingresoServiciosPanel).dispose();
            }
        });
    }
}
