package Cliente;

import Empleado.sesionCorreo;
import FormularioPagos.pagosCRUD;
import generarPDF.hacerPDF;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class hacerPagos {
    private JTextField textFieldIdCliente;
    private JTextField textFieldIdReserva;
    private JButton btnPagar;
    private JButton btnVolver;
    public JPanel hacerPagoPanel;
    private JComboBox comboBoxMPago;
    private JComboBox comboBoxDescripcion;
    private JLabel imgHacerPago;

    public hacerPagos() {
        ImageIcon icono = new ImageIcon(getClass().getResource("/Images/hacerPagos.png"));
        Image imagen = icono.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagen);
        imgHacerPago.setIcon(iconoRedimensionado);


        comboBoxMPago.addItem("Efectivo");
        comboBoxMPago.addItem("Tarjeta");
        comboBoxMPago.setVisible(true);
        comboBoxDescripcion.addItem("Ninguna");
        comboBoxDescripcion.addItem("Ha ocurrido un inconveniente");
        comboBoxDescripcion.setVisible(true);
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Panel del Cliente");
                frame.setContentPane(new clienteBookMe().clientePanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(hacerPagoPanel).dispose();
            }
        });
        btnPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try { if(textFieldIdCliente.getText().isEmpty() || textFieldIdReserva.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Debe llenar los campos","Error",JOptionPane.ERROR_MESSAGE);
                    } else if (textFieldIdCliente.getText().matches("[0-9]+]")) {
                    JOptionPane.showMessageDialog(null,"El ID del cliente solo contiene valores númericos","Error",JOptionPane.ERROR_MESSAGE);
                    } else if (textFieldIdReserva.getText().matches("[0-9]+]")) {
                    JOptionPane.showMessageDialog(null,"El ID de la reserva solo contiene valores numeros","Error",JOptionPane.ERROR_MESSAGE);
                    } else{

                        int idRserva = Integer.parseInt(textFieldIdReserva.getText());

                        pagosCRUD payCRUD = new pagosCRUD();
                        payCRUD.ingresarPago(Integer.parseInt(textFieldIdCliente.getText()),
                                Integer.parseInt(textFieldIdReserva.getText()),
                                LocalDate.now(),
                                comboBoxMPago.getSelectedItem().toString(),
                                comboBoxDescripcion.getSelectedItem().toString());
                        JOptionPane.showMessageDialog(null, "Pago insertado correctamente", "Ingresar Pago", JOptionPane.INFORMATION_MESSAGE);
                        textFieldIdCliente.setText("");
                        textFieldIdReserva.setText("");

                        hacerPDF hacerPDF1 = new hacerPDF();
                        hacerPDF1.hacerFacturaPDF(idRserva);
                    }
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Ingrese un numero valido", "Error", JOptionPane.ERROR_MESSAGE);
                } catch(Exception e0){
                e0.printStackTrace();
                JOptionPane.showMessageDialog(null, "Ingrese un numero valido", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
