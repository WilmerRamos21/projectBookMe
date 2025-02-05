package FormularioHorarios;

import Administrador.Horarios_Gestion.gestionarHorarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class eliminarHorario {
    public JPanel eliminarHorarioPanel;
    private JTextField textFieldIdHorario;
    private JButton btnEliminar;
    private JButton btnVolver;

    public eliminarHorario() {
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
                SwingUtilities.getWindowAncestor(eliminarHorarioPanel).dispose();
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Verifica si el campo de texto no está vacío
                    if (textFieldIdHorario.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Por favor ingresa el ID de la reserva a eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Obtén el ID del servicio ingresado
                    int idHorario = Integer.parseInt(textFieldIdHorario.getText().trim());

                    // Mostrar el cuadro de confirmación
                    int confirm = JOptionPane.showConfirmDialog(
                            null,
                            "¿Estás seguro de que deseas eliminar el horario con ID: " + idHorario + "?",
                            "Confirmar eliminación",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE
                    );

                    // Si el usuario confirma, se procede a la eliminación
                    if (confirm == JOptionPane.YES_OPTION) {
                        horariosCRUD horaCRUD = new horariosCRUD();
                        boolean eliminado = horaCRUD.eliminarHorario(idHorario);
                        if (eliminado) {
                            JOptionPane.showMessageDialog(null, "Horario eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                            // Limpia el campo de texto después de eliminar
                            textFieldIdHorario.setText("");
                        } else{
                            JOptionPane.showMessageDialog(null,"No se encontro el horario con el ID ingresado. Por favor verifica el ID del horario.","ERROR",JOptionPane.ERROR_MESSAGE);
                            textFieldIdHorario.setText("");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Acción cancelada.", "Información", JOptionPane.INFORMATION_MESSAGE);
                        textFieldIdHorario.setText("");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El ID del horario debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    textFieldIdHorario.setText("");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar eliminar el horario.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
