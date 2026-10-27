package proyecto1;

import javax.swing.*;
import java.awt.*;

public class MainMenu {

    JFrame menu = new JFrame("Menu Principal");

    JLabel menuTitulo1 = new JLabel("Marvel Heroes: Stratego");

    JPanel menuPanel1 = new JPanel();

    JButton partidaNueva = new JButton("Nueva partida");
    JButton perfil  = new JButton("Mi perfil");
    JButton universo = new JButton("Universo Marvel");
    JButton cerrarSesion = new JButton("Cerrar Sesion");
    JButton exit = new JButton("Salir");

    public MainMenu() {
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setSize(1600,900);
        menu.setResizable(false);
        menu.setLayout(new BorderLayout(10, 10));

        menuTitulo1.setFont(new Font("Arial", Font.BOLD, 36));

        partidaNueva.setFont(new Font("Arial", Font.PLAIN, 20));
        partidaNueva.setBackground(Color.decode("#cfe2f3"));
        partidaNueva.setMaximumSize(new Dimension(200,50));

        perfil.setFont(new Font("Arial", Font.PLAIN, 20));
        perfil.setBackground(Color.decode("#cfe2f3"));
        perfil.setMaximumSize(new Dimension(200, 50));

        universo.setFont(new Font("Arial", Font.PLAIN, 20));
        universo.setBackground(Color.decode("#cfe2f3"));
        universo.setMaximumSize(new Dimension(200, 50));

        cerrarSesion.setFont(new Font("Arial", Font.PLAIN, 20));
        cerrarSesion.setBackground(Color.decode("#cfe2f3"));
        cerrarSesion.setMaximumSize(new Dimension(200, 50));

        exit.setFont(new Font("Arial", Font.PLAIN, 20));
        exit.setBackground(Color.decode("#cfe2f3"));
        exit.setMaximumSize(new Dimension(200, 50));

        menuPanel1.setBackground(Color.decode("#eeeeee"));

        menuTitulo1.setAlignmentX(Component.CENTER_ALIGNMENT);
        partidaNueva.setAlignmentX(Component.CENTER_ALIGNMENT);
        perfil.setAlignmentX(Component.CENTER_ALIGNMENT);
        universo.setAlignmentX(Component.CENTER_ALIGNMENT);
        cerrarSesion.setAlignmentX(Component.CENTER_ALIGNMENT);
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);

        menuPanel1.add(Box.createVerticalGlue());

        menuPanel1.setLayout(new BoxLayout(menuPanel1,BoxLayout.Y_AXIS));
        menuPanel1.add(menuTitulo1);
        menuPanel1.add(Box.createVerticalStrut(50));
        menuPanel1.add(partidaNueva);
        menuPanel1.add(Box.createVerticalStrut(5));
        menuPanel1.add(perfil);
        menuPanel1.add(Box.createVerticalStrut(5));
        menuPanel1.add(universo);
        menuPanel1.add(Box.createVerticalStrut(5));
        menuPanel1.add(cerrarSesion);
        menuPanel1.add(Box.createVerticalStrut(5));
        menuPanel1.add(exit);

        menuPanel1.add(Box.createVerticalGlue());

        menu.add(menuPanel1,BorderLayout.CENTER);
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);

        exit.addActionListener(e ->{
            System.exit(0);
        });

    }



}
