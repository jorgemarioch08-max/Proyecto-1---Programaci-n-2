package proyecto1;

import Exceptions.InvalidPasswordException;

import javax.swing.*;
import java.awt.*;
import Exceptions.*;

public class CrearCuenta {

    //GUI
    JDialog crearCuenta = new JDialog();
    JLabel titulo1 = new JLabel("Crear Cuenta");
    JLabel titulo2 = new JLabel("Para poder jugar es necesario crear una cuenta.");
    JLabel titulo3 = new JLabel("Nombre de usuario:");
    JLabel titulo4 = new JLabel("Contraseña:");
    ImageIcon icono = new ImageIcon("src/Imagenes/perfil.png");
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JTextField user = new JTextField();
    JPasswordField pass = new JPasswordField();
    JButton crearAcc = new JButton("Crear cuenta");
    JOptionPane error = new JOptionPane("Error");


    //Admin
    PlayerManager admin;

    public CrearCuenta(PlayerManager admin) {
        this.admin=admin;

        //GUI
        crearCuenta.setTitle("Crear Cuenta");
        crearCuenta.setSize(500,800);
        crearCuenta.setLocationRelativeTo(null);
        crearCuenta.setResizable(false);
        crearCuenta.setLayout(new BorderLayout(10,10));
        crearCuenta.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        crearCuenta.setModal(true);

        titulo1.setFont(new Font("Arial", Font.BOLD, 18));
        titulo1.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo2.setAlignmentX(Component.CENTER_ALIGNMENT);

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

        crearAcc.setFont(new Font("Arial", Font.PLAIN, 16));
        crearAcc.setBackground(Color.decode("#cfe2f3"));
        crearAcc.setPreferredSize(new Dimension(140,25));
        crearAcc.setMaximumSize(new Dimension(140, 50));

        panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
        panel2.setMaximumSize(new Dimension(300,100));
        panel2.setPreferredSize(new Dimension(300,100));

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

        panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
        panel1.setMaximumSize(new Dimension(500,500));

        panel1.add(Box.createVerticalGlue());

        panel1.add(titulo1);
        panel1.add(Box.createVerticalStrut(20));
        panel1.add(titulo2);
        panel1.add(Box.createVerticalStrut(30));
        panel1.add(panel2);
        panel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel1.add(Box.createVerticalStrut(20));
        panel1.add(crearAcc);
        crearAcc.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel1.add(Box.createVerticalGlue());

        crearCuenta.add(panel1,BorderLayout.CENTER);

        //Botones
        crearAcc.addActionListener(e -> {
            try {
                admin.createPlayer(user.getText(), new String(pass.getPassword()));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }

            this.crearCuenta.dispose();
        });


        crearCuenta.setVisible(true);
    }
}
