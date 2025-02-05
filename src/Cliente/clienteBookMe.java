package Cliente;

import Login.loginBookMe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class clienteBookMe {
    public JPanel clientePanel;
    private JButton btnLogOut;
    private JButton btnActualizar;
    private JButton btnMostrarDatos;
    private JButton btnServicios;
    private JButton btnHacerReserva;
    private JButton btnVerHorarios;
    private JButton btnVerMisReservas;
    private JButton btnPagar;
    private JButton btnVerMisPagos;
    private JLabel cerrarSesion;
    private JLabel imgHistorialPagos;
    private JLabel imgHacerPagos;
    private JLabel imgReservas;
    private JLabel imgHorario;
    private JLabel imgVerReservas;
    private JLabel imgModificarPerfil;
    private JLabel imgMostrarDatos;
    private JLabel imgServicios;

    public clienteBookMe() {
        ImageIcon icono = new ImageIcon(getClass().getResource("/Images/hacerPagos.png"));
        Image imagen = icono.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagen);
        imgHacerPagos.setIcon(iconoRedimensionado);

        ImageIcon icono2 = new ImageIcon(getClass().getResource("/Images/historialPagos.png"));
        Image imagen2 = icono2.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado2 = new ImageIcon(imagen2);
        imgHistorialPagos.setIcon(iconoRedimensionado2);

        ImageIcon icono3 = new ImageIcon(getClass().getResource("/Images/Gestiones/gestionHorarios.jpg"));
        Image imagen3 = icono3.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado3 = new ImageIcon(imagen3);
        imgHorario.setIcon(iconoRedimensionado3);

        ImageIcon icono4 = new ImageIcon(getClass().getResource("/Images/Gestiones/gestionReservas.jpg"));
        Image imagen4 = icono4.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado4 = new ImageIcon(imagen4);
        imgReservas.setIcon(iconoRedimensionado4);

        ImageIcon icono5 = new ImageIcon(getClass().getResource("/Images/mostrarInfo.png"));
        Image imagen5 = icono5.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado5 = new ImageIcon(imagen5);
        imgVerReservas.setIcon(iconoRedimensionado5);

        ImageIcon icono6 = new ImageIcon(getClass().getResource("/Images/modificarPerfil.png"));
        Image imagen6 = icono6.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado6 = new ImageIcon(imagen6);
        imgModificarPerfil.setIcon(iconoRedimensionado6);

        ImageIcon icono7 = new ImageIcon(getClass().getResource("/Images/Usuarios/nuevoUsuario.jpg"));
        Image imagen7 = icono7.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado7 = new ImageIcon(imagen7);
        imgMostrarDatos.setIcon(iconoRedimensionado7);

        ImageIcon icono8 = new ImageIcon(getClass().getResource("/Images/Gestiones/gestionServicios.jpg"));
        Image imagen8 = icono8.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado8 = new ImageIcon(imagen8);
        imgServicios.setIcon(iconoRedimensionado8);

        ImageIcon icono9 = new ImageIcon(getClass().getResource("/Images/Gestiones/cerrarSesion.png"));
        Image imagen9 = icono9.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado9 = new ImageIcon(imagen9);
        cerrarSesion.setIcon(iconoRedimensionado9);

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
                SwingUtilities.getWindowAncestor(clientePanel).dispose();
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Actualizar informacion del usuario");
                frame.setContentPane(new modificarCliente().modificarUsuarioPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(clientePanel).dispose();
            }
        });
        btnMostrarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Mostrar datos del usuario");
                frame.setContentPane(new mostrarDatosC().mostrarDatosC);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(clientePanel).dispose();
            }
        });
        btnServicios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Servicios disponibles");
                frame.setContentPane(new mostrarServiciosC().mostrarServiciosPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(clientePanel).dispose();
            }
        });
        btnHacerReserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame("Hacer reservas");
            frame.setContentPane(new hacerReserva().hacerReservaPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setPreferredSize(new Dimension(1020, 640));
            frame.pack();
            frame.setVisible(true);
            SwingUtilities.getWindowAncestor(clientePanel).dispose();
            }
        });
        btnVerHorarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Horarios disponibles");
                frame.setContentPane(new mostrarHorarioC().mostrarHorarioPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(clientePanel).dispose();
            }
        });
        btnVerMisReservas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Mostrar reservas del usuario");
                frame.setContentPane(new verMisReservas().misReservasPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(clientePanel).dispose();
            }
        });
        btnPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Pagar reservas del usuario");
                frame.setContentPane(new hacerPagos().hacerPagoPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(clientePanel).dispose();
            }
        });
        btnVerMisPagos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Historial de pagos del usuario");
                frame.setContentPane(new verMisPagos().verMisPagosPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setPreferredSize(new Dimension(1020, 640));
                frame.pack();
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(clientePanel).dispose();
            }
        });
    }
}
