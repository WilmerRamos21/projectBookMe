package FormularioUsuarios;

import Usuarios_Gestion.gestionUsuarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class subRegister {
    private JTextField textFieldNombre;
    private JTextField textFieldCorreo;
    private JPasswordField JFieldContrasenia;
    private JTextField textFieldRol;
    private JButton btnRegistrarUsuario;
    private JButton btnRegresar;
    public JPanel subRegisterPanel;

    public subRegister() {
        btnRegistrarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuariosCRUD crud = new usuariosCRUD();
                String password = new String(JFieldContrasenia.getPassword());

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
        String regex = "^(?:(?:[A-Za-z0-9+_.-]+@gmail\\.com)|(?:[A-Za-z0-9+_.-]+@outlook\\.com)|(?:[A-Za-z0-9+_.-]+@epn\\.edu\\.ec))$";
        return correo.matches(regex);
    }
    private void limpiarCampos(){
        textFieldNombre.setText("");
        textFieldCorreo.setText("");
        JFieldContrasenia.setText("");
        textFieldRol.setText("");
    }
}
