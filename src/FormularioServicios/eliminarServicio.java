package FormularioServicios;

import Administrador.Servicios_Gestion.gestionServicios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class eliminarServicio {
    private JTextField textFieldIdServicio;
    private JButton btnEliminar;
    private JButton btnVolver;
    public JPanel eliminarServicioPanel;
    private JLabel imgEliminar;

    public eliminarServicio() {
        ImageIcon img2 = new ImageIcon(getClass().getResource("/Images/eliminar1.png"));
        Image imagen1 = img2.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado1 = new ImageIcon(imagen1);
        imgEliminar.setIcon(iconoRedimensionado1);

        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Panel de gestión de servicios");
                frame.setContentPane(new gestionServicios().gestionServiciosPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(eliminarServicioPanel).dispose();

            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Verifica si el campo de texto no está vacío
                    if (textFieldIdServicio.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Por favor ingresa el ID del servicio a eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Obtén el ID del servicio ingresado
                    int idServicio = Integer.parseInt(textFieldIdServicio.getText().trim());

                    // Mostrar el cuadro de confirmación
                    int confirm = JOptionPane.showConfirmDialog(
                            null,
                            "¿Estás seguro de que deseas eliminar el servicio con ID: " + idServicio + "?",
                            "Confirmar eliminación",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE
                    );

                    // Si el usuario confirma, se procede a la eliminación
                    if (confirm == JOptionPane.YES_OPTION) {
                        serviciosCRUD servicios = new serviciosCRUD();
                        boolean eliminado = servicios.eliminarServicio(idServicio);
                        if (eliminado) {
                            JOptionPane.showMessageDialog(null, "Servicio eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                            // Limpia el campo de texto después de eliminar
                            textFieldIdServicio.setText("");
                        } else{
                            JOptionPane.showMessageDialog(null,"No se encontro el servicio con el ID ingresado. Por favor verifica el ID del servicio.","ERROR",JOptionPane.ERROR_MESSAGE);
                            textFieldIdServicio.setText("");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Acción cancelada.", "Información", JOptionPane.INFORMATION_MESSAGE);
                        textFieldIdServicio.setText("");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El ID del servicio debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    textFieldIdServicio.setText("");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar eliminar el servicio.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        });
    }
}
