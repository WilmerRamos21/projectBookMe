package Administrador.Horarios_Gestion;
import FormularioHorarios.*;

import Administrador.adminBookMe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gestionarHorarios {
    public JPanel gestionHorariosPanel;
    private JButton btnAgregar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnMostrar;
    private JButton btnVolver;
    private JLabel imgAgregar;
    private JLabel imgEliminar;
    private JLabel imgMostrar;
    private JLabel imgActualizar;

    public gestionarHorarios() {
        ImageIcon img1 = new ImageIcon(getClass().getResource("/Images/mas.png"));
        Image imagen = img1.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagen);
        imgAgregar.setIcon(iconoRedimensionado);

        ImageIcon img2 = new ImageIcon(getClass().getResource("/Images/eliminar1.png"));
        Image imagen1 = img2.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado1 = new ImageIcon(imagen1);
        imgEliminar.setIcon(iconoRedimensionado1);

        ImageIcon img3 = new ImageIcon(getClass().getResource("/Images/actualizar1.png"));
        Image imagen2 = img3.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado2 = new ImageIcon(imagen2);
        imgActualizar.setIcon(iconoRedimensionado2);

        ImageIcon img4 = new ImageIcon(getClass().getResource("/Images/mostrarInfo.png"));
        Image imagen3 = img4.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado3 = new ImageIcon(imagen3);
        imgMostrar.setIcon(iconoRedimensionado3);





        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Panel Administrativo");
                frame.setContentPane(new adminBookMe().adminPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(gestionHorariosPanel).dispose();
            }
        });
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Agregar Horario");
                frame.setContentPane(new ingresarHorario().ingresarHorarioPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(gestionHorariosPanel).dispose();

            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Actualizar Horario");
                frame.setContentPane(new modificarHorario().modificarHorarioPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(gestionHorariosPanel).dispose();
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Eliminar Horario");
                frame.setContentPane(new eliminarHorario().eliminarHorarioPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(gestionHorariosPanel).dispose();
            }
        });
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Mostrar Horario");
                frame.setContentPane(new mostrarHorario().mostrarHorarioPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(gestionHorariosPanel).dispose();
            }
        });
    }
}
