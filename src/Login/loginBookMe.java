package Login;
import Empleado.sesionCorreo;
import FormularioUsuarios.usuariosCRUD;
import Register.registerBookMe;
import Cliente.clienteBookMe;
import Empleado.empleadoBookMe;
import Administrador.adminBookMe;
import conexion.Conexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginBookMe {
    private JTextField textFieldRol;
    private JTextField textFieldCorreo;
    private JPasswordField passwordField2;
    public JPanel loginPanel;
    private JButton btnLogin;
    private JButton btnResgister;
    private JComboBox comboBoxRol;


    public loginBookMe() {

        comboBoxRol.addItem("Admin");
        comboBoxRol.addItem("Empleado");
        comboBoxRol.addItem("Cliente");
        comboBoxRol.setVisible(true);
        btnResgister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Registro de usuario a BookMe");
                frame.setContentPane(new registerBookMe().registerPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(loginPanel).dispose();
            }

        });
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Connection con = null;
                try {
                    con = Conexion.getConnection();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                try{
                    String rol = comboBoxRol.getSelectedItem().toString();
                    String correo = textFieldCorreo.getText();
                    String password = String.valueOf(passwordField2.getPassword());

                    String sql = "SELECT id, rol, contrasenia FROM usuarios WHERE correo = ?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, correo);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        int id = rs.getInt("id");
                        String rolDB = rs.getString("rol"); // Obtiene el rol de la base de datos
                        String storedHashedPass = rs.getString("contrasenia");// Obtiene la contraseña almacenda en la BDD

                        // Compara el rol ingresado con el rol de la base de datos
                        if (!rol.equalsIgnoreCase(rolDB)) {
                            JOptionPane.showMessageDialog(null, "El rol ingresado no coincide con el registrado.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        //Compara la contraseña hasheada ingresada por el usario con la almacenada en la BDD
                        usuariosCRUD usuC = new usuariosCRUD();
                        if (usuC.checkPassword(password, storedHashedPass)) {
                            System.out.println("Usuario encontrado");
                        }
                        //Almacena los datos del usaurio para luego usarlos en el funcionamiento del programa
                        sesionCorreo.setCorreo(correo);
                        sesionCorreo.setID(id);
                        System.out.println("Correo guardado en sesión: " + sesionCorreo.getCorreo());
                        System.out.println("Id guardado en sesión: " + sesionCorreo.getID());

                        rol = rs.getString("rol");

                        JOptionPane.showMessageDialog(null,"Bienvenido "+rs.getString("rol"));
                        switch (rol.toLowerCase()) {
                            case "admin":
                                JFrame frame = new JFrame("Administrador");
                                frame.setContentPane(new adminBookMe().adminPanel);
                                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                frame.setSize(800, 600);
                                frame.setPreferredSize(new Dimension(1020, 640));
                                frame.pack();
                                frame.setVisible(true);
                                SwingUtilities.getWindowAncestor(loginPanel).dispose();
                                break;
                            case "empleado":
                                JFrame frame2 = new JFrame("Empleado");
                                frame2.setContentPane(new empleadoBookMe().empleadoPanel);
                                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                frame2.setSize(800, 600);
                                frame2.setPreferredSize(new Dimension(1020, 640));
                                frame2.pack();
                                frame2.setVisible(true);
                                SwingUtilities.getWindowAncestor(loginPanel).dispose();
                                break;
                            case "cliente":
                                JFrame frame3 = new JFrame("Cliente");
                                frame3.setContentPane(new clienteBookMe().clientePanel);
                                frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                frame3.setSize(800, 600);
                                frame3.setPreferredSize(new Dimension(1020, 640));
                                frame3.pack();
                                frame3.setVisible(true);
                                SwingUtilities.getWindowAncestor(loginPanel).dispose();
                                break;
                            default:
                                JOptionPane.showMessageDialog(null,"Rol desconocido","Error",JOptionPane.ERROR_MESSAGE);
                        }
                    }else {
                        JOptionPane.showMessageDialog(null,"Usuario no encontrado","Error",JOptionPane.ERROR_MESSAGE);
                    }
                }catch (Exception a){
                    a.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Error inesperado.","Error",JOptionPane.ERROR_MESSAGE);
                } finally {
                    try {
                        if (con != null) {
                            con.close();
                        }
                    }catch (SQLException a){
                        a.printStackTrace();
                    }
                }
            }
        });
    }
}