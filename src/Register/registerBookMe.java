package Register;

import FormularioUsuarios.*;
import Login.loginBookMe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registerBookMe {
    public JPanel registerPanel;
    private JTextField textFieldNombre;
    private JTextField textFieldCorreo;
    private JPasswordField passwordField1;
    private JButton btnLogin;
    private JButton btnRegister;
    private JComboBox comboBoxRol;

    public registerBookMe() {
        comboBoxRol.addItem("Empleado");
        comboBoxRol.addItem("Cliente");
        comboBoxRol.setVisible(true);
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuariosCRUD crud = new usuariosCRUD();
                String password = new String(passwordField1.getPassword());

                try{
                    // Validaciones
                    if (password.isEmpty() ||textFieldNombre.getText().isEmpty() || textFieldCorreo.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Por favor llene todos los campos", "Campos incompletos", JOptionPane.INFORMATION_MESSAGE);
                    } else if (!comboBoxRol.getSelectedItem().toString().equals("Cliente") && !comboBoxRol.getSelectedItem().toString().equals("Empleado")) {
                        JOptionPane.showMessageDialog(null, "El rol debe ser 'Empleado' o 'Cliente'", "Rol incorrecto", JOptionPane.INFORMATION_MESSAGE);
                    } else if (!validarCorreo(textFieldCorreo.getText())) {
                        JOptionPane.showMessageDialog(null, "El correo debe tener un formato válido (ejemplo: usuario@dominio.com)", "Correo incorrecto", JOptionPane.INFORMATION_MESSAGE);
                    } else if (!textFieldNombre.getText().matches("[a-zA-Z ]+")) {
                        JOptionPane.showMessageDialog(null, "El nombre solo puede contener letras y espacios", "Nombre incorrecto", JOptionPane.INFORMATION_MESSAGE);
                    } else if (crud.existeCorreo(textFieldCorreo.getText())) {
                        JOptionPane.showMessageDialog(null, "El correo ya está registrado", "Correo duplicado", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        crud.ingresarUsuarios(
                                textFieldNombre.getText(),
                                textFieldCorreo.getText(),
                                password,
                                comboBoxRol.getSelectedItem().toString()
                        );
                        JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente","Registro exitosamente", JOptionPane.INFORMATION_MESSAGE);
                        limpiarCampos();
                    }
                }catch (NumberFormatException exception){
                    exception.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ingrese valores númericos", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al ingresar el usuario", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir la ventana de inicio de sesión
                JFrame frame = new JFrame("Inicio de sesión a BookMe");
                frame.setContentPane(new loginBookMe().loginPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(registerPanel).dispose();
            }
        });
    }

    // Metodo para verificar si el correo exite
    private boolean validarCorreo(String correo) {
        String verfCorreo = "^(?:([A-Za-z0-9+_.-]+@gmail\\.com)|([A-Za-z0-9+_.-]+@outlook\\.com)|(?:[A-Za-z0-9+_.-]+@epn\\.edu\\.ec))$";
        return correo.matches(verfCorreo);
    }
    private void limpiarCampos() {
        textFieldNombre.setText("");
        textFieldCorreo.setText("");
        passwordField1.setText("");
    }
}