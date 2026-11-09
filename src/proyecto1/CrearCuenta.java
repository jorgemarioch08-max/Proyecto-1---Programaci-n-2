package proyecto1;

import Exceptions.InvalidPasswordException;

import javax.swing.*;
import java.awt.*;
import Exceptions.*;

public class CrearCuenta extends JDialog {

    //GUI
    JLabel titulo1 = new JLabel("Crear Cuenta");
    JLabel titulo2 = new JLabel("Para poder jugar es necesario crear una cuenta.");
    JLabel titulo3 = new JLabel("Nombre de usuario:");
    JLabel titulo4 = new JLabel("Contraseña:");

    ImageIcon icono = new ImageIcon("src/Imagenes/perfil.png");

    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel hbox = new JPanel();

    JTextField user = new JTextField();
    JPasswordField pass = new JPasswordField();

    JButton aceptar = new JButton("Aceptar");
    JButton cancelar = new JButton("Cancelar");

    JOptionPane error = new JOptionPane("Error");

    //Admin
    public PlayerManager admin;

    public CrearCuenta(PlayerManager admin) {
        this.admin=admin;

        //GUI
        setTitle("Crear Cuenta");
        setSize(500,800);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout(10,10));
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModal(true);

        titulo1.setFont(new Font("Arial", Font.BOLD, 18));
        titulo1.setForeground(Color.white);
        titulo1.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo2.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo2.setForeground(Color.white);
        titulo3.setForeground(Color.white);
        titulo4.setForeground(Color.white);

        Image img = icono.getImage();
        Image imgsc = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        icono = new ImageIcon(imgsc);
        titulo1.setIcon(icono);
        titulo1.setHorizontalTextPosition(JLabel.CENTER);
        titulo1.setVerticalTextPosition(JLabel.TOP);
        titulo1.setIconTextGap(20);

        titulo2.setFont(new Font("Arial", Font.PLAIN, 14));

        user.setPreferredSize(new Dimension(300,25));
        user.setMaximumSize(new Dimension(300,25));
        user.setAlignmentX(Component.LEFT_ALIGNMENT);
        pass.setPreferredSize(new Dimension(300,25));
        pass.setMaximumSize(new Dimension(300,25));
        pass.setAlignmentX(Component.LEFT_ALIGNMENT);

        aceptar.setFont(new Font("Arial", Font.PLAIN, 16));
        aceptar.setBackground(Color.decode("#cfe2f3"));
        aceptar.setPreferredSize(new Dimension(140,25));
        aceptar.setMaximumSize(new Dimension(140, 25));

        cancelar.setFont(new Font("Arial", Font.PLAIN, 16));
        cancelar.setBackground(Color.decode("#cfe2f3"));
        cancelar.setPreferredSize(new Dimension(140,25));
        cancelar.setMaximumSize(new Dimension(140, 25));

        panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
        panel2.setMaximumSize(new Dimension(300,150));
        panel2.setPreferredSize(new Dimension(300,150));
        panel2.setBackground(Color.decode("#333333"));

        panel2.add(Box.createVerticalGlue());

        panel2.add(titulo3);
        titulo3.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel2.add(Box.createVerticalStrut(5));
        panel2.add(user);
        panel2.add(Box.createVerticalStrut(5));
        panel2.add(titulo4);
        titulo4.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel2.add(Box.createVerticalStrut(5));
        panel2.add(pass);

        panel2.add(Box.createVerticalGlue());

        hbox.setLayout(new BoxLayout(hbox,BoxLayout.X_AXIS));
        hbox.setPreferredSize(new Dimension(500,75));
        hbox.setMaximumSize(new Dimension(500,75));
        hbox.setBackground(Color.decode("#333333"));

        hbox.add(Box.createHorizontalGlue());

        hbox.add(aceptar);
        hbox.add(Box.createHorizontalStrut(10));
        hbox.add(cancelar);

        hbox.add(Box.createHorizontalGlue());

        panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
        panel1.setMaximumSize(new Dimension(500,500));
        panel1.setBackground(Color.decode("#333333"));

        panel1.add(Box.createVerticalGlue());

        panel1.add(titulo1);
        panel1.add(Box.createVerticalStrut(20));
        panel1.add(titulo2);
        panel1.add(Box.createVerticalStrut(20));
        panel1.add(panel2);
        panel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel1.add(Box.createVerticalStrut(20));
        panel1.add(hbox);
        aceptar.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel1.add(Box.createVerticalGlue());

        add(panel1,BorderLayout.CENTER);

        //Botones
        aceptar.addActionListener(e -> {
            try {
                admin.createPlayer(user.getText(), new String(pass.getPassword()));
                dispose();
            } catch (InvalidUsernameException | DuplicatedUserException | InvalidPasswordException | PlayerLimitException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelar.addActionListener(e -> {
            dispose();
        });

    }
}
