package FormularioUsuarios;

import Administrador.Usuarios_Gestion.gestionUsuarios;

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
    private JButton btnActualizar;
    private JButton btnVolver;
    private JComboBox comboBoxRol;
    private JLabel imgModificar;

    public subActualizacion() {
        ImageIcon icono1 = new ImageIcon(getClass().getResource("/Images/Usuarios/modificacionUsuarios.jpg"));
        Image imagen1 = icono1.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado1 = new ImageIcon(imagen1);
        imgModificar.setIcon(iconoRedimensionado1);

        comboBoxRol.addItem("Admin");
        comboBoxRol.addItem("Empleado");
        comboBoxRol.addItem("Cliente");
        comboBoxRol.setVisible(true);

        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Panel de gestión de usuarios");
                frame.setContentPane(new gestionUsuarios().gestionUsuariosPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
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
                try{
                    if (password.isEmpty() || textFieldId.getText().isEmpty() || textFieldNombre.getText().isEmpty() ||
                            textFieldCorreo.getText().isEmpty() ) {
                        JOptionPane.showMessageDialog(null, "Por favor llene todos los campos", "Campos incompletos", JOptionPane.INFORMATION_MESSAGE);
                    } else if (!comboBoxRol.getSelectedItem().toString().equals("Cliente")&& !comboBoxRol.getSelectedItem().toString().equals("Empleado")) {
                        JOptionPane.showMessageDialog(null, "El rol debe ser 'Empleado' o 'Cliente'", "Rol incorrecto", JOptionPane.INFORMATION_MESSAGE);
                    } else if (!validarCorreo(textFieldCorreo.getText())) {
                        JOptionPane.showMessageDialog(null, "El correo debe tener un formato válido (ejemplo: usuario@dominio.com)", "Correo incorrecto", JOptionPane.INFORMATION_MESSAGE);
                    } else if (!textFieldId.getText().matches("[0-9]+]")) {
                        JOptionPane.showMessageDialog(null, "El ID solo puede contener números", "ID incorrecto", JOptionPane.INFORMATION_MESSAGE);
                    } else if (!textFieldNombre.getText().matches("[a-zA-Z ]+")) {
                        JOptionPane.showMessageDialog(null, "El nombre solo puede contener letras y espacios", "Nombre incorrecto", JOptionPane.INFORMATION_MESSAGE);
                    } else{

                        UC.modificarUsuarios(
                                textFieldNombre.getText(),
                                textFieldCorreo.getText(),
                                password,
                                comboBoxRol.getSelectedItem().toString(),
                                Integer.parseInt(textFieldId.getText())
                        );
                        JOptionPane.showMessageDialog(actualizarPanel, "Datos actualizados exitosamente","Ingreso exitosamente", JOptionPane.INFORMATION_MESSAGE);
                        limpiarCampos();
                    }
                }catch (NumberFormatException ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "El ID es incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al modificar el usuario", "Error", JOptionPane.ERROR_MESSAGE);
                }
        }
            //Metodo para validar los campos de correo
            private boolean validarCorreo(String correo) {
                String verfCorreo = "^(?:([A-Za-z0-9+_.-]+@gmail\\.com)|([A-Za-z0-9+_.-]+@outlook\\.com)|(?:[A-Za-z0-9+_.-]+@epn\\.edu\\.ec))$";
                return correo.matches(verfCorreo);
            }
            private void limpiarCampos() {
                textFieldId.setText("");
                textFieldNombre.setText("");
                textFieldCorreo.setText("");
                JFielContrasenia.setText("");
            }
        });
    }
}
