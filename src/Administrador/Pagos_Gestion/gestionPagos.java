package Administrador.Pagos_Gestion;


import Administrador.adminBookMe;
import FormularioPagos.actualizarPago;
import FormularioPagos.eliminarPago;
import FormularioPagos.ingresarPagos;
import FormularioPagos.mostrarDatosPago;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gestionPagos {
    public JPanel gestionPagosPanel;
    private JButton btnIngresarPagos;
    private JButton btnVerPagos;
    private JButton btnEliminarPago;
    private JButton btnActualizarPagos;
    private JButton btnVolver;
    private JLabel imgAgregar;
    private JLabel imgMostrar;
    private JLabel imgActualizar;
    private JLabel imgEliminar;

    public gestionPagos() {
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
                SwingUtilities.getWindowAncestor(gestionPagosPanel).dispose();
            }
        });
        btnIngresarPagos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Ingresar Pagos");
                frame.setContentPane(new ingresarPagos().ingresarPagosPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(gestionPagosPanel).dispose();
            }
        });
        btnEliminarPago.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Eliminar Pagos");
                frame.setContentPane(new eliminarPago().eliminarPagoPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(gestionPagosPanel).dispose();
            }
        });
        btnActualizarPagos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Actualizar Pagos");
                frame.setContentPane(new actualizarPago().actualizarPagoPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(gestionPagosPanel).dispose();
            }
        });
        btnVerPagos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Ver Pagos");
                frame.setContentPane(new mostrarDatosPago().mostrarPagosPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(gestionPagosPanel).dispose();

            }
        });
    }
}
