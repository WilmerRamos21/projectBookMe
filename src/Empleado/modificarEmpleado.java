package Empleado;

import FormularioUsuarios.usuariosCRUD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class modificarEmpleado {
    public JPanel modificarUsuarioPanel;
    private JTextField textFieldId;
    private JTextField textFieldNombre;
    private JTextField textFieldCorreo;
    private JPanel formEmpleadoPanel;
    private JButton btnModificar;
    private JPasswordField fielPass;
    private JButton btnVolver;
    private JLabel imgPerfil;

    public modificarEmpleado() {
        ImageIcon icono5 = new ImageIcon(getClass().getResource("/Images/modificarPerfil.png"));
        Image imagen5 = icono5.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado5 = new ImageIcon(imagen5);
        imgPerfil.setIcon(iconoRedimensionado5);

        // Configurar el botón "Modificar"
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    usuariosCRUD eC = new usuariosCRUD();
                    String password = new String(fielPass.getPassword());
                    if (password.isEmpty() || textFieldId.getText().isEmpty() || textFieldNombre.getText().isEmpty() ||
                            textFieldCorreo.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Por favor llene todos los campos", "Campos incompletos", JOptionPane.INFORMATION_MESSAGE);
                    } else if (!textFieldId.getText().matches("[0-9]+]")) {
                        JOptionPane.showMessageDialog(null, "El ID solo puede contener números", "ID incorrecto", JOptionPane.INFORMATION_MESSAGE);
                    } else if (!textFieldNombre.getText().matches("[a-zA-Z ]+")) {
                        JOptionPane.showMessageDialog(null, "El nombre solo puede contener letras y espacios", "Nombre incorrecto", JOptionPane.INFORMATION_MESSAGE);
                    } else if (!validarCorreo(textFieldCorreo.getText())) {
                        JOptionPane.showMessageDialog(null, "El correo debe tener un formato válido (ejemplo: usuario@dominio.com)", "Correo incorrecto", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        eC.modificarUsuarioEmpleado(textFieldNombre.getText(), textFieldCorreo.getText(), password, Integer.parseInt(textFieldId.getText()));
                        JOptionPane.showMessageDialog(null, "Usuario modificado correctamente", "Usuario modificado correctamente", JOptionPane.INFORMATION_MESSAGE);
                        limpiarCampos();
                    }
                } catch (NumberFormatException ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "El ID es incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al modificar el usuario", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            // validacion del formato de correo
            private boolean validarCorreo(String correo) {
                String regex = "^(?:([A-Za-z0-9+_.-]+@gmail\\.com)|(?:[A-Za-z0-9+_.-]+@outlook\\.com)|([A-Za-z0-9+_.-]+@epn\\.edu\\.ec))$";
                return correo.matches(regex);
            }

            // Metodo para limpiar los campos
            private void limpiarCampos() {
                textFieldId.setText("");
                textFieldNombre.setText("");
                textFieldCorreo.setText("");
                fielPass.setText("");
            }
        });
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
                SwingUtilities.getWindowAncestor(modificarUsuarioPanel).dispose();
            }
        });
    }
}


