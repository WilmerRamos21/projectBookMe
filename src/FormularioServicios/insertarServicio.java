package FormularioServicios;

import Administrador.Servicios_Gestion.gestionServicios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class insertarServicio {
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
                try{
                    if(textFieldNombre.getText().isEmpty() || textFieldDescripcion.getText().isEmpty() || textFieldPrecio.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Debe llenar los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (!textFieldNombre.getText().matches("[a-zA-Z ]+")) {
                        JOptionPane.showMessageDialog(null, "El nombre solo puede contener letras y espacios", "Nombre incorrecto", JOptionPane.ERROR_MESSAGE);
                    } else if(!textFieldPrecio.getText().matches("^[0-9]+(\\.[0-9]{1,2})?$")) {
                        JOptionPane.showMessageDialog(null, "El campo de precio solo debe ingresar valores númericos", "Precio incorrecto", JOptionPane.ERROR_MESSAGE);
                    } else{
                        serviciosCRUD servCRUD = new serviciosCRUD();
                        servCRUD.ingresarServicio(textFieldNombre.getText(),
                                textFieldDescripcion.getText(),
                                Integer.parseInt(textFieldPrecio.getText()));
                        JOptionPane.showMessageDialog(null, "Servicio ingresado correctamente", "Servicio iniciado", JOptionPane.INFORMATION_MESSAGE);
                        textFieldNombre.setText("");
                        textFieldDescripcion.setText("");
                        textFieldPrecio.setText("");
                    }
                }catch (NumberFormatException e1){
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Los precios solo aceptan valores números", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception e0){
                    e0.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado. Por favor intente de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
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
                SwingUtilities.getWindowAncestor(ingresoServiciosPanel).dispose();
            }
        });
    }
}
