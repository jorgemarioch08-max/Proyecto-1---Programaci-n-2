package proyecto1;

import enums.Bando;
import javax.swing.*;
import java.awt.*;

public class UniversoMarvel extends JDialog {

    PlayerManager admin;

    JPanel panelR = new JPanel();
    JPanel panelB = new JPanel();

    JLabel lblRanking = new JLabel("Ranking:");

    JTextArea txtRanking = new JTextArea();

    JScrollPane scroll = new JScrollPane(txtRanking);

    JLabel lblBatallas = new JLabel("Batallas");
    JLabel lblActivos = new JLabel();
    JLabel lblHistoricos = new JLabel();
    JLabel lblPartidas = new JLabel();
    JLabel lblVHeroes = new JLabel();
    JLabel lblVVillanos = new JLabel();

    public UniversoMarvel(PlayerManager admin) {
        this.admin = admin;

        setTitle("Universo Marvel");
        setSize(900, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModal(true);
        setLayout(new GridLayout(1, 2));

        //Ranking
        lblRanking.setFont(new Font("Arial", Font.BOLD, 25));
        lblRanking.setForeground(Color.white);

        txtRanking.setEditable(false);
        txtRanking.setFont(new Font("Arial", Font.BOLD, 25));
        txtRanking.setBackground(Color.decode("#444444"));
        txtRanking.setForeground(Color.white);
        txtRanking.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        scroll.setBorder(null);

        panelR.setLayout(new BorderLayout(0, 15));
        panelR.setBackground(Color.decode("#333333"));
        panelR.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 20));
        panelR.add(lblRanking, BorderLayout.NORTH);
        panelR.add(scroll, BorderLayout.CENTER);

        //Batallas
        lblBatallas.setFont(new Font("Arial", Font.BOLD, 25));
        lblBatallas.setForeground(Color.white);

        lblActivos.setFont(new Font("Arial", Font.PLAIN, 18));
        lblActivos.setForeground(Color.white);
        lblHistoricos.setFont(new Font("Arial", Font.PLAIN, 18));
        lblHistoricos.setForeground(Color.white);
        lblPartidas.setFont(new Font("Arial", Font.PLAIN, 18));
        lblPartidas.setForeground(Color.white);
        lblVHeroes.setFont(new Font("Arial", Font.PLAIN, 18));
        lblVHeroes.setForeground(Color.white);
        lblVVillanos.setFont(new Font("Arial", Font.PLAIN, 18));
        lblVVillanos.setForeground(Color.white);

        panelB.setLayout(new BoxLayout(panelB, BoxLayout.Y_AXIS));
        panelB.setBackground(Color.decode("#333333"));
        panelB.setBorder(BorderFactory.createEmptyBorder(40, 20, 40, 40));
        panelB.add(lblBatallas);
        panelB.add(Box.createVerticalStrut(25));
        panelB.add(lblActivos);
        panelB.add(Box.createVerticalStrut(10));
        panelB.add(lblHistoricos);
        panelB.add(Box.createVerticalStrut(10));
        panelB.add(lblPartidas);
        panelB.add(Box.createVerticalStrut(10));
        panelB.add(lblVHeroes);
        panelB.add(Box.createVerticalStrut(10));
        panelB.add(lblVVillanos);

        add(panelR);
        add(panelB);

        actualizarDatos();
    }

    public void actualizarDatos(){
        Player[] lista = admin.getRanking();
        String txt = "";

        for(int i = 0; i < lista.length; i++) {
            txt+=(i + 1) + " — " + lista[i].username + " — " + lista[i].puntos + "\n";
        }
        txtRanking.setText(txt);

        lblActivos.setText("Usuarios activos: "+admin.contarActivos());
        lblHistoricos.setText("Usuarios Historicos: "+admin.getUsuariosHistoricos());
        lblPartidas.setText("Partidas jugadas: " + admin.getContPartidas());
        lblVHeroes.setText("Victorias de los HÉROES: " + admin.contarVictorias(Bando.HEROES, 0));
        lblVVillanos.setText("Victorias de los VILLANOS: " + admin.contarVictorias(Bando.VILLANOS, 0));
    }

}
