package Login;
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

    public loginBookMe() {
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

                Connection con;
                try {
                    con = Conexion.getConnection();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                try{
                    String rol = textFieldRol.getText();
                    String correo = textFieldCorreo.getText();
                    String password = String.valueOf(passwordField2.getPassword());

                    if (rol.isEmpty() || correo.isEmpty() || password.isEmpty()) {
                        JOptionPane.showMessageDialog(null,"Debe llenar los campos vacios.");
                    }
                    String sql = "SELECT rol FROM usuarios WHERE correo = ? AND contrasenia = ?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, correo);
                    ps.setString(2, password);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        String rolDB = rs.getString("rol"); // Obtiene el rol de la base de datos

                        // Compara el rol ingresado con el rol de la base de datos
                        if (!rol.equalsIgnoreCase(rolDB)) {
                            JOptionPane.showMessageDialog(null, "El rol ingresado no coincide con el registrado.");
                            return; // Sale del método sin abrir ninguna ventana
                        }
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
                                JOptionPane.showMessageDialog(null,"Rol desconocido");
                        }
                    }else {
                        JOptionPane.showMessageDialog(null,"Usuario no encontrado");
                    }
                }catch (Exception a){
                    a.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Error inesperado.");
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