import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class subActualizacion {
    public JPanel actualizarPanel;
    private JTextField textFieldCedula;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JTextField textFieldCorreo;
    private JPasswordField JFielContrasenia;
    private JTextField textFieldTelefono;
    private JTextField textFieldRol;
    private JButton btnActualizar;
    private JButton btnVolver;

    public subActualizacion() {
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
                UC.modificarUsuarios(textFieldNombre.getText(),textFieldApellido.getText(),
                        textFieldCorreo.getText(),password,textFieldTelefono.getText(),textFieldRol.getText(), LocalDate.now(),Integer.parseInt(textFieldCedula.getText()));
                JOptionPane.showMessageDialog(actualizarPanel, "Datos actualizados exitosamente");
            }
        });
    }
}
