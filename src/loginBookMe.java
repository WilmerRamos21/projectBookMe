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
                        JOptionPane.showMessageDialog(null,"Bienvenido "+rs.getString("rol"));
                        switch (rs.getString("rol")) {
                            case "Administrador":
                        }
                    }else {
                        JOptionPane.showMessageDialog(null,"Usuario no encontrado");
                    }
                }catch (Exception a){
                    a.printStackTrace();
                }
            }
        });
    }
}
