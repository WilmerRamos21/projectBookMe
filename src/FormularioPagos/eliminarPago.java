package FormularioPagos;


import Administrador.Pagos_Gestion.gestionPagos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class eliminarPago {
    public JPanel eliminarPagoPanel;
    private JTextField textFieldIdPago;
    private JButton btnEliminar;
    private JButton btnVolver;

    public eliminarPago() {
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Panel de gestión de pagos");
                frame.setContentPane(new gestionPagos().gestionPagosPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(eliminarPagoPanel).dispose();
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Verifica si el campo de texto no está vacío
                    if (textFieldIdPago.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Por favor ingresa el ID del servicio a eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    // Obtén el ID del servicio ingresado
                    int idPago = Integer.parseInt(textFieldIdPago.getText().trim());

                    // Mostrar el cuadro de confirmación
                    int confirm = JOptionPane.showConfirmDialog(
                            null,
                            "¿Estás seguro de que deseas eliminar el pago con ID: " + idPago + "?",
                            "Confirmar eliminación",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE
                    );
                    // Si el usuario confirma, se procede a la eliminación
                    if (confirm == JOptionPane.YES_OPTION) {
                        pagosCRUD pay = new pagosCRUD();
                        boolean eliminado = pay.eliminarPago(idPago);
                        if (eliminado) {
                            JOptionPane.showMessageDialog(null, "Pago eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                            // Limpia el campo de texto después de eliminar
                            textFieldIdPago.setText("");
                        } else{
                            JOptionPane.showMessageDialog(null,"No se encontro el pago con el ID ingresado. Por favor verifica el ID del pago.","ERROR",JOptionPane.ERROR_MESSAGE);
                            textFieldIdPago.setText("");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Acción cancelada.", "Información", JOptionPane.INFORMATION_MESSAGE);
                        textFieldIdPago.setText("");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El ID del pago debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    textFieldIdPago.setText("");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar eliminar el pago.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
