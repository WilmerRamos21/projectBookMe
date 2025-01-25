import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class subEliminacion {
    private JTextField textFieldCedula;
    private JButton btnEliminar;
    private JButton btnVolver;
    public JPanel eliminacionPanel;

    public subEliminacion() {
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
                SwingUtilities.getWindowAncestor(eliminacionPanel).dispose();
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuariosCRUD usuariosCRUD = new usuariosCRUD();
                usuariosCRUD.eliminarUsuario(Integer.parseInt(textFieldCedula.getText()));
                JOptionPane.showMessageDialog(null, "Usuario Eliminado Correctamente");
            }
        });
    }
}
