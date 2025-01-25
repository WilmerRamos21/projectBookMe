import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class subRegister {
    private JTextField textFieldCedula;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JTextField textFieldCorreo;
    private JPasswordField JFieldContrasenia;
    private JTextField textFieldTelefono;
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
                crud.ingresarUsuarios(Integer.parseInt(textFieldCedula.getText()), textFieldNombre.getText(), textFieldApellido.getText(),
                        textFieldCorreo.getText(), password, textFieldTelefono.getText(), textFieldRol.getText(), LocalDate.now());
                JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente");
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
}
