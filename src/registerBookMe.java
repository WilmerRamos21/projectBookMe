import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class registerBookMe {
    public JPanel registerPanel;
    private JTextField textFieldCedula;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JTextField textFieldCorreo;
    private JPasswordField passwordField1;
    private JTextField textFieldTelefono;
    private JTextField textFieldRol;
    private JButton btnLogin;
    private JButton btnRegister;

    public registerBookMe() {
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuariosCRUD crud = new usuariosCRUD();
                String password = new String(passwordField1.getPassword());
                crud.ingresarUsuarios(Integer.parseInt(textFieldCedula.getText()),textFieldNombre.getText(),textFieldApellido.getText(),
                        textFieldCorreo.getText(),password,textFieldTelefono.getText(),textFieldRol.getText(), LocalDate.now());
                JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente");
            }
        });
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
}
