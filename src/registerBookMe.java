import javax.swing.*;
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
                String hashedPassword = usuariosCRUD.hashPassword(password);
                String telefono = textFieldTelefono.getText().replaceAll("[^\\d]", ""); // Elimina caracteres no numéricos
                if (telefono.length() > 10) {
                    JOptionPane.showMessageDialog(null, "El número de teléfono es demasiado largo.");
                    return;
                }
                crud.ingresarUsuarios(Integer.parseInt(textFieldCedula.getText()),textFieldNombre.getText(),textFieldApellido.getText(),
                        textFieldCorreo.getText(),hashedPassword,telefono,textFieldRol.getText(), LocalDate.now());
            }
        });
    }
}
