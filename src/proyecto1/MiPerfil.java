package proyecto1;

import javax.swing.*;
import java.awt.*;
import Exceptions.*;

public class MiPerfil extends JDialog {

    //Admin
    PlayerManager admin;

    JPanel panel1 = new JPanel();

    JLabel lbl1 = new JLabel("Perfil");
    JLabel lbl2 = new JLabel("Nombre de usuario: ");
    JLabel userNamme = new JLabel();
    JLabel lbl3 = new JLabel("Sesión activa.");
    JLabel lbl4 = new JLabel("Estadisticas");
    JLabel lbl5 = new JLabel();
    JLabel lbl6 = new JLabel();
    JLabel lbl7 = new JLabel();

    ImageIcon icon = new ImageIcon("src/Imagenes/perfil.png");

    JButton cerrarSesion = new JButton("Cerrar sesion");
    JButton leaderboard = new JButton("Ver Leaderboard");

    public MiPerfil(PlayerManager admin) {
        super((Frame) null, "Mi Perfil", false);

        this.admin = admin;

        setTitle("Mi Perfil");
        setSize(800, 900);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

        lbl1.setFont(new Font("Arial", Font.BOLD, 25));
        lbl1.setAlignmentX(Component.CENTER_ALIGNMENT);
        lbl1.setAlignmentY(Component.CENTER_ALIGNMENT);

        Image img = icon.getImage();
        Image imgsc =  img.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        lbl1.setIcon(new ImageIcon(imgsc));
        lbl1.setHorizontalAlignment(JLabel.CENTER);
        lbl1.setVerticalAlignment(JLabel.TOP);

        lbl2.setFont(new Font("Arial", Font.PLAIN, 20));
        lbl2.setAlignmentX(Component.CENTER_ALIGNMENT);
        lbl2.setAlignmentY(Component.CENTER_ALIGNMENT);

        userNamme.setFont(new Font("Arial", Font.BOLD, 22));
        userNamme.setAlignmentX(Component.CENTER_ALIGNMENT);
        userNamme.setAlignmentY(Component.CENTER_ALIGNMENT);
        userNamme.setText(admin.getActivePlayer().username);

        lbl3.setFont(new Font("Arial", Font.PLAIN, 18));
        lbl3.setAlignmentX(Component.CENTER_ALIGNMENT);
        lbl3.setAlignmentY(Component.CENTER_ALIGNMENT);

        lbl4.setFont(new Font("Arial", Font.BOLD, 20));
        lbl4.setAlignmentX(Component.CENTER_ALIGNMENT);
        lbl4.setAlignmentY(Component.CENTER_ALIGNMENT);

        lbl5.setFont(new Font("Arial", Font.PLAIN, 18));
        lbl5.setAlignmentX(Component.CENTER_ALIGNMENT);
        lbl5.setAlignmentY(Component.CENTER_ALIGNMENT);
        lbl5.setText("Partidas jugadas: " + new String(String.valueOf(admin.getActivePlayer().partidasTotales)));

        lbl6.setFont(new Font("Arial", Font.PLAIN, 18));
        lbl6.setAlignmentX(Component.CENTER_ALIGNMENT);
        lbl6.setAlignmentY(Component.CENTER_ALIGNMENT);
        lbl6.setText("Partidas jugadas como héroe: " + new String(String.valueOf(admin.getActivePlayer().partidasHeroes)));

        lbl7.setFont(new Font("Arial", Font.PLAIN, 18));
        lbl7.setAlignmentX(Component.CENTER_ALIGNMENT);
        lbl7.setAlignmentY(Component.CENTER_ALIGNMENT);
        lbl7.setText("Partidas jugadas como villano: " +  new String(String.valueOf(admin.getActivePlayer().partidasVillanos)));


        cerrarSesion.setFont(new Font("Arial", Font.PLAIN, 20));
        cerrarSesion.setBackground(Color.decode("#cfe2f3"));
        cerrarSesion.setPreferredSize(new Dimension(200, 50));
        cerrarSesion.setMaximumSize(new Dimension(200, 50));

        leaderboard.setFont(new Font("Arial", Font.PLAIN, 20));
        leaderboard.setBackground(Color.decode("#cfe2f3"));
        leaderboard.setPreferredSize(new Dimension(200, 50));
        leaderboard.setMaximumSize(new Dimension(200, 50));

        panel1.add(Box.createVerticalGlue());

        panel1.add(lbl1);
        panel1.add(Box.createVerticalStrut(10));
        panel1.add(lbl2);
        panel1.add(Box.createVerticalStrut(8));
        panel1.add(userNamme);
        panel1.add(Box.createVerticalStrut(5));
        panel1.add(lbl3);
        panel1.add(Box.createVerticalStrut(20));
        panel1.add(lbl4);
        panel1.add(Box.createVerticalStrut(15));
        panel1.add(lbl5);
        panel1.add(Box.createVerticalStrut(8));
        panel1.add(lbl6);
        panel1.add(Box.createVerticalStrut(8));
        panel1.add(lbl7);
        panel1.add(Box.createVerticalStrut(20));
        panel1.add(cerrarSesion);
        panel1.add(Box.createVerticalStrut(10));
        panel1.add(leaderboard);

        panel1.add(Box.createVerticalGlue());

        add(panel1, BorderLayout.CENTER);
    }
}
