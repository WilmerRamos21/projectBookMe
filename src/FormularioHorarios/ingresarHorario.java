package FormularioHorarios;

import Horarios_Gestion.gestionarHorarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ingresarHorario {
    public JPanel ingresarHorarioPanel;
    private JTextField textFieldIDEmpleado;
    private JTextField textFieldDia;
    private JTextField textFieldHoraInicio;
    private JTextField textFieldHoraFin;
    private JButton btnAgregarHorario;
    private JButton btnVolver;
    private JTextField textFieldIdServicio;

    public ingresarHorario() {
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
                SwingUtilities.getWindowAncestor(ingresarHorarioPanel).dispose();
            }
        });
        btnAgregarHorario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                horariosCRUD horCRUD = new horariosCRUD();
                horCRUD.crearHorario(Integer.parseInt(textFieldIDEmpleado.getText()),textFieldDia.getText(),textFieldHoraInicio.getText(),textFieldHoraFin.getText(),Integer.parseInt(textFieldIdServicio.getText()));
                JOptionPane.showMessageDialog(null, "Horario agregado correctamente");
                textFieldIDEmpleado.setText("");
                textFieldDia.setText("");
                textFieldHoraInicio.setText("");
                textFieldHoraFin.setText("");
                textFieldIdServicio.setText("");
            }
        });
    }
}
