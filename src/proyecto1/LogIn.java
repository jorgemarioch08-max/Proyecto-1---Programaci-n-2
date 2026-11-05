package proyecto1;

import javax.swing.*;
import Exceptions.*;

import java.awt.*;

public class LogIn extends JDialog {
    //Admin
    PlayerManager admin;

    //Menú Inicial
    MenuInicial inicial;

    //GUI
    JLabel titulo1 = new JLabel("Iniciar Sesion");
    JLabel nombre = new JLabel("Nombre de usuario: ");
    JLabel contrasena = new JLabel("Contraseña: ");

    ImageIcon icono = new ImageIcon("src/Imagenes/perfil.png");

    JTextField inputNombre = new JTextField();
    JPasswordField inputContrasena = new JPasswordField();

    JButton aceptar = new JButton("Aceptar");
    JButton cancelar = new JButton("Cancelar");

    JPanel hbox = new JPanel();
    JPanel vbox = new JPanel();
    JPanel vbox2 = new JPanel();

    public LogIn(PlayerManager admin,  MenuInicial inicial) {
        this.admin = admin;
        this.inicial = inicial;

        //GUI
        setTitle("Iniciar Sesion");
        setSize(500,800);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout(10,10));
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModal(true);

        hbox.setBackground(Color.decode("#333333"));
        vbox.setBackground(Color.decode("#333333"));
        vbox2.setBackground(Color.decode("#333333"));

        titulo1.setForeground(Color.white);
        nombre.setForeground(Color.white);
        contrasena.setForeground(Color.white);

        titulo1.setFont(new Font("Arial", Font.BOLD, 18));

        Image img = icono.getImage();
        Image imgsc = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        icono = new ImageIcon(imgsc);
        titulo1.setIcon(icono);
        titulo1.setHorizontalTextPosition(JLabel.CENTER);
        titulo1.setVerticalTextPosition(JLabel.TOP);
        titulo1.setIconTextGap(20);

        nombre.setPreferredSize(new Dimension(300,25));
        nombre.setMaximumSize(new Dimension(300,25));

        contrasena.setPreferredSize(new Dimension(300,25));
        contrasena.setMaximumSize(new Dimension(300,25));

        aceptar.setFont(new Font("Arial", Font.PLAIN, 16));
        aceptar.setBackground(Color.decode("#cfe2f3"));
        aceptar.setPreferredSize(new Dimension(140,25));
        aceptar.setMaximumSize(new Dimension(140, 25));

        cancelar.setFont(new Font("Arial", Font.PLAIN, 16));
        cancelar.setBackground(Color.decode("#cfe2f3"));
        cancelar.setPreferredSize(new Dimension(140,25));
        cancelar.setMaximumSize(new Dimension(140, 25));

        hbox.setLayout(new BoxLayout(hbox,BoxLayout.X_AXIS));
        hbox.setPreferredSize(new Dimension(500,75));
        hbox.setMaximumSize(new Dimension(500,75));

        hbox.add(Box.createHorizontalGlue());

        hbox.add(aceptar);
        hbox.add(Box.createHorizontalStrut(10));
        hbox.add(cancelar);

        hbox.add(Box.createHorizontalGlue());

        vbox.setLayout(new BoxLayout(vbox,BoxLayout.Y_AXIS));
        vbox2.setMaximumSize(new Dimension(300,150));
        vbox2.setPreferredSize(new Dimension(300,150));

        vbox2.add(Box.createVerticalGlue());

        vbox2.add(nombre);
        nombre.setAlignmentX(Component.LEFT_ALIGNMENT);
        vbox2.add(Box.createVerticalStrut(5));
        vbox2.add(inputNombre);
        inputNombre.setPreferredSize(new Dimension(299,25));
        inputNombre.setMaximumSize(new Dimension(299,25));
        inputNombre.setAlignmentX(Component.LEFT_ALIGNMENT);
        vbox2.add(Box.createVerticalStrut(5));
        vbox2.add(contrasena);
        contrasena.setAlignmentX(Component.LEFT_ALIGNMENT);
        vbox2.add(Box.createVerticalStrut(5));
        vbox2.add(inputContrasena);
        inputContrasena.setPreferredSize(new Dimension(299,25));
        inputContrasena.setMaximumSize(new Dimension(299,25));
        inputContrasena.setAlignmentX(Component.LEFT_ALIGNMENT);

        vbox.add(Box.createVerticalGlue());

        vbox.setLayout(new BoxLayout(vbox,BoxLayout.Y_AXIS));

        vbox.add(Box.createVerticalGlue());

        vbox.add(titulo1);
        titulo1.setAlignmentX(Component.CENTER_ALIGNMENT);
        vbox.add(Box.createVerticalStrut(20));
        vbox.add(vbox2);
        vbox2.setAlignmentX(Component.CENTER_ALIGNMENT);
        vbox.add(Box.createVerticalStrut(30));
        vbox.add(hbox);
        hbox.setAlignmentX(Component.CENTER_ALIGNMENT);
        vbox.add(Box.createVerticalStrut(20));

        vbox.add(Box.createVerticalGlue());

        add(vbox,BorderLayout.CENTER);

        //Action Listeners
        aceptar.addActionListener(e -> {
            try {
                admin.loginPlayer(inputNombre.getText(), new String(inputContrasena.getPassword())
                );
                MainMenu menu = new MainMenu(admin);
                inicial.dispose();
                dispose();
                menu.setVisible(true);
            } catch (IncorrectUsernameException | IncorrectPasswordException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelar.addActionListener(e -> {
           dispose();
        });
    }

}
