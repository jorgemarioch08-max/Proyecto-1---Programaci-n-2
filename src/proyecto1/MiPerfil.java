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
        setSize(400, 700);
        setResizable(false);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        lbl1.setFont(new Font("Arial", Font.BOLD, 25));

        Image img = icon.getImage();
        Image imgsc =  img.getScaledInstance(175, 175, Image.SCALE_SMOOTH);
        lbl1.setIcon(new ImageIcon(imgsc));
        lbl1.setVerticalTextPosition(JLabel.TOP);
        lbl1.setHorizontalTextPosition(JLabel.CENTER);

        lbl2.setFont(new Font("Arial", Font.PLAIN, 20));
        userNamme.setFont(new Font("Arial", Font.BOLD, 25));
        lbl3.setFont(new Font("Arial", Font.PLAIN, 18));
        lbl4.setFont(new Font("Arial", Font.BOLD, 20));
        lbl5.setFont(new Font("Arial", Font.PLAIN, 18));
        lbl6.setFont(new Font("Arial", Font.PLAIN, 18));
        lbl7.setFont(new Font("Arial", Font.PLAIN, 18));

        cerrarSesion.setFont(new Font("Arial", Font.PLAIN, 20));
        cerrarSesion.setBackground(Color.decode("#cfe2f3"));
        cerrarSesion.setPreferredSize(new Dimension(200, 35));
        cerrarSesion.setMaximumSize(new Dimension(200, 35));

        leaderboard.setFont(new Font("Arial", Font.PLAIN, 20));
        leaderboard.setBackground(Color.decode("#cfe2f3"));
        leaderboard.setPreferredSize(new Dimension(200, 35));
        leaderboard.setMaximumSize(new Dimension(200, 35));

        panel1.add(Box.createVerticalGlue());

        panel1.add(lbl1);
        lbl1.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel1.add(Box.createVerticalStrut(10));
        panel1.add(lbl2);
        lbl2.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel1.add(Box.createVerticalStrut(5));
        panel1.add(userNamme);
        userNamme.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel1.add(Box.createVerticalStrut(5));
        panel1.add(lbl3);
        lbl3.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel1.add(Box.createVerticalStrut(35));
        panel1.add(lbl4);
        lbl4.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel1.add(Box.createVerticalStrut(15));
        panel1.add(lbl5);
        lbl5.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel1.add(Box.createVerticalStrut(8));
        panel1.add(lbl6);
        lbl6.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel1.add(Box.createVerticalStrut(8));
        panel1.add(lbl7);
        lbl7.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel1.add(Box.createVerticalStrut(35));
        panel1.add(cerrarSesion);
        cerrarSesion.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel1.add(Box.createVerticalStrut(10));
        panel1.add(leaderboard);
        leaderboard.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel1.add(Box.createVerticalGlue());


        //Action Listeners
        cerrarSesion.addActionListener(e ->{
            try {
                admin.logoutPlayer();
                setVisible(false);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(this, "Has cerrado sesión con extio." +
                    "\nPara poder jugar deber iniciar sesión o crear una nueva cuenta", "Sesión Cerrada", JOptionPane.INFORMATION_MESSAGE);
        });

        add(panel1, BorderLayout.CENTER);
    }

    public void actualizarDatos() {
        Player lclplayer = admin.getActivePlayer();

        userNamme.setText(lclplayer.username);
        lbl5.setText("Partidas jugadas: " + lclplayer.partidasTotales);
        lbl6.setText("Partidas jugadas como héroe: " + lclplayer.partidasHeroes);
        lbl7.setText("Partidas jugadas como villano: " + lclplayer.partidasVillanos);
    }
}
