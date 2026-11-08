package proyecto1;

import javax.swing.*;
import java.awt.*;
import Exceptions.*;

public class MainMenu extends JFrame {

    //GUI
    JLabel menuTitulo1 = new JLabel("Marvel Heroes: Stratego");

    JPanel menuPanel1 = new JPanel();

    JButton partidaNueva = new JButton("Nueva partida");
    JButton perfil  = new JButton("Mi perfil");
    JButton universo = new JButton("Universo Marvel");
    JButton exit = new JButton("Salir");

    //JDialog que muestra el perfil
    private MiPerfil verPerfil;

    //Admin
    public PlayerManager admin;

    public MainMenu(PlayerManager admin) {
        this.admin = admin;
        verPerfil = new MiPerfil(admin, this);

        //GUI
        setTitle("Marvel Heroes: Stratego");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1600,900);
        setResizable(false);
        setLayout(new BorderLayout(10, 10));

        menuTitulo1.setFont(new Font("Arial", Font.BOLD, 36));
        menuTitulo1.setForeground(Color.white);

        partidaNueva.setFont(new Font("Arial", Font.PLAIN, 20));
        partidaNueva.setBackground(Color.decode("#cfe2f3"));
        partidaNueva.setMaximumSize(new Dimension(200,50));

        perfil.setFont(new Font("Arial", Font.PLAIN, 20));
        perfil.setBackground(Color.decode("#cfe2f3"));
        perfil.setMaximumSize(new Dimension(200, 50));

        universo.setFont(new Font("Arial", Font.PLAIN, 20));
        universo.setBackground(Color.decode("#cfe2f3"));
        universo.setMaximumSize(new Dimension(200, 50));

        exit.setFont(new Font("Arial", Font.PLAIN, 20));
        exit.setBackground(Color.decode("#cfe2f3"));
        exit.setMaximumSize(new Dimension(200, 50));

        menuTitulo1.setAlignmentX(Component.CENTER_ALIGNMENT);
        partidaNueva.setAlignmentX(Component.CENTER_ALIGNMENT);
        perfil.setAlignmentX(Component.CENTER_ALIGNMENT);
        universo.setAlignmentX(Component.CENTER_ALIGNMENT);
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);

        menuPanel1.setBackground(Color.decode("#333333"));

        menuPanel1.add(Box.createVerticalGlue());

        menuPanel1.setLayout(new BoxLayout(menuPanel1, BoxLayout.Y_AXIS));
        menuPanel1.add(menuTitulo1);
        menuPanel1.add(Box.createVerticalStrut(50));
        menuPanel1.add(partidaNueva);
        menuPanel1.add(Box.createVerticalStrut(5));
        menuPanel1.add(perfil);
        menuPanel1.add(Box.createVerticalStrut(5));
        menuPanel1.add(universo);
        menuPanel1.add(Box.createVerticalStrut(5));
        menuPanel1.add(exit);

        menuPanel1.add(Box.createVerticalGlue());

        add(menuPanel1, BorderLayout.CENTER);
        setLocationRelativeTo(null);

        //Botones
        partidaNueva.addActionListener(e -> {
            nuevaPartida();
        });

        perfil.addActionListener(e ->{
            try {
                admin.checkActivePlayer();
                verPerfil.actualizarDatos();
                verPerfil.setLocation(getX() + 75, getY() + 100);
                verPerfil.setVisible(true);

            } catch (NoAccountLoggedException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        universo.addActionListener(e ->{
            JOptionPane.showMessageDialog(this, "Función en construccion...", "No disponible", JOptionPane.WARNING_MESSAGE);
        });

        exit.addActionListener(e ->{
            System.exit(0);
        });
    }

    private void nuevaPartida() {
        Player activo = admin.getActivePlayer();
        Player[] players = admin.getPlayers();

        int cont = 0;
        for (int i = 0; i < players.length; i++) {
            if (players[i] != null && players[i] != activo) {
                cont++;
            }
        }
        if (cont == 0) {
            JOptionPane.showMessageDialog(this, "Se necesita al menos otro jugador registrado para jugar.", "No disponible", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String[] nombres = new String[cont];
        int j = 0;
        for (int i = 0; i < players.length; i++) {
            if (players[i] != null && players[i] != activo) {
                nombres[j] = players[i].username;
                j++;
            }
        }

        String nombreRival = (String) JOptionPane.showInputDialog(this, "Elige a tu rival:", "Partida Nueva", JOptionPane.QUESTION_MESSAGE, null, nombres, nombres[0]);
        if (nombreRival == null) {
            return;
        }
        Player rival = admin.findPlayer(nombreRival);

        String[] bandos = {"Héroes", "Villanos"};
        int opcion = JOptionPane.showOptionDialog(this, "Elige tu bando:", "Partida Nueva", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, bandos, bandos[0]);
        if (opcion == -1) {
            return;
        }

        if (opcion == 0) {
            new MenuJuego(new Tablero(), activo, rival).setVisible(true);
        }
        else {
            new MenuJuego(new Tablero(), rival, activo).setVisible(true);
        }
    }

}
