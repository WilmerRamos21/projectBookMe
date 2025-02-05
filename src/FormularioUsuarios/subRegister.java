package FormularioUsuarios;

import Usuarios_Gestion.gestionUsuarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class subRegister {
    private JTextField textFieldNombre;
    private JTextField textFieldCorreo;
    private JPasswordField JFieldContrasenia;
    private JButton btnRegistrarUsuario;
    private JButton btnRegresar;
    public JPanel subRegisterPanel;
    private JComboBox comboBoxRol;

    public subRegister() {
        comboBoxRol.addItem("Admin");
        comboBoxRol.addItem("Empleado");
        comboBoxRol.addItem("Cliente");
        comboBoxRol.setVisible(true);
        btnRegistrarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuariosCRUD crud = new usuariosCRUD();
                String password = new String(JFieldContrasenia.getPassword());
                try{
                    if (password.isEmpty() ||textFieldNombre.getText().isEmpty() || textFieldCorreo.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Por favor llene todos los campos", "Campos incompletos", JOptionPane.INFORMATION_MESSAGE);
                    } else if (!validarCorreo(textFieldCorreo.getText())) {
                        JOptionPane.showMessageDialog(null, "El correo debe tener un formato válido (ejemplo: usuario@dominio.com)", "Correo incorrecto", JOptionPane.INFORMATION_MESSAGE);
                    } else if (!textFieldNombre.getText().matches("[a-zA-Z ]+")) {
                        JOptionPane.showMessageDialog(null, "El nombre solo puede contener letras y espacios", "Nombre incorrecto", JOptionPane.INFORMATION_MESSAGE);
                    } else if (crud.existeCorreo(textFieldCorreo.getText())) {
                        JOptionPane.showMessageDialog(null, "El correo ya está registrado", "Correo duplicado", JOptionPane.INFORMATION_MESSAGE);
                        crud.ingresarUsuarios(
                                textFieldNombre.getText(),
                                textFieldCorreo.getText(),
                                password,
                                comboBoxRol.getActionCommand()
                        );
                        JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente","Ingreso exitosamente", JOptionPane.INFORMATION_MESSAGE);
                        limpiarCampos();
                    }
                }catch(NumberFormatException e0){
                    e0.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ingrese valores númericos", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al ingresar el usuario", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new gestionUsuarios().gestionUsuariosPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(800, 600));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(subRegisterPanel).dispose();

            }
        });
    }
    //Metodo para validar los campos de correo
    private boolean validarCorreo(String correo) {
        String verfCorreo = "^(?:([A-Za-z0-9+_.-]+@gmail\\.com)|([A-Za-z0-9+_.-]+@outlook\\.com)|([A-Za-z0-9+_.-]+@epn\\.edu\\.ec))$";
        return correo.matches(verfCorreo);
    }
    private void limpiarCampos(){
        textFieldNombre.setText("");
        textFieldCorreo.setText("");
        JFieldContrasenia.setText("");
    }
}
