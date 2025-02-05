package Cliente;


import FormularioHorarios.horariosCRUD;
import FormularioReservas.reservasCRUD;
import Empleado.sesionCorreo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class hacerReserva {
    public JPanel hacerReservaPanel;
    private JTextField textFieldIdCliente;
    private JTextField textFieldIdHorario;
    private JTextField textFieldObservaciones;
    private JButton btnReservar;
    private JButton btnVolver;


    public hacerReserva() {
        btnReservar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reservasCRUD resCRUD = new reservasCRUD();
                int idClienteSesion = sesionCorreo.getID();
                int idClienteIngresado = Integer.parseInt(textFieldIdCliente.getText());
                int idHorario = Integer.parseInt(textFieldIdHorario.getText());
                LocalDate fecha = LocalDate.now();
                String observaciones = textFieldObservaciones.getText();
                try{
                    horariosCRUD hCRUD = new horariosCRUD();
                    if (!hCRUD.existeHorario(idHorario)){
                        JOptionPane.showMessageDialog(null,"El ID de ese horario no existe.","Error",JOptionPane.ERROR_MESSAGE);
                        return;
                    } else if(idClienteIngresado != idClienteSesion){
                        JOptionPane.showMessageDialog(null, "No puede realizar la reserva con el ID de otro usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    if (resCRUD.ingresarReserva(idClienteIngresado,idHorario,fecha,observaciones)){
                        JOptionPane.showMessageDialog(null, "Reserva insertada correctamente.","Hacer Reserva",JOptionPane.INFORMATION_MESSAGE);
                        textFieldIdCliente.setText("");
                        textFieldIdHorario.setText("");
                        textFieldObservaciones.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo realizar la reserva.","Error",JOptionPane.ERROR_MESSAGE);
                    }
                }catch (NumberFormatException e1){
                    JOptionPane.showMessageDialog(null, "Por favor ingresa valores númericos válidos.","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
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
                SwingUtilities.getWindowAncestor(hacerReservaPanel).dispose();
            }
        });
    }
}
