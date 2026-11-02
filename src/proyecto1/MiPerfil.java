package proyecto1;

import javax.swing.*;
import java.awt.*;
import Exceptions.*;

public class MiPerfil extends JDialog {

    //Admin
    PlayerManager admin;

    MainMenu mainMenu;

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
    JButton deleteAcc = new JButton("Eliminar cuenta");
    JButton newPass = new JButton("Cambiar contraseña");

    public MiPerfil(PlayerManager admin,  MainMenu mainMenu) {
        super((Frame) null, "Mi Perfil", false);

        this.admin = admin;
        this.mainMenu = mainMenu;

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

        deleteAcc.setFont(new Font("Arial", Font.PLAIN, 20));
        deleteAcc.setBackground(Color.decode("#cfe2f3"));
        deleteAcc.setPreferredSize(new Dimension(200, 35));
        deleteAcc.setMaximumSize(new Dimension(200, 35));

        newPass.setFont(new Font("Arial", Font.BOLD, 14));
        newPass.setBackground(Color.decode("#cfe2f3"));
        newPass.setPreferredSize(new Dimension(200, 35));
        newPass.setMaximumSize(new Dimension(200, 35));

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
        panel1.add(newPass);
        newPass.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel1.add(Box.createVerticalStrut(10));
        panel1.add(cerrarSesion);
        cerrarSesion.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel1.add(Box.createVerticalStrut(10));
        panel1.add(deleteAcc);
        deleteAcc.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel1.add(Box.createVerticalStrut(10));


        panel1.add(Box.createVerticalGlue());


        //Action Listeners
        newPass.addActionListener(e -> {
            JPasswordField currentPassword = new JPasswordField();
            JPasswordField newPassword = new JPasswordField();

            Object[] mensaje = {
                    "Ingresa tu contraseña actual:",
                    currentPassword,
                    "Ingresa tu nueva contraseña:",
                    newPassword
            };

            int opc = JOptionPane.showConfirmDialog(this, mensaje, "Cambiar contraseña", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE
            );

            if (opc == JOptionPane.OK_OPTION) {
                try {
                    boolean cambiado = admin.changePassword(new String(currentPassword.getPassword()), new String(newPassword.getPassword()));
                    if (cambiado) {
                        JOptionPane.showMessageDialog(this, "Tu contraseña ha sido actualizada correctamente.", "Contraseña modificada", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "La contraseña actual es incorrecta.", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (InvalidPasswordException | NoAccountLoggedException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        cerrarSesion.addActionListener(e ->{
            try {
                admin.logoutPlayer();
                mainMenu.dispose();
                MenuInicial inicial = new MenuInicial(admin);
                inicial.setVisible(true);
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(this, "Has cerrado sesión con exito." +
                    "\nPara poder jugar deber iniciar sesión o crear una nueva cuenta", "Sesión Cerrada", JOptionPane.INFORMATION_MESSAGE);
        });

        deleteAcc.addActionListener(e -> {
            JPasswordField password = new JPasswordField();
            Object[] mensaje = {
                    "Esta acción eliminará permanentemente tu cuenta.",
                    "Ingresa tu contraseña actual:",
                    password
            };
            int opcion = JOptionPane.showConfirmDialog(this, mensaje, "Eliminar cuenta", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE
            );

            if (opcion == JOptionPane.OK_OPTION) {
                try {
                    boolean eliminado = admin.deletePlayer(new String(password.getPassword())
                    );
                    if (eliminado) {
                        JOptionPane.showMessageDialog(this, "Tu cuenta ha sido eliminada correctamente.", "Cuenta eliminada", JOptionPane.INFORMATION_MESSAGE);
                        mainMenu.dispose();
                        MenuInicial inicial = new MenuInicial(admin);
                        inicial.setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "La contraseña ingresada es incorrecta.", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NoAccountLoggedException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
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
