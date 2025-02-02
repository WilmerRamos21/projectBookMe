package FormularioReservas;

import Reservas_Gestion.gestionReservas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class ingresarReserva {
    public JPanel registrarReservaPanel;
    private JTextField textFieldIdCliente;
    private JTextField textFieldIdHorario;
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
                resCRUD.ingresarReserva(Integer.parseInt(textFieldIdCliente.getText()),Integer.parseInt(textFieldIdHorario.getText()),
                        LocalDate.now(),textFieldDescripcion.getText());
                JOptionPane.showMessageDialog(null, "Reserva insertada correctamente","Ingresar Reserva",JOptionPane.INFORMATION_MESSAGE);
                textFieldIdCliente.setText("");
                textFieldIdHorario.setText("");
                textFieldDescripcion.setText("");
            }
        });
    }
}
