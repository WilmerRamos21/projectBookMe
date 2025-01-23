import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminBookMe {
    public JPanel adminPanel;
    private JButton btnLogOut;
    private JButton btnGestionUsuarios;
    private JButton btnGestionPagos;
    private JButton btnGestionHorarios;
    private JButton btnGestionReservas;
    private JButton btnGestionServicios;

    public adminBookMe () {
        btnLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Inicio de sesión");
                frame.setContentPane(new loginBookMe().loginPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(adminPanel).dispose();
            }
        });
    }
}