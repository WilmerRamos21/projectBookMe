package FormularioReservas;

import Reservas_Gestion.gestionReservas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class eliminarReserva {
    public JPanel eliminarReservaPanel;
    private JTextField textFieldIdReserva;
    private JButton btnEliminar;
    private JButton btnVolver;

    public eliminarReserva() {
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new gestionReservas().gestionReservasPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(800, 600));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(eliminarReservaPanel).dispose();
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Verifica si el campo de texto no está vacío
                    if (textFieldIdReserva.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Por favor ingresa el ID de la reserva a eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Obtén el ID del servicio ingresado
                    int idReserva = Integer.parseInt(textFieldIdReserva.getText().trim());

                    // Mostrar el cuadro de confirmación
                    int confirm = JOptionPane.showConfirmDialog(
                            null,
                            "¿Estás seguro de que deseas eliminar el servicio con ID: " + idReserva + "?",
                            "Confirmar eliminación",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE
                    );

                    // Si el usuario confirma, se procede a la eliminación
                    if (confirm == JOptionPane.YES_OPTION) {
                        reservasCRUD resvCRUD = new reservasCRUD();
                        boolean eliminado = resvCRUD.eliminarReserva(idReserva);
                        if (eliminado) {
                            JOptionPane.showMessageDialog(null, "Reserva eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                            // Limpia el campo de texto después de eliminar
                            textFieldIdReserva.setText("");
                        } else{
                            JOptionPane.showMessageDialog(null,"No se encontro la reserva con el ID ingresado. Por favor verifica el ID del reserva.","ERROR",JOptionPane.ERROR_MESSAGE);
                            textFieldIdReserva.setText("");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Acción cancelada.", "Información", JOptionPane.INFORMATION_MESSAGE);
                        textFieldIdReserva.setText("");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El ID de la reserva debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    textFieldIdReserva.setText("");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar eliminar la reserva.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
