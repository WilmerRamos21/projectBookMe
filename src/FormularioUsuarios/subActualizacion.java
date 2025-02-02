package FormularioUsuarios;

import Usuarios_Gestion.gestionUsuarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class subActualizacion {
    public JPanel actualizarPanel;
    private JTextField textFieldId;
    private JTextField textFieldNombre;
    private JTextField textFieldCorreo;
    private JPasswordField JFielContrasenia;
    private JTextField textFieldRol;
    private JButton btnActualizar;
    private JButton btnVolver;

    public subActualizacion() {
        // Simulación de la obtención del rol del usuario autenticado// Debes implementar esta función

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
                SwingUtilities.getWindowAncestor(actualizarPanel).dispose();
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuariosCRUD UC = new usuariosCRUD();
                String password = new String(JFielContrasenia.getPassword());
                if (password.isEmpty() || textFieldId.getText().isEmpty() || textFieldNombre.getText().isEmpty() ||
                        textFieldCorreo.getText().isEmpty() ||
                        textFieldRol.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor llene todos los campos", "Campos incompletos", JOptionPane.INFORMATION_MESSAGE);
                } else if (textFieldId.getText().length() != 10) {
                    JOptionPane.showMessageDialog(null, "La cédula debe tener 10 dígitos", "Cédula incorrecta", JOptionPane.INFORMATION_MESSAGE);
                } else if (!textFieldRol.getText().equalsIgnoreCase("empleado") && !textFieldRol.getText().equalsIgnoreCase("cliente")) {
                    JOptionPane.showMessageDialog(null, "El rol debe ser 'empleado' o 'cliente'", "Rol incorrecto", JOptionPane.INFORMATION_MESSAGE);
                } else if (!validarCorreo(textFieldCorreo.getText())) {
                    JOptionPane.showMessageDialog(null, "El correo debe tener un formato válido (ejemplo: usuario@dominio.com)", "Correo incorrecto", JOptionPane.INFORMATION_MESSAGE);
                } else if (!textFieldId.getText().matches("[0-9]+")) {
                    JOptionPane.showMessageDialog(null, "La cédula solo puede contener números", "Cédula incorrecta", JOptionPane.INFORMATION_MESSAGE);
                } else if (!textFieldRol.getText().matches("[a-zA-Z]+")) {
                    JOptionPane.showMessageDialog(null, "El rol solo puede contener letras", "Rol incorrecto", JOptionPane.INFORMATION_MESSAGE);
                } else if (!textFieldNombre.getText().matches("[a-zA-Z ]+")) {
                    JOptionPane.showMessageDialog(null, "El nombre solo puede contener letras y espacios", "Nombre incorrecto", JOptionPane.INFORMATION_MESSAGE);
                } else if (UC.existeCorreo(textFieldCorreo.getText())) {
                    JOptionPane.showMessageDialog(null, "El correo ya está registrado", "Correo duplicado", JOptionPane.INFORMATION_MESSAGE);
                } else {

                UC.modificarUsuarios(
                        textFieldNombre.getText(),
                        textFieldCorreo.getText(),
                        password,
                        textFieldRol.getText(), // Aunque esté deshabilitado, el valor sigue siendo accesible
                        Integer.parseInt(textFieldId.getText())
                );

                JOptionPane.showMessageDialog(actualizarPanel, "Datos actualizados exitosamente");
                limpiarCampos();

            }
        }
            //Metodo para validar los campos de correo
            private boolean validarCorreo(String correo) {
                String regex = "^(?:(?:[A-Za-z0-9+_.-]+@gmail\\.com)|(?:[A-Za-z0-9+_.-]+@outlook\\.com)|(?:[A-Za-z0-9+_.-]+@epn\\.edu\\.ec))$";
                return correo.matches(regex);
            }
            private void limpiarCampos() {
                textFieldId.setText("");
                textFieldNombre.setText("");
                textFieldCorreo.setText("");
                JFielContrasenia.setText("");
                textFieldRol.setText("");
            }
        });
    }
}
