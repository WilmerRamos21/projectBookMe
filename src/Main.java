import javax.swing.*;
import java.awt.*;

import Register.registerBookMe;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Registro de usuario a BookMe");
        frame.setContentPane(new registerBookMe().registerPanel);
        frame.setSize(800, 600);
        frame.setPreferredSize(new Dimension(1020, 640));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}