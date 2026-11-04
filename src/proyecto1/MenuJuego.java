package proyecto1;

import javax.swing.*;
import java.awt.*;

public class MenuJuego extends JFrame {

    Tablero tablero;
    JButton[][] botones;
    JPanel grid = new JPanel();
    JPanel panelLateral = new JPanel();
    JPanel heroesVPanel = new JPanel();
    JPanel villanosVPanel = new JPanel();

    JLabel lblTurno = new JLabel("Turno de: ");
    JLabel ptsHeroes = new JLabel("Puntos de los Heroes: ");
    JLabel ptsVillanos = new JLabel("Puntos de los Villanos: ");
    JLabel heroesVlbl = new JLabel("Héroes Vencidos: ");
    JLabel villanosVlbl = new JLabel("Villanos Vencidos: ");

    JButton retiro = new JButton("RETIRARSE");

    public MenuJuego(Tablero tablero) {
        this.tablero = tablero;
        botones = new JButton[10][10];

        setTitle("Marvel Heroes: Stratego");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        grid.setLayout(new GridLayout(10, 10, 2, 2));
        grid.setPreferredSize(new Dimension(800, 800));

        crearBotones();

        JPanel zonaTablero = new JPanel(new GridBagLayout());
        zonaTablero.setBackground(Color.decode("#333333"));
        zonaTablero.add(grid);

        panelLateral.setPreferredSize(new Dimension(550, 0));
        panelLateral.setBackground(Color.decode("#444444"));
        panelLateral.setLayout(new BoxLayout(panelLateral, BoxLayout.Y_AXIS));

        heroesVPanel.setBackground(Color.decode("#999999"));
        heroesVPanel.setPreferredSize(new Dimension(400, 300));
        heroesVPanel.setMaximumSize(new Dimension(400, 300));
        heroesVPanel.setLayout(new FlowLayout());

        villanosVPanel.setBackground(Color.decode("#999999"));
        villanosVPanel.setPreferredSize(new Dimension(400, 300));
        villanosVPanel.setMaximumSize(new Dimension(400, 300));
        villanosVPanel.setLayout(new FlowLayout());

        lblTurno.setFont(new Font("Arial", Font.BOLD, 22));
        lblTurno.setForeground(Color.white);

        ptsHeroes.setFont(new Font("Arial", Font.PLAIN, 16));
        ptsHeroes.setForeground(Color.white);

        ptsVillanos.setFont(new Font("Arial", Font.PLAIN, 16));
        ptsVillanos.setForeground(Color.white);

        heroesVlbl.setFont(new Font("Arial", Font.BOLD, 16));
        heroesVlbl.setForeground(Color.white);

        villanosVlbl.setFont(new Font("Arial", Font.BOLD, 16));
        villanosVlbl.setForeground(Color.white);

        retiro.setFont(new Font("Arial", Font.BOLD, 20));
        retiro.setForeground(Color.white);
        retiro.setBackground(Color.decode("#990000"));

        panelLateral.add(Box.createVerticalGlue());

        panelLateral.add(lblTurno);
        lblTurno.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelLateral.add(Box.createVerticalStrut(10));
        panelLateral.add(ptsHeroes);
        ptsHeroes.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelLateral.add(Box.createVerticalStrut(5));
        panelLateral.add(ptsVillanos);
        ptsVillanos.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelLateral.add(Box.createVerticalStrut(10));
        panelLateral.add(heroesVlbl);
        heroesVlbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelLateral.add(Box.createVerticalStrut(5));
        panelLateral.add(heroesVPanel);
        heroesVPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelLateral.add(Box.createVerticalStrut(10));
        panelLateral.add(villanosVlbl);
        villanosVPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelLateral.add(Box.createVerticalStrut(5));
        panelLateral.add(villanosVPanel);
        villanosVPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelLateral.add(Box.createVerticalStrut(25));
        panelLateral.add(retiro);
        retiro.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelLateral.add(Box.createVerticalGlue());

        add(zonaTablero, BorderLayout.CENTER);
        add(panelLateral, BorderLayout.EAST);


    }

    public void crearBotones(){
        int fila;
        int columna;

        for(fila = 0; fila < 10; fila++){
            for(columna = 0; columna < 10; columna++){
                botones[fila][columna] = new JButton();
                botones[fila][columna].setBackground(Color.white);

                if(tablero.getCasilla(fila, columna).isProhibida()) {
                    botones[fila][columna].setEnabled(false);
                    botones[fila][columna].setBackground(Color.yellow);
                }

                int f = fila;
                int c = columna;

                //////////////////////////TEMPORAL//////////////////////////
                botones[fila][columna].addActionListener(e -> {
                    System.out.println(f + ", " + c);
                });

                grid.add(botones[fila][columna]);
            }
        }
    }
}

