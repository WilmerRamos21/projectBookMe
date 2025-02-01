package FormularioServicios;

import Servicios_Gestion.gestionServicios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class modificarServicio {
    public JPanel modificarServicioPanel;
    private JTextField textFieldIdServicio;
    private JTextField textFieldNombre;
    private JTextField textFieldDescripcion;
    private JTextField textFieldPrecio;
    private JButton btnModificar;
    private JButton btnVolver;

    public modificarServicio() {
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
                SwingUtilities.getWindowAncestor(modificarServicioPanel).dispose();
            }
        });
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serviciosCRUD servCRUD = new serviciosCRUD();
                servCRUD.modifcarServicio(textFieldNombre.getText(),textFieldDescripcion.getText(),Integer.parseInt(textFieldPrecio.getText()),Integer.parseInt(textFieldIdServicio.getText()));
                JOptionPane.showMessageDialog(null, "Servicio modificado correctamente","Modificar",JOptionPane.INFORMATION_MESSAGE);
                textFieldNombre.setText("");
                textFieldDescripcion.setText("");
                textFieldPrecio.setText("");
                textFieldIdServicio.setText("");
            }
        });
    }
}
