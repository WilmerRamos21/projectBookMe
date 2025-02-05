package FormularioServicios;

import Administrador.Servicios_Gestion.gestionServicios;

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
                JFrame frame = new JFrame("Panel de gestión de servicios");
                frame.setContentPane(new gestionServicios().gestionServiciosPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(modificarServicioPanel).dispose();
            }
        });
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(textFieldNombre.getText().isEmpty() || textFieldDescripcion.getText().isEmpty() || textFieldPrecio.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Debe llenar los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (!textFieldNombre.getText().matches("[a-zA-Z ]+")) {
                        JOptionPane.showMessageDialog(null, "El nombre solo puede contener letras y espacios", "Nombre incorrecto", JOptionPane.ERROR_MESSAGE);
                    } else if(!textFieldPrecio.getText().matches("^[0-9]+(\\.[0-9]{1,2})?$")) {
                        JOptionPane.showMessageDialog(null, "El campo de precio solo debe ingresar valores númericos", "Precio incorrecto", JOptionPane.ERROR_MESSAGE);
                    } else if(!textFieldIdServicio.getText().matches("[0-9]+")) {
                        JOptionPane.showMessageDialog(null,"El ID solo recibe valores númericos", "ID incorrecto", JOptionPane.ERROR_MESSAGE);
                    } else{
                        serviciosCRUD servCRUD = new serviciosCRUD();
                        servCRUD.modifcarServicio(textFieldNombre.getText(),textFieldDescripcion.getText(),Integer.parseInt(textFieldPrecio.getText()),Integer.parseInt(textFieldIdServicio.getText()));
                        JOptionPane.showMessageDialog(null, "Servicio modificado correctamente","Modificar",JOptionPane.INFORMATION_MESSAGE);
                        textFieldNombre.setText("");
                        textFieldDescripcion.setText("");
                        textFieldPrecio.setText("");
                        textFieldIdServicio.setText("");}
                } catch (NumberFormatException ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,"Error en el formato de los campos númericos. Por favor ingrese datos válidos","Error",JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Error al modificar el servicio","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
