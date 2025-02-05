package Administrador.Usuarios_Gestion;
import FormularioUsuarios.*;

import Administrador.adminBookMe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gestionUsuarios {
    public JPanel gestionUsuariosPanel;
    private JButton btnLeer;
    private JButton btnEliminar;
    private JButton btnRegistrar;
    private JButton btnActualizar;
    private JButton btnVolver;
    private JLabel imgMostrar;
    private JLabel imgModificar;
    private JLabel imgEliminar;
    private JLabel imgNuevoUsuario;

    public gestionUsuarios() {
        //Imagenes para cada apartado del panel
        ImageIcon icono = new ImageIcon(getClass().getResource("/Images/Usuarios/datosUsuarios.jpg"));
        Image imagen = icono.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagen);
        imgMostrar.setIcon(iconoRedimensionado);

        ImageIcon icono1 = new ImageIcon(getClass().getResource("/Images/Usuarios/modificacionUsuarios.jpg"));
        Image imagen1 = icono1.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado1 = new ImageIcon(imagen1);
        imgModificar.setIcon(iconoRedimensionado1);

        ImageIcon icono2 = new ImageIcon(getClass().getResource("/Images/Usuarios/eliminarUsuarios.png"));
        Image imagen2 = icono2.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado2 = new ImageIcon(imagen2);
        imgEliminar.setIcon(iconoRedimensionado2);

        ImageIcon icono3 = new ImageIcon(getClass().getResource("/Images/Usuarios/nuevoUsuario.jpg"));
        Image imagen3 = icono3.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado3 = new ImageIcon(imagen3);
        imgNuevoUsuario.setIcon(iconoRedimensionado3);



        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Registrar Usuario");
                frame.setContentPane(new subRegister().subRegisterPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(gestionUsuariosPanel).dispose();
            }
        });
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
                SwingUtilities.getWindowAncestor(gestionUsuariosPanel).dispose();
            }
        });
        btnLeer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Mostrar datos de los usuarios");
                frame.setContentPane(new subLeer().leerPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(gestionUsuariosPanel).dispose();
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Actualizar Usuario");
                frame.setContentPane(new subActualizacion().actualizarPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(gestionUsuariosPanel).dispose();
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Eliminar Usuario");
                frame.setContentPane(new subEliminacion().eliminacionPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(gestionUsuariosPanel).dispose();
            }
        });
    }
}
