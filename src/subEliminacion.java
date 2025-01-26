import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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
                try{
                    if (textFieldCedula.getText().isEmpty()) {
                        JOptionPane.showConfirmDialog(null,"Por favor ingrese la cedula del usuario.");
                        return;
                    }
                    int cedula = Integer.parseInt(textFieldCedula.getText());
                    int confirm = JOptionPane.showConfirmDialog(
                            null,
                            "Estas seguro de eliminar el usuario "+cedula+"?",
                            "Confirmar eliminación",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE);
                    if (confirm == JOptionPane.YES_OPTION) {
                        usuariosCRUD usuarios = new usuariosCRUD();
                        boolean eliminado = usuarios.eliminarUsuario(cedula);
                        if (eliminado) {
                            JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente","Exito",JOptionPane.INFORMATION_MESSAGE);
                            textFieldCedula.setText("");
                        }else{
                            JOptionPane.showMessageDialog(null, "Usuario no encontrado","Error",JOptionPane.ERROR_MESSAGE);
                            textFieldCedula.setText("");
                        }
                    } else{
                        JOptionPane.showMessageDialog(null, "Acción cancelada.", "Información", JOptionPane.INFORMATION_MESSAGE);
                        textFieldCedula.setText("");
                    }
                }catch (NumberFormatException e0){
                    JOptionPane.showMessageDialog(null, "La cedula debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    textFieldCedula.setText("");
                }catch (Exception e1){
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar eliminar el servicio.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
