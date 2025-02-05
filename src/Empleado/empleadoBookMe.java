package Empleado;

import Login.loginBookMe;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class empleadoBookMe {
    public JPanel empleadoPanel;
    private JButton btnLogOut;
    private JButton btnReservas;
    private JButton btnServicios;
    private JButton btnHorarios;
    private JButton btnPerfil;
    private JButton btnMostrar;
    private JButton btnModificarReservas;
    private JLabel cerrarSesion;
    private JLabel imgReservas;
    private JLabel imgServicios;
    private JLabel imgHorarios;
    private JLabel imgMostrar;
    private JLabel imgPerfil;
    private JLabel imgModificarReservas;


    public empleadoBookMe() {
        ImageIcon icono = new ImageIcon(getClass().getResource("/Images/Gestiones/cerrarSesion.png"));
        Image imagen = icono.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagen);
        cerrarSesion.setIcon(iconoRedimensionado);

        ImageIcon icono1 = new ImageIcon(getClass().getResource("/Images/Gestiones/gestionReservas.jpg"));
        Image imagen1 = icono1.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado1 = new ImageIcon(imagen1);
        imgReservas.setIcon(iconoRedimensionado1);

        ImageIcon icono2 = new ImageIcon(getClass().getResource("/Images/Gestiones/gestionServicios.jpg"));
        Image imagen2 = icono2.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado2 = new ImageIcon(imagen2);
        imgServicios.setIcon(iconoRedimensionado2);


        ImageIcon icono3 = new ImageIcon(getClass().getResource("/Images/mostrarInfo.png"));
        Image imagen3 = icono3.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado3 = new ImageIcon(imagen3);
        imgHorarios.setIcon(iconoRedimensionado3);

        ImageIcon icono4 = new ImageIcon(getClass().getResource("/Images/Usuarios/datosUsuarios.jpg"));
        Image imagen4 = icono4.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado4 = new ImageIcon(imagen4);
        imgMostrar.setIcon(iconoRedimensionado4);

        ImageIcon icono5 = new ImageIcon(getClass().getResource("/Images/modificarPerfil.png"));
        Image imagen5 = icono5.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado5 = new ImageIcon(imagen5);
        imgPerfil.setIcon(iconoRedimensionado5);

        ImageIcon icono6 = new ImageIcon(getClass().getResource("/Images/actualizar1.png"));
        Image imagen6 = icono6.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado6 = new ImageIcon(imagen6);
        imgModificarReservas.setIcon(iconoRedimensionado6);

        btnLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Inicio de sesión a BookMe");
                frame.setContentPane(new loginBookMe().loginPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(empleadoPanel).dispose();
            }
        });
        btnPerfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Perfil de modificacion del usuario");
                frame.setContentPane(new modificarEmpleado().modificarUsuarioPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(empleadoPanel).dispose();
            }
        });
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String correo = sesionCorreo.getCorreo();
                System.out.println(correo);
                JFrame frame = new JFrame("Mostrar datos generales del usuario");
                frame.setContentPane(new mostrarDatosE().datosEPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(empleadoPanel).dispose();
            }
        });
        btnHorarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Horarios");
                frame.setContentPane(new mostrarHorarioE().mostrarHorarioPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(empleadoPanel).dispose();
            }
        });
        btnServicios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Servicios");
                frame.setContentPane(new mostrarServiciosE().mostrarServicioPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(empleadoPanel).dispose();
            }
        });
        btnModificarReservas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Modificación de reservas");
                frame.setContentPane(new modificarReservaE().modificarReservaPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(empleadoPanel).dispose();
            }
        });
        btnReservas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Mostrar reservas");
                frame.setContentPane(new mostrarReservasE().mostrarReservasPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(empleadoPanel).dispose();
            }
        });
    }
}
