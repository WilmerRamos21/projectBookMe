package FormularioHorarios;

import Administrador.Horarios_Gestion.gestionarHorarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class modificarHorario {
    public JPanel modificarHorarioPanel;
    private JTextField textFieldIdHorario;
    private JTextField textFieldIdEmpleado;
    private JButton btnActualizar;
    private JButton btnVolver;
    private JTextField textFieldIdServicio;
    private JComboBox comboBoxDia;
    private JComboBox comboBoxHoraInicio;
    private JComboBox comboBoxHoraFin;
    private JComboBox comboBoxEstado;

    public modificarHorario() {
        comboBoxDia.addItem("Lunes");
        comboBoxDia.addItem("Martes");
        comboBoxDia.addItem("Miércoles");
        comboBoxDia.addItem("Jueves");
        comboBoxDia.addItem("Viernes");
        comboBoxDia.addItem("Sábado");
        comboBoxDia.addItem("Domingo");
        comboBoxDia.setVisible(true);
        comboBoxHoraInicio.addItem("8:00");
        comboBoxHoraInicio.addItem("9:00");
        comboBoxHoraInicio.addItem("10:00");
        comboBoxHoraInicio.addItem("11:00");
        comboBoxHoraInicio.addItem("13:00");
        comboBoxHoraInicio.addItem("14:00");
        comboBoxHoraInicio.addItem("15:00");
        comboBoxHoraInicio.addItem("16:00");
        comboBoxHoraInicio.addItem("17:00");
        comboBoxHoraInicio.addItem("18:00");
        comboBoxHoraInicio.setVisible(true);
        comboBoxHoraFin.addItem("9:00");
        comboBoxHoraFin.addItem("10:00");
        comboBoxHoraFin.addItem("11:00");
        comboBoxHoraFin.addItem("12:00");
        comboBoxHoraFin.addItem("14:00");
        comboBoxHoraFin.addItem("15:00");
        comboBoxHoraFin.addItem("16:00");
        comboBoxHoraFin.addItem("17:00");
        comboBoxHoraFin.addItem("18:00");
        comboBoxHoraFin.addItem("19:00");
        comboBoxHoraFin.setVisible(true);
        comboBoxEstado.addItem("activo");
        comboBoxEstado.addItem("inactivo");
        comboBoxEstado.setVisible(true);

        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Panel de gestión de horarios");
                frame.setContentPane(new gestionarHorarios().gestionHorariosPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(modificarHorarioPanel).dispose();
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(textFieldIdServicio.getText().matches("[0-9]+")){
                        JOptionPane.showMessageDialog(null, "El ID del servicio solo contiene números", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (textFieldIdServicio.getText().matches("[0-9]+")) {
                        JOptionPane.showMessageDialog(null,"El ID del empleado solo contiene números", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        horariosCRUD horCRUD = new horariosCRUD();
                        horCRUD.actualizarHorario(Integer.parseInt(textFieldIdEmpleado.getText()),
                                comboBoxDia.getActionCommand(),
                                comboBoxHoraInicio.getActionCommand(),
                                comboBoxHoraFin.getActionCommand(),
                                Integer.parseInt(textFieldIdServicio.getText()),
                                comboBoxEstado.getActionCommand(),
                                Integer.parseInt(textFieldIdHorario.getText()));
                        JOptionPane.showMessageDialog(null, "Horario actualizado correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        textFieldIdHorario.setText("");
                        textFieldIdEmpleado.setText("");
                        textFieldIdServicio.setText("");
                    }
                } catch(NumberFormatException ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, ex.getMessage(),"Error númerico",JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
