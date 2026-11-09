package proyecto1;

import enums.Bando;

import javax.swing.*;
import java.awt.*;

public class FinPartida extends JDialog {

    JLabel titulo = new JLabel();
    JLabel lblMensaje = new JLabel();

    JButton reiniciar = new JButton("Reiniciar");
    JButton menu = new JButton("Volver al menú");
    JButton salir = new JButton("Salir");

    JPanel panel = new JPanel();
    JPanel hbox = new JPanel();

    Dimension tamañoBtn = new Dimension(170, 50);

    public FinPartida(MenuJuego juego, String mensaje, Player ganador, Bando bandoGanador, Player jugadorH, Player jugadorV) {
        setTitle("Fin de la partida");
        setSize(800,500);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout(10,10));
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModal(true);

        titulo.setText(ganador.username+" ha ganado con los "+bandoGanador);
        titulo.setFont(new Font("Arial",Font.BOLD,30));
        titulo.setForeground(Color.white);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        lblMensaje.setText("<html><div style='text-align:center; width:480px'>" + mensaje + "</div></html>");
        lblMensaje.setFont(new Font("Arial",Font.PLAIN,20));
        lblMensaje.setForeground(Color.white);
        lblMensaje.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblMensaje.setHorizontalAlignment(JLabel.CENTER);

        reiniciar.setFont(new Font("Arial",Font.BOLD,16));
        reiniciar.setBackground(Color.decode("#cfe2f3"));
        reiniciar.setPreferredSize(tamañoBtn);
        reiniciar.setMaximumSize(tamañoBtn);

        menu.setFont(new Font("Arial",Font.BOLD,16));
        menu.setBackground(Color.decode("#cfe2f3"));
        menu.setPreferredSize(tamañoBtn);
        menu.setMaximumSize(tamañoBtn);

        salir.setFont(new Font("Arial",Font.BOLD,16));
        salir.setBackground(Color.decode("#cfe2f3"));
        salir.setPreferredSize(tamañoBtn);
        salir.setMaximumSize(tamañoBtn);

        hbox.setBackground(Color.decode("#333333"));
        hbox.setLayout(new BoxLayout(hbox,BoxLayout.X_AXIS));

        hbox.add(Box.createHorizontalGlue());

        hbox.add(reiniciar);
        hbox.add(Box.createHorizontalStrut(5));
        hbox.add(menu);
        hbox.add(Box.createHorizontalStrut(5));
        hbox.add(salir);

        hbox.add(Box.createHorizontalGlue());

        panel.setBackground(Color.decode("#333333"));
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

        panel.add(Box.createVerticalGlue());

        panel.add(titulo);
        panel.add(Box.createVerticalStrut(25));
        panel.add(lblMensaje);
        panel.add(Box.createVerticalStrut(10));
        panel.add(hbox);

        panel.add(Box.createVerticalGlue());

        add(panel);

        //ActionListeners
        reiniciar.addActionListener(e -> {
            dispose();
            juego.dispose();
            new MenuJuego(new Tablero(), jugadorH, jugadorV, juego.getAdmin()).setVisible(true);
        });

        menu.addActionListener(e -> {
            dispose();
            juego.dispose();
        });

        salir.addActionListener(e -> {
            System.exit(0);
        });
    }

}
