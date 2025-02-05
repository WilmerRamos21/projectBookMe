package FormularioPagos;

import Administrador.Pagos_Gestion.gestionPagos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class ingresarPagos {
    public JPanel ingresarPagosPanel;
    private JTextField textFieldIdCliente;
    private JTextField textFieldIdReserva;
    private JButton btnIngresarPago;
    private JButton btnVolver;
    private JComboBox comboBoxMPago;
    private JComboBox comboBoxDescription;

    public ingresarPagos() {
        comboBoxMPago.addItem("Efectivo");
        comboBoxMPago.addItem("Tarjeta");
        comboBoxMPago.setVisible(true);
        comboBoxDescription.addItem("No ninguna observacion");
        comboBoxDescription.addItem("Ha ocurrido un inconveniente");
        comboBoxDescription.setVisible(true);
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
                SwingUtilities.getWindowAncestor(ingresarPagosPanel).dispose();
            }
        });
        btnIngresarPago.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if (textFieldIdCliente.getText().isEmpty() || textFieldIdReserva.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Debe ingresar los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (textFieldIdReserva.getText().matches("[0-9]+")) {
                        JOptionPane.showMessageDialog(null, "El ID de pago solo puede contener números", "ID incorrecto", JOptionPane.INFORMATION_MESSAGE);
                    } else if (textFieldIdCliente.getText().matches("[0-9]+")) {
                        JOptionPane.showMessageDialog(null, "El ID solo puede contener números", "ID incorrecto", JOptionPane.INFORMATION_MESSAGE);
                    } else{
                        pagosCRUD payCRUD = new pagosCRUD();
                        payCRUD.ingresarPago(Integer.parseInt(textFieldIdCliente.getText()),
                                Integer.parseInt(textFieldIdReserva.getText()),
                                LocalDate.now(),
                                comboBoxMPago.getActionCommand(),
                                comboBoxDescription.getActionCommand());
                        JOptionPane.showMessageDialog(null, "Pago insertado correctamente","Ingresar Pago",JOptionPane.INFORMATION_MESSAGE);
                        textFieldIdCliente.setText("");
                        textFieldIdReserva.setText("");
                    }
                }catch (NumberFormatException e1){
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "El ID de pago no es valido", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
