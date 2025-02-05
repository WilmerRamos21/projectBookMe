package Administrador.Reservas_Gestion;

import Administrador.adminBookMe;
import FormularioReservas.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gestionReservas {
    public JPanel gestionReservasPanel;
    private JButton btnRegistrarReserva;
    private JButton btnMostrarReservas;
    private JButton btnEliminarReserva;
    private JButton btnActualizarReserva;
    private JButton volverAlMenúPrincipalButton;
    private JLabel imgAgregar;
    private JLabel imgMostrar;
    private JLabel imgActualizar;
    private JLabel imgEliminar;

    public gestionReservas() {
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

        volverAlMenúPrincipalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Panel Administrativo");
                frame.setContentPane(new adminBookMe().adminPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(gestionReservasPanel).dispose();
            }
        });
        btnRegistrarReserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Registrar Reserva");
                frame.setContentPane(new ingresarReserva().registrarReservaPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(gestionReservasPanel).dispose();
            }
        });
        btnEliminarReserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Eliminar Reserva");
                frame.setContentPane(new eliminarReserva().eliminarReservaPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(gestionReservasPanel).dispose();
            }
        });
        btnActualizarReserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Actualizar Reserva");
                frame.setContentPane(new modificarReserva().modificarReservaPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(gestionReservasPanel).dispose();
            }
        });
        btnMostrarReservas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Mostrar Reservas");
                frame.setContentPane(new mostrarReservas().mostrarReservasPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(gestionReservasPanel).dispose();
            }
        });
    }
}
