package Register;

import FormularioUsuarios.*;
import Login.loginBookMe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class registerBookMe {
    public JPanel registerPanel;
    private JTextField textFieldNombre;
    private JTextField textFieldCorreo;
    private JPasswordField passwordField1;
    private JTextField textFieldRol;
    private JButton btnLogin;
    private JButton btnRegister;

    public registerBookMe() {
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuariosCRUD crud = new usuariosCRUD();
                String password = new String(passwordField1.getPassword());

                // Validaciones
                if (password.isEmpty() ||textFieldNombre.getText().isEmpty() || textFieldCorreo.getText().isEmpty() ||
                    textFieldRol.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor llene todos los campos", "Campos incompletos", JOptionPane.INFORMATION_MESSAGE);
                } else if (!textFieldRol.getText().equalsIgnoreCase("Empleado") && !textFieldRol.getText().equalsIgnoreCase("Cliente")) {
                    JOptionPane.showMessageDialog(null, "El rol debe ser 'Empleado' o 'Cliente'", "Rol incorrecto", JOptionPane.INFORMATION_MESSAGE);
                } else if (!validarCorreo(textFieldCorreo.getText())) {
                    JOptionPane.showMessageDialog(null, "El correo debe tener un formato válido (ejemplo: usuario@dominio.com)", "Correo incorrecto", JOptionPane.INFORMATION_MESSAGE);
                } else if (!textFieldRol.getText().matches("[a-zA-Z]+")) {
                    JOptionPane.showMessageDialog(null, "El rol solo puede contener letras", "Rol incorrecto", JOptionPane.INFORMATION_MESSAGE);
                } else if (!textFieldNombre.getText().matches("[a-zA-Z ]+")) {
                    JOptionPane.showMessageDialog(null, "El nombre solo puede contener letras y espacios", "Nombre incorrecto", JOptionPane.INFORMATION_MESSAGE);
                } else if (crud.existeCorreo(textFieldCorreo.getText())) {
                    JOptionPane.showMessageDialog(null, "El correo ya está registrado", "Correo duplicado", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Si todas las validaciones pasan, registrar el usuario
                    crud.ingresarUsuarios(
                            textFieldNombre.getText(),
                            textFieldCorreo.getText(),
                            password,
                            textFieldRol.getText()
                    );
                    JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente");
                    limpiarCampos();
                }
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir la ventana de inicio de sesión
                JFrame frame = new JFrame("Inicio de sesión");
                frame.setContentPane(new loginBookMe().loginPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(800, 600));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(registerPanel).dispose();
            }
        });
    }

    // Método para validar el formato del correo electrónico
    private boolean validarCorreo(String correo) {
        String regex = "^(?:(?:[A-Za-z0-9+_.-]+@gmail\\.com)|(?:[A-Za-z0-9+_.-]+@outlook\\.com)|(?:[A-Za-z0-9+_.-]+@epn\\.edu\\.ec))$";
        return correo.matches(regex);
    }
    private void limpiarCampos() {
        textFieldNombre.setText("");
        textFieldCorreo.setText("");
        passwordField1.setText("");
        textFieldRol.setText("");
    }
}