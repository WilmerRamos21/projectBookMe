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
    private JButton btnModificar;
    private JButton btnVolver;
    private JComboBox comboBoxEstadoReserva;
    private JComboBox comboBoxObservaciones;

    public modificarReserva() {
        comboBoxEstadoReserva.addItem("Pendiente");
        comboBoxEstadoReserva.addItem("Cancelada");
        comboBoxEstadoReserva.addItem("Completada");
        comboBoxEstadoReserva.setVisible(true);
        comboBoxObservaciones.addItem("Ninguno");
        comboBoxObservaciones.addItem("Hubo un problema");
        comboBoxObservaciones.setVisible(true);

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
                try{
                    if(textFieldIdCliente.getText().isEmpty() || textFieldIdHorario.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Debe llenar todos los campos","Campos vacios",JOptionPane.INFORMATION_MESSAGE);
                    } else if (textFieldIdCliente.getText().matches("[0-9]+]")) {
                    JOptionPane.showMessageDialog(null,"El ID de cliente solo recibe valores númericos","ID incorrecto",JOptionPane.INFORMATION_MESSAGE);
                    } else if (textFieldIdHorario.getText().matches("[0-9]+")) {
                    JOptionPane.showMessageDialog(null,"El ID horario solo recibe valores númericos","ID incorrecto",JOptionPane.INFORMATION_MESSAGE);
                    } else if (textFieldIdReserva.getText().matches("[0-9]+")) {
                        JOptionPane.showMessageDialog(null,"El ID de la reserva solo permite valores númericos","ID incorrecto",JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        reservasCRUD resCRUD = new reservasCRUD();
                        resCRUD.actualizarReserva(Integer.parseInt(textFieldIdCliente.getText()),
                                Integer.parseInt(textFieldIdHorario.getText()),
                                LocalDate.now(),
                                comboBoxEstadoReserva.getActionCommand(),
                                comboBoxObservaciones.getActionCommand(),
                                Integer.parseInt(textFieldIdReserva.getText()));
                        JOptionPane.showMessageDialog(null, "Reserva modificada correctamente", "Modificar Reserva", JOptionPane.INFORMATION_MESSAGE);
                        textFieldIdReserva.setText("");
                        textFieldIdCliente.setText("");
                        textFieldIdHorario.setText("");
                    }
                }catch(NumberFormatException ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ingrese un número valido","Error",JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "ha ocurrido un error inesperado","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
