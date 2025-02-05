package Empleado;

import FormularioReservas.reservasCRUD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class modificarReservaE {
    public JPanel modificarReservaPanel;
    private JTextField textFieldIdReserva;
    private JTextField textFieldIdHorario;
    private JButton btnVolver;
    private JButton btnModificar;
    private JTextField textFieldIdCliente;
    private JComboBox comboBoxEstadoReserva;
    private JComboBox comboBoxObservaciones;
    private JLabel imgModificarReservas;

    public modificarReservaE() {

        ImageIcon icono6 = new ImageIcon(getClass().getResource("/Images/actualizar1.png"));
        Image imagen6 = icono6.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado6 = new ImageIcon(imagen6);
        imgModificarReservas.setIcon(iconoRedimensionado6);

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
                JFrame frame = new JFrame("Panel de gestión del empleado");
                frame.setContentPane(new empleadoBookMe().empleadoPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(modificarReservaPanel).dispose();
            }
        });
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(textFieldIdReserva.getText().isEmpty() || textFieldIdCliente.getText().isEmpty() || textFieldIdHorario.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Debe llenar los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (textFieldIdHorario.getText().matches("[0-9]+]")) {
                        JOptionPane.showMessageDialog(null, "El ID del horario debe ser numerico", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (textFieldIdReserva.getText().matches("[0-9]+")) {
                        JOptionPane.showMessageDialog(null, "El ID de la reserva debe ser numerico", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (textFieldIdCliente.getText().matches("[0-9]+")) {
                        JOptionPane.showMessageDialog(null, "El ID del cliente debe ser numerico", "Error", JOptionPane.ERROR_MESSAGE);
                    } else{
                        reservasCRUD resCRUD = new reservasCRUD();
                        resCRUD.actualizarReserva( Integer.parseInt(textFieldIdCliente.getText()),
                                Integer.parseInt(textFieldIdHorario.getText()),
                                LocalDate.now(),
                                comboBoxEstadoReserva.getActionCommand(),
                                comboBoxObservaciones.getActionCommand(),
                                Integer.parseInt(textFieldIdReserva.getText()));
                        JOptionPane.showMessageDialog(null, "Reserva modificada correctamente","Modificar Reserva",JOptionPane.INFORMATION_MESSAGE);
                        textFieldIdCliente.setText("");
                        textFieldIdReserva.setText("");
                        textFieldIdHorario.setText("");
                    }
                } catch(NumberFormatException ex){
                    ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Ingrese un número valido","Error",JOptionPane.ERROR_MESSAGE);
                } catch(Exception e0) {
                    e0.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un errror inesperado","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
