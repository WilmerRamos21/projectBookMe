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

    public modificarEmpleado() {
        // Configurar el botón "Modificar"
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuariosCRUD eC = new usuariosCRUD();
                String password = new String(fielPass.getPassword());
                if (password.isEmpty() || textFieldId.getText().isEmpty() || textFieldNombre.getText().isEmpty() ||
                        textFieldCorreo.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor llene todos los campos", "Campos incompletos", JOptionPane.INFORMATION_MESSAGE);
                } else if (!textFieldId.getText().matches("[0-9]+")) {
                    JOptionPane.showMessageDialog(null, "La cédula solo puede contener números", "Cédula incorrecta", JOptionPane.INFORMATION_MESSAGE);
                } else if (!textFieldNombre.getText().matches("[a-zA-Z ]+")) {
                    JOptionPane.showMessageDialog(null, "El nombre solo puede contener letras y espacios", "Nombre incorrecto", JOptionPane.INFORMATION_MESSAGE);
                } else if (eC.existeCorreo(textFieldCorreo.getText())) {
                    JOptionPane.showMessageDialog(null, "El correo ya está registrado", "Correo duplicado", JOptionPane.INFORMATION_MESSAGE);
                } else if (!validarCorreo(textFieldCorreo.getText())) {
                    JOptionPane.showMessageDialog(null, "El correo debe tener un formato válido (ejemplo: usuario@dominio.com)", "Correo incorrecto", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    eC.modificarUsuarioEmpleado(textFieldNombre.getText(), textFieldCorreo.getText(), password, Integer.parseInt(textFieldId.getText()));
                    JOptionPane.showMessageDialog(null, "Usuario modificado correctamente");
                    limpiarCampos();
                }
            }

            // Método para validar el formato del correo
            private boolean validarCorreo(String correo) {
                String regex = "^(?:(?:[A-Za-z0-9+_.-]+@gmail\\.com)|(?:[A-Za-z0-9+_.-]+@outlook\\.com)|(?:[A-Za-z0-9+_.-]+@epn\\.edu\\.ec))$";
                return correo.matches(regex);
            }

            // Método para limpiar los campos del formulario
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
                JFrame frame = new JFrame();
                frame.setContentPane(new empleadoBookMe().empleadoPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(800, 600));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(modificarUsuarioPanel).dispose();
            }
        });
    }
}


