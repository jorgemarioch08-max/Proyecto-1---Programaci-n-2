package proyecto1;

import enums.Bando;
import enums.Motivo;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class MenuJuego extends JFrame {

    Tablero tablero;
    JButton[][] botones;
    JLabel grid = new JLabel(new ImageIcon("src/Imagenes/tablero.png"));
    JPanel panelLateral = new JPanel();
    JPanel heroesVPanel = new JPanel();
    JPanel villanosVPanel = new JPanel();

    JLabel lblTurno = new JLabel("Turno de: ");
    JLabel heroesVlbl = new JLabel("Héroes Vencidos: ");
    JLabel villanosVlbl = new JLabel("Villanos Vencidos: ");

    JButton retiro = new JButton("RETIRARSE");

    Player jugadorHeroes;
    Player jugadorVillanos;

    //Admin
    PlayerManager admin;

    public MenuJuego(Tablero tablero, Player jugadorHeroes, Player jugadorVillanos, PlayerManager admin) {
        this.tablero = tablero;
        this.jugadorHeroes = jugadorHeroes;
        this.jugadorVillanos = jugadorVillanos;
        botones = new JButton[10][10];
        this.admin = admin;

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
        heroesVPanel.setPreferredSize(new Dimension(400, 230));
        heroesVPanel.setMaximumSize(new Dimension(400, 230));
        heroesVPanel.setLayout(new FlowLayout());

        villanosVPanel.setBackground(Color.decode("#999999"));
        villanosVPanel.setPreferredSize(new Dimension(400, 230));
        villanosVPanel.setMaximumSize(new Dimension(400, 230));
        villanosVPanel.setLayout(new FlowLayout());

        lblTurno.setFont(new Font("Arial", Font.BOLD, 22));
        lblTurno.setForeground(Color.white);

        heroesVlbl.setFont(new Font("Arial", Font.BOLD, 16));
        heroesVlbl.setForeground(Color.white);

        villanosVlbl.setFont(new Font("Arial", Font.BOLD, 16));
        villanosVlbl.setForeground(Color.white);

        retiro.setFont(new Font("Arial", Font.BOLD, 25));
        retiro.setPreferredSize(new Dimension(200, 50));
        retiro.setMaximumSize(new Dimension(200, 50));
        retiro.setForeground(Color.white);
        retiro.setBackground(Color.decode("#990000"));
        retiro.setFocusPainted(false);

        panelLateral.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 0));

        lblTurno.setAlignmentX(Component.LEFT_ALIGNMENT);
        heroesVlbl.setAlignmentX(Component.LEFT_ALIGNMENT);
        heroesVPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        villanosVlbl.setAlignmentX(Component.LEFT_ALIGNMENT);
        villanosVPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        retiro.setAlignmentX(Component.LEFT_ALIGNMENT);

        panelLateral.add(Box.createVerticalGlue());

        panelLateral.add(lblTurno);
        panelLateral.add(Box.createVerticalStrut(25));
        panelLateral.add(heroesVlbl);
        panelLateral.add(Box.createVerticalStrut(5));
        panelLateral.add(heroesVPanel);
        panelLateral.add(Box.createVerticalStrut(10));
        panelLateral.add(villanosVlbl);
        panelLateral.add(Box.createVerticalStrut(5));
        panelLateral.add(villanosVPanel);
        panelLateral.add(Box.createVerticalStrut(50));
        panelLateral.add(retiro);

        panelLateral.add(Box.createVerticalGlue());

        add(zonaTablero, BorderLayout.CENTER);
        add(panelLateral, BorderLayout.EAST);

        retiro.addActionListener(e -> {
            String nombre;
            if (tablero.getTurno() == Bando.HEROES) {
                nombre = jugadorHeroes.username;
            }
            else {
                nombre = jugadorVillanos.username;
            }

            int opcion = JOptionPane.showConfirmDialog(this,
                    nombre + ", ¿seguro que quieres retirarte?\nLa partida se dará por terminada y tu rival ganará 3 puntos en el ranking.",
                    "Retirarse", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (opcion == JOptionPane.YES_OPTION) {
                if (tablero.getTurno() == Bando.HEROES) {
                    terminarPartida(Bando.VILLANOS, Motivo.RETIRO);
                }
                else {
                    terminarPartida(Bando.HEROES, Motivo.RETIRO);
                }
                dispose();
            }
        });

        actualizarTablero();
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

                botones[fila][columna].addActionListener(e -> {
                    clickCasilla(f,c);
                    actualizarTablero();
                });

                botones[fila][columna].setFocusPainted(false);

                grid.add(botones[fila][columna]);
            }
        }
    }

    public void actualizarTablero() {
        for(int fila = 0; fila < 10; fila++){
            for(int columna = 0; columna < 10; columna++){
                JButton boton =  botones[fila][columna];
                Casilla casilla = tablero.getCasilla(fila, columna);
                Pieza pieza = casilla.getPieza();

                boton.setIcon(null);
                boton.setText("");

                if (casilla == tablero.getSeleccionada()) {
                    boton.setBorder(BorderFactory.createLineBorder(Color.decode("#ffc925"), 3));
                }
                else if (tablero.esMovimientoValido(fila, columna)) {
                    boton.setBorder(BorderFactory.createLineBorder(Color.decode("#8fce00"), 3));
                }
                else {
                    boton.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
                }

                //Sin pieza, se ve el fondo
                if (pieza == null) {
                    boton.setContentAreaFilled(false);
                }
                //Pieza revelada
                else if (tablero.esVisible(pieza)) {
                    boton.setContentAreaFilled(true);
                    Image img = pieza.getImagen().getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
                    boton.setIcon(new ImageIcon(img));

                    if (pieza.getBando() == Bando.HEROES) {
                        boton.setBackground(Color.decode("#4a6fa5"));
                    }
                    else {
                        boton.setBackground(Color.decode("#c0392b"));
                    }
                }
                //Pieza oculta
                else  {
                    boton.setContentAreaFilled(true);
                    boton.setText("?");
                    boton.setFont(new Font("Arial", Font.BOLD, 40));
                    boton.setForeground(Color.white);

                    if (pieza.getBando() == Bando.HEROES) {
                        boton.setBackground(Color.decode("#1f3a5f"));
                    }
                    else {
                        boton.setBackground(Color.decode("#5c0000"));
                    }
                }
            }
        }

        if (tablero.getTurno() == Bando.HEROES) {
            lblTurno.setText("Turno de: " + jugadorHeroes.username + " (HÉROES)");
        }
        else {
            lblTurno.setText("Turno de: " + jugadorVillanos.username + " (VILLANOS)");
        }

        mostrarVencidos(heroesVPanel, tablero.getHeroesVencidos(), tablero.getContHeroesV());
        mostrarVencidos(villanosVPanel, tablero.getVillanosVencidos(), tablero.getContVillanosV());
    }

    private void mostrarVencidos(JPanel panel, Pieza[] vencidos, int cont) {
        panel.removeAll();

        for (int i = 0; i < cont; i++) {
            Image img = vencidos[i].getImagen().getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
            panel.add(new JLabel(new ImageIcon(img)));
        }

        panel.revalidate();
        panel.repaint();
    }

    public void clickCasilla(int fila, int columna) {
        if (tablero.esMovimientoValido(fila, columna)) {
            tablero.mover(fila, columna);
            if (tablero.getGanador() != null) {
                actualizarTablero();
                terminarPartida(tablero.getGanador(), Motivo.TIERRA);
                return;
            }
            if (!tablero.tieneMovimientos(tablero.getTurno(), 0)) {
                actualizarTablero();
                if (tablero.getTurno() == Bando.HEROES) {
                    terminarPartida(Bando.VILLANOS, Motivo.SIN_MOVIMIENTOS);
                }
                else {
                    terminarPartida(Bando.HEROES, Motivo.SIN_MOVIMIENTOS);
                }
            }
        }
        else {
            tablero.seleccionar(fila, columna);
        }
    }

    public void terminarPartida(Bando bandoGanador, Motivo motivo) {
        Player ganador;
        Player perdedor;
        String bandoG;
        String bandoP;
        String fecha;
        String mensaje="";

        if (bandoGanador == Bando.HEROES) {
            ganador = jugadorHeroes;
            perdedor = jugadorVillanos;
            bandoG = "HÉROES";
            bandoP = "VILLANOS";
        }
        else {
            ganador = jugadorVillanos;
            perdedor = jugadorHeroes;
            bandoG = "VILLANOS";
            bandoP = "HÉROES";
        }

        fecha = LocalDate.now().toString();

        switch (motivo) {
            case TIERRA:
                if (bandoGanador == Bando.HEROES) {
                    mensaje = ganador.username+" del bando "+bandoG+" ha SALVADO LA TIERRA! Venciendo a "+perdedor.username+" - "+fecha;
                }
                else {
                    mensaje = ganador.username+" del bando "+bandoG+" ha CAPTURADO LA TIERRA! Venciendo a "+perdedor.username+" - "+fecha;
                }
                ganador.puntos+=10;
                perdedor.puntos-=5;
                break;
            case SIN_MOVIMIENTOS:
                mensaje = perdedor.username+" del bando "+bandoP+" ha perdido por no tener movimientos válidos disponibles ante "+ganador.username+" - "+fecha;
                ganador.puntos+=10;
                perdedor.puntos-=5;
                break;
            case RETIRO:
                mensaje = ganador.username+" del bando "+bandoG+" ha ganado porque "+perdedor.username+" del bando "+bandoP+" se ha retirado de la partida. "+fecha;
                ganador.puntos+=3;
                break;
        }

        jugadorHeroes.partidasHeroes++;
        jugadorHeroes.partidasTotales++;
        jugadorVillanos.partidasVillanos++;
        jugadorVillanos.partidasTotales++;

        ganador.addLog(mensaje);
        perdedor.addLog(mensaje);
        admin.registrarPartida(bandoGanador);

        if (motivo != Motivo.RETIRO) {
            new FinPartida(this, mensaje, ganador, bandoGanador, jugadorHeroes, jugadorVillanos).setVisible(true);
        }
    }

    //Getters
    public PlayerManager getAdmin() {
        return admin;
    }
}

