package FormularioHorarios;
import Administrador.Horarios_Gestion.gestionarHorarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ingresarHorario {
    public JPanel ingresarHorarioPanel;
    private JTextField textFieldIDEmpleado;
    private JButton btnAgregarHorario;
    private JButton btnVolver;
    private JTextField textFieldIdServicio;
    private JComboBox comboBoxDia;
    private JComboBox comboBoxHoraInicio;
    private JComboBox comboBoxHoraFin;
    private JLabel imgAgregar;

    public ingresarHorario() {
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

        ImageIcon img1 = new ImageIcon(getClass().getResource("/Images/mas.png"));
        Image imagen = img1.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagen);
        imgAgregar.setIcon(iconoRedimensionado);

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
                SwingUtilities.getWindowAncestor(ingresarHorarioPanel).dispose();
            }
        });
        btnAgregarHorario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {if(textFieldIdServicio.getText().isEmpty()||textFieldIDEmpleado.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Debe llenar todos los campos","Error",JOptionPane.ERROR_MESSAGE);
                    }else if(textFieldIdServicio.getText().matches("[0-9]+")){
                        JOptionPane.showMessageDialog(null, "El ID del servicio solo contiene números", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (textFieldIdServicio.getText().matches("[0-9]+")) {
                        JOptionPane.showMessageDialog(null,"El ID del empleado solo contiene números", "Error", JOptionPane.ERROR_MESSAGE);
                    } else{
                        horariosCRUD horCRUD = new horariosCRUD();
                        horCRUD.crearHorario(Integer.parseInt(textFieldIDEmpleado.getText()),
                                comboBoxDia.getActionCommand(),
                                comboBoxHoraInicio.getActionCommand(),
                                comboBoxHoraFin.getActionCommand(),
                                Integer.parseInt(textFieldIdServicio.getText()));
                        JOptionPane.showMessageDialog(null, "Horario agregado correctamente");
                        textFieldIDEmpleado.setText("");
                        textFieldIdServicio.setText("");}
                }catch (NumberFormatException ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ingrese valores numericos", "Error", JOptionPane.ERROR_MESSAGE);
                }catch (Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al agregar horario", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
