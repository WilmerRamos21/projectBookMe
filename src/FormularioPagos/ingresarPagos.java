package FormularioPagos;

import Pagos_Gestion.gestionPagos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class ingresarPagos {
    public JPanel ingresarPagosPanel;
    private JTextField textFieldIdPago;
    private JTextField textFieldCedulaCliente;
    private JTextField textFieldIdServicio;
    private JTextField textFieldMontoPago;
    private JTextField textFieldMetodoPago;
    private JTextField textFieldEstadoPago;
    private JTextField textFieldDescripcion;
    private JButton btnIngresarPago;
    private JButton btnVolver;

    public ingresarPagos() {
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
                SwingUtilities.getWindowAncestor(ingresarPagosPanel).dispose();
            }
        });
        btnIngresarPago.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagosCRUD payCRUD = new pagosCRUD();
                payCRUD.ingresarPago(Integer.parseInt(textFieldIdPago.getText()),Integer.parseInt(textFieldCedulaCliente.getText()),Integer.parseInt(textFieldIdServicio.getText()),
                        Integer.parseInt(textFieldMontoPago.getText()), LocalDate.now(),textFieldMetodoPago.getText(),textFieldEstadoPago.getText(),textFieldDescripcion.getText());
                JOptionPane.showMessageDialog(null, "Pago insertado correctamente","Ingresar Pago",JOptionPane.INFORMATION_MESSAGE);
                textFieldIdPago.setText("");
                textFieldCedulaCliente.setText("");
                textFieldIdServicio.setText("");
                textFieldMontoPago.setText("");
                textFieldMetodoPago.setText("");
                textFieldEstadoPago.setText("");
                textFieldDescripcion.setText("");
            }
        });
    }
}
