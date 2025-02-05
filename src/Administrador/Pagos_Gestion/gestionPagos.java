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

    public gestionPagos() {
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
