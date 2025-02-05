package FormularioUsuarios;

import Administrador.Usuarios_Gestion.gestionUsuarios;

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
    private JLabel imgNuevoUsuario;

    public subRegister() {
        ImageIcon icono3 = new ImageIcon(getClass().getResource("/Images/Usuarios/nuevoUsuario.jpg"));
        Image imagen3 = icono3.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado3 = new ImageIcon(imagen3);
        imgNuevoUsuario.setIcon(iconoRedimensionado3);

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
                JFrame frame = new JFrame("Panel de gestión de usuarios");
                frame.setContentPane(new gestionUsuarios().gestionUsuariosPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
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
