package Administrador;
import Login.loginBookMe;
import Administrador.Servicios_Gestion.gestionServicios;
import Administrador.Usuarios_Gestion.gestionUsuarios;
import Administrador.Reservas_Gestion.gestionReservas;
import Administrador.Horarios_Gestion.gestionarHorarios;


import Administrador.Pagos_Gestion.gestionPagos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminBookMe {
    public JPanel adminPanel;
    private JButton btnLogOut;
    private JButton btnGestionUsuarios;
    private JButton btnGestionPagos;
    private JButton btnGestionHorarios;
    private JButton btnGestionReservas;
    private JButton btnGestionServicios;
    public JLabel imagenUsuarios;
    private JLabel horariosGestion;
    private JLabel serviciosGestion;
    private JLabel pagosGestion;
    private JLabel reservasGestion;
    private JLabel cerrarSesion;

    public adminBookMe () {
        // Cargar la imagen desde el directorio de recursos
        ImageIcon icono = new ImageIcon(getClass().getResource("/Images/Usuarios/gestion_usuarios.png"));
        // Redimensionar la imagen al tamaño del JLabel
        Image imagen = icono.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagen);
        // Asignar la imagen redimensionada al JLabel
        imagenUsuarios.setIcon(iconoRedimensionado);

        ImageIcon icono1 = new ImageIcon(getClass().getResource("/Images/Gestiones/gestionHorarios.jpg"));
        Image imagen1 = icono1.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado1 = new ImageIcon(imagen1);
        horariosGestion.setIcon(iconoRedimensionado1);

        ImageIcon icono2 = new ImageIcon(getClass().getResource("/Images/Gestiones/gestionServicios.jpg"));
        Image imagen2 = icono2.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado2 = new ImageIcon(imagen2);
        serviciosGestion.setIcon(iconoRedimensionado2);

        ImageIcon icono3 = new ImageIcon(getClass().getResource("/Images/Gestiones/gestionPagos.jpg"));
        Image imagen3 = icono3.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado3 = new ImageIcon(imagen3);
        pagosGestion.setIcon(iconoRedimensionado3);

        ImageIcon icono4 = new ImageIcon(getClass().getResource("/Images/Gestiones/gestionReservas.jpg"));
        Image imagen4 = icono4.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado4 = new ImageIcon(imagen4);
        reservasGestion.setIcon(iconoRedimensionado4);

        ImageIcon icono5 = new ImageIcon(getClass().getResource("/Images/Gestiones/cerrarSesion.png"));
        Image imagen5 = icono5.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado5 = new ImageIcon(imagen5);
        cerrarSesion.setIcon(iconoRedimensionado5);

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
                SwingUtilities.getWindowAncestor(adminPanel).dispose();
            }
        });
        btnGestionUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Panel de gestión de usuarios");
                frame.setContentPane(new gestionUsuarios().gestionUsuariosPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(adminPanel).dispose();
            }
        });
        btnGestionServicios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Panel de gestión de servicios");
                frame.setContentPane(new gestionServicios().gestionServiciosPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(adminPanel).dispose();
            }
        });
        btnGestionPagos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Panel de gestión de pagos");
                frame.setContentPane(new gestionPagos().gestionPagosPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(adminPanel).dispose();
            }
        });
        btnGestionReservas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Panel de gestión de reservas");
                frame.setContentPane(new gestionReservas().gestionReservasPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(adminPanel).dispose();
            }
        });
        btnGestionHorarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Panel de gestión de horarios");
                frame.setContentPane(new gestionarHorarios().gestionHorariosPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(adminPanel).dispose();
            }
        });
    }
}
