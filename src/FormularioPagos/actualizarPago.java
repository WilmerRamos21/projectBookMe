package FormularioPagos;

import Pagos_Gestion.gestionPagos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class actualizarPago {
    public JPanel actualizarPagoPanel;
    private JTextField textFieldIdPago;
    private JTextField textFieldCedula;
    private JTextField textFieldIdServicio;
    private JTextField textFieldMontoPago;
    private JTextField textFieldMetodoPago;
    private JTextField textFieldEstadoPago;
    private JTextField textFieldDescripcion;
    private JButton btnActualizar;
    private JButton btnVolver;

    public actualizarPago() {
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new gestionPagos().gestionPagosPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(800, 600));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(actualizarPagoPanel).dispose();
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagosCRUD payCRUD = new pagosCRUD();
                payCRUD.actualizarPago(Integer.parseInt(textFieldCedula.getText()),Integer.parseInt(textFieldIdServicio.getText()),
                        Integer.parseInt(textFieldMontoPago.getText()), LocalDate.now(),textFieldMetodoPago.getText(),textFieldEstadoPago.getText(),textFieldDescripcion.getText(),Integer.parseInt(textFieldIdPago.getText()));
                JOptionPane.showMessageDialog(null, "Pago actualizado correctamente","Actualizar Pago",JOptionPane.INFORMATION_MESSAGE);
                textFieldIdPago.setText("");
                textFieldCedula.setText("");
                textFieldIdServicio.setText("");
                textFieldMontoPago.setText("");
                textFieldMetodoPago.setText("");
                textFieldEstadoPago.setText("");
                textFieldDescripcion.setText("");
            }
        });
    }
}
