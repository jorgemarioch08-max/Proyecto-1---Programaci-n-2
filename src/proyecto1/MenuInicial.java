package proyecto1;

import javax.swing.*;
import java.awt.*;

public class MenuInicial extends JFrame  {

    //Admin
    PlayerManager admin;

    //GUI
    JLabel titulo1 = new JLabel("Marvel Heroes: Stratego");
    JLabel titulo2 = new JLabel("Para poder jugar necesitas crear una cuenta o iniciar sesión.");

    JPanel hbox = new JPanel();
    JPanel vbox = new JPanel();

    JButton login = new JButton("Iniciar Sesión");
    JButton crearAcc = new JButton("Crear Cuenta");

    public MenuInicial(PlayerManager admin) {
        setTitle("Ingresar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,500);
        setResizable(false);
        setLayout(new BorderLayout(10, 10));

        titulo1.setFont(new Font("Arial", Font.BOLD, 36));
        titulo1.setForeground(Color.white);
        titulo2.setFont(new Font("Arial", Font.PLAIN, 18));
        titulo2.setForeground(Color.white);

        login.setFont(new Font("Arial", Font.PLAIN, 20));
        login.setBackground(Color.decode("#cfe2f3"));
        login.setPreferredSize(new Dimension(200,50));
        login.setMaximumSize(new Dimension(200,50));

        crearAcc.setFont(new Font("Arial", Font.PLAIN, 20));
        crearAcc.setBackground(Color.decode("#cfe2f3"));
        crearAcc.setPreferredSize(new Dimension(200,50));
        crearAcc.setMaximumSize(new Dimension(200,50));

        hbox.setLayout(new BoxLayout(hbox,BoxLayout.X_AXIS));
        hbox.setPreferredSize(new Dimension(500,75));
        hbox.setMaximumSize(new Dimension(500,75));
        hbox.setBackground(Color.decode("#333333"));

        hbox.add(Box.createHorizontalGlue());

        hbox.add(login);
        hbox.add(Box.createHorizontalStrut(10));
        hbox.add(crearAcc);

        hbox.add(Box.createHorizontalGlue());

        vbox.setLayout(new BoxLayout(vbox,BoxLayout.Y_AXIS));
        vbox.setBackground(Color.decode("#333333"));

        vbox.add(Box.createVerticalGlue());

        vbox.add(titulo1);
        titulo1.setAlignmentX(Component.CENTER_ALIGNMENT);
        vbox.add(Box.createVerticalStrut(40));
        vbox.add(titulo2);
        titulo2.setAlignmentX(Component.CENTER_ALIGNMENT);
        vbox.add(Box.createVerticalStrut(25));
        vbox.add(hbox);
        hbox.setAlignmentX(Component.CENTER_ALIGNMENT);

        vbox.add(Box.createVerticalGlue());

        add(vbox,BorderLayout.CENTER);

        setLocationRelativeTo(null);

        crearAcc.addActionListener(e -> {
           CrearCuenta windowC = new CrearCuenta(admin);
           windowC.setVisible(true);
        });

        login.addActionListener(e -> {
           LogIn windowL = new LogIn(admin, this);
           windowL.setVisible(true);
        });
    }



}
