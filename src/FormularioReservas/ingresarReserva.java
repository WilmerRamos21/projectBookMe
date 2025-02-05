package FormularioReservas;

import Administrador.Reservas_Gestion.gestionReservas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class ingresarReserva {
    public JPanel registrarReservaPanel;
    private JTextField textFieldIdCliente;
    private JTextField textFieldIdHorario;
    private JButton btnIngresarReserva;
    private JButton btnVolver;
    private JComboBox comboBoxObservaciones;
    private JLabel imgAgregar;

    public ingresarReserva() {
        ImageIcon img1 = new ImageIcon(getClass().getResource("/Images/mas.png"));
        Image imagen = img1.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagen);
        imgAgregar.setIcon(iconoRedimensionado);

        comboBoxObservaciones.addItem("Ninguno");
        comboBoxObservaciones.addItem("Hubo un problema");
        comboBoxObservaciones.setVisible(true);
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Panel de gestión de reservas");
                frame.setContentPane(new gestionReservas().gestionReservasPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(registrarReservaPanel).dispose();
            }
        });
        btnIngresarReserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (textFieldIdCliente.getText().isEmpty() || textFieldIdHorario.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Debe llenar todos los campos","Campos vacios",JOptionPane.INFORMATION_MESSAGE);
                    } else if (textFieldIdCliente.getText().matches("[0-9]+]")) {
                        JOptionPane.showMessageDialog(null,"El ID de cliente solo recibe valores númericos","ID incorrecto",JOptionPane.INFORMATION_MESSAGE);
                    } else if (textFieldIdHorario.getText().matches("[0-9]+")) {
                        JOptionPane.showMessageDialog(null,"El ID horario solo recibe valores númericos","ID incorrecto",JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        reservasCRUD resCRUD = new reservasCRUD();
                        resCRUD.ingresarReserva(Integer.parseInt(textFieldIdCliente.getText()), Integer.parseInt(textFieldIdHorario.getText()),
                            LocalDate.now(), comboBoxObservaciones.getActionCommand());
                        JOptionPane.showMessageDialog(null, "Reserva insertada correctamente", "Ingresar Reserva", JOptionPane.INFORMATION_MESSAGE);
                        textFieldIdCliente.setText("");
                        textFieldIdHorario.setText("");
                }
                }catch(NumberFormatException nfe){
                    nfe.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ingrese un número valido", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado. Por favor intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
