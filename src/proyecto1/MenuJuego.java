package proyecto1;

import javax.swing.*;
import java.awt.*;

public class MenuJuego extends JFrame {

    Tablero tablero;
    JButton[][] botones;
    JPanel grid = new JPanel();

    public MenuJuego(Tablero tablero) {
        setTitle("Marvel Heroes: Stratego");
        setSize(1600, 900);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        grid.setLayout(new GridLayout(10, 10));

        crearBotones();

    }

    public void crearBotones(){
        int fila;
        int columna = 0;

        for(fila = 0; fila < 10; fila++){
            for(columna = 0; columna < 10; columna++){
                botones[fila][columna] = new JButton();
                grid.add(botones[fila][columna]);
                botones[fila][columna].setBackground(Color.white);

                if(tablero.getCasilla(columna, fila).isProhibida()) {
                    botones[fila][columna].setBackground(Color.yellow);
                }
            }
        }

        int f = fila;
        int c = columna;
        //////////////////////////TEMPORAL//////////////////////////
        botones[fila][columna].addActionListener(e -> {
            System.out.println(f + ", " + c);
        });


    }
}

