package FormularioHorarios;

import Horarios_Gestion.gestionarHorarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class modificarHorario {
    public JPanel modificarHorarioPanel;
    private JTextField textFieldIdHorario;
    private JTextField textFieldIdEmpleado;
    private JTextField textFieldDia;
    private JTextField textFieldHoraInicio;
    private JButton btnActualizar;
    private JButton btnVolver;
    private JTextField textFieldHoraFin;
    private JTextField textFieldEstado;
    private JTextField textFieldIdServicio;

    public modificarHorario() {
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new gestionarHorarios().gestionHorariosPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(800, 600));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(modificarHorarioPanel).dispose();
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                horariosCRUD horCRUD = new horariosCRUD();
                horCRUD.actualizarHorario(Integer.parseInt(textFieldIdEmpleado.getText()),textFieldDia.getText(),textFieldHoraInicio.getText(),textFieldHoraFin.getText(),Integer.parseInt(textFieldIdServicio.getText()),textFieldEstado.getText(),Integer.parseInt(textFieldIdHorario.getText()));
                JOptionPane.showMessageDialog(null, "Horario actualizado correctamente");
                textFieldIdHorario.setText("");
                textFieldIdEmpleado.setText("");
                textFieldDia.setText("");
                textFieldHoraInicio.setText("");
                textFieldHoraFin.setText("");
                textFieldIdServicio.setText("");
                textFieldEstado.setText("");
            }
        });
    }
}
