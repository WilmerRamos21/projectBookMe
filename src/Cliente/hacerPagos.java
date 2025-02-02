package Cliente;

import FormularioPagos.pagosCRUD;
import Pagos_Gestion.gestionPagos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class hacerPagos {
    private JTextField textFieldIdCliente;
    private JTextField textFieldIdReserva;
    private JTextField textFieldMetodoPago;
    private JTextField textFieldDescripcion;
    private JButton btnPagar;
    private JButton btnVolver;
    public JPanel hacerPagoPanel;

    public hacerPagos() {
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new clienteBookMe().clientePanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(800, 600));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(hacerPagoPanel).dispose();
            }
        });
        btnPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagosCRUD payCRUD = new pagosCRUD();
                payCRUD.ingresarPago(Integer.parseInt(textFieldIdCliente.getText()),Integer.parseInt(textFieldIdReserva.getText()),
                        LocalDate.now(),textFieldMetodoPago.getText(),textFieldDescripcion.getText());
                JOptionPane.showMessageDialog(null, "Pago insertado correctamente","Ingresar Pago",JOptionPane.INFORMATION_MESSAGE);
                textFieldIdCliente.setText("");
                textFieldIdReserva.setText("");
                textFieldMetodoPago.setText("");
                textFieldDescripcion.setText("");
            }
        });
    }
}
