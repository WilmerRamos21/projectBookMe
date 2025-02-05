package FormularioPagos;

import Administrador.Pagos_Gestion.gestionPagos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class actualizarPago {
    public JPanel actualizarPagoPanel;
    private JTextField textFieldIdPago;
    private JTextField textFieldId;
    private JTextField textFieldIdReserva;
    private JButton btnActualizar;
    private JButton btnVolver;
    private JComboBox comboBoxMPago;
    private JComboBox comboBoxEPago;
    private JComboBox comboBoxDescripcion;

    public actualizarPago() {

        comboBoxMPago.addItem("Efectivo");
        comboBoxMPago.addItem("Tarjeta");
        comboBoxMPago.setVisible(true);
        comboBoxEPago.addItem("Pagado");
        comboBoxEPago.addItem("Pendiente");
        comboBoxEPago.setVisible(true);
        comboBoxDescripcion.addItem("No ninguna observacion");
        comboBoxDescripcion.addItem("Ha ocurrido un inconveniente");
        comboBoxDescripcion.setVisible(true);
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
                SwingUtilities.getWindowAncestor(actualizarPagoPanel).dispose();
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (textFieldId.getText().isEmpty() || textFieldIdReserva.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Debe ingresar los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (textFieldIdReserva.getText().matches("[0-9]+")) {
                        JOptionPane.showMessageDialog(null, "El ID de pago solo puede contener números", "ID incorrecto", JOptionPane.INFORMATION_MESSAGE);
                    } else if (textFieldId.getText().matches("[0-9]+")) {
                        JOptionPane.showMessageDialog(null, "El ID solo puede contener números", "ID incorrecto", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        pagosCRUD payCRUD = new pagosCRUD();
                        payCRUD.actualizarPago(Integer.parseInt(textFieldId.getText()), Integer.parseInt(textFieldIdReserva.getText()),
                                LocalDate.now(), comboBoxMPago.getActionCommand(), comboBoxEPago.getActionCommand(), comboBoxDescripcion.getActionCommand(), Integer.parseInt(textFieldIdPago.getText()));
                        JOptionPane.showMessageDialog(null, "Pago actualizado correctamente", "Actualizar Pago", JOptionPane.INFORMATION_MESSAGE);
                        textFieldIdPago.setText("");
                        textFieldId.setText("");
                        textFieldIdReserva.setText("");
                    }
                } catch (NumberFormatException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "El ID no es valido", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
