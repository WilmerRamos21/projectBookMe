package FormularioReservas;

import Reservas_Gestion.gestionReservas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class modificarReserva {
    public JPanel modificarReservaPanel;
    private JTextField textFieldIdReserva;
    private JTextField textFieldIdCliente;
    private JTextField textFieldIdHorario;
    private JTextField textFieldEstadoReserva;
    private JTextField textFieldObservaciones;
    private JButton btnModificar;
    private JButton btnVolver;

    public modificarReserva() {
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
                SwingUtilities.getWindowAncestor(modificarReservaPanel).dispose();
            }
        });
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reservasCRUD resCRUD = new reservasCRUD();
                resCRUD.actualizarReserva(Integer.parseInt(textFieldIdCliente.getText()),Integer.parseInt(textFieldIdHorario.getText()),
                        LocalDate.now(),textFieldEstadoReserva.getText(),textFieldObservaciones.getText(),Integer.parseInt(textFieldIdReserva.getText()));
                JOptionPane.showMessageDialog(null, "Reserva modificada correctamente","Modificar Reserva",JOptionPane.INFORMATION_MESSAGE);
                textFieldIdReserva.setText("");
                textFieldIdCliente.setText("");
                textFieldIdHorario.setText("");
                textFieldEstadoReserva.setText("");
                textFieldObservaciones.setText("");
            }
        });
    }
}
