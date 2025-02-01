package FormularioReservas;

import Reservas_Gestion.gestionReservas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class ingresarReserva {
    public JPanel registrarReservaPanel;
    private JTextField textFieldIdReserva;
    private JTextField textFieldCedulaCliente;
    private JTextField textFieldIdServicio;
    private JTextField textFieldCedulaEncargado;
    private JTextField textFieldEstadoReserva;
    private JTextField textFieldPrecio;
    private JTextField textFieldDescripcion;
    private JButton btnIngresarReserva;
    private JButton btnVolver;

    public ingresarReserva() {
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
                SwingUtilities.getWindowAncestor(registrarReservaPanel).dispose();
            }
        });
        btnIngresarReserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reservasCRUD resCRUD = new reservasCRUD();
                resCRUD.ingresarReserva(Integer.parseInt(textFieldIdReserva.getText()),Integer.parseInt(textFieldCedulaCliente.getText()),Integer.parseInt(textFieldIdServicio.getText()),
                        Integer.parseInt(textFieldCedulaEncargado.getText()), LocalDate.now(),textFieldEstadoReserva.getText(),Integer.parseInt(textFieldPrecio.getText()),textFieldDescripcion.getText());
                JOptionPane.showMessageDialog(null, "Reserva insertada correctamente","Ingresar Reserva",JOptionPane.INFORMATION_MESSAGE);
                textFieldIdReserva.setText("");
                textFieldCedulaCliente.setText("");
                textFieldIdServicio.setText("");
                textFieldCedulaEncargado.setText("");
                textFieldEstadoReserva.setText("");
                textFieldPrecio.setText("");
                textFieldDescripcion.setText("");
            }
        });
    }
}
