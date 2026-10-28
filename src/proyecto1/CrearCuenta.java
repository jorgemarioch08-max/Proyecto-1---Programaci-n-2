package proyecto1;

import javax.swing.*;
import java.awt.*;

public class CrearCuenta {

    JDialog crearCuenta = new JDialog();

    JLabel titulo1 = new JLabel("Crear Cuenta");
    JLabel titulo2 = new JLabel("Para poder jugar es necesario que cree una cuenta.");
    JLabel titulo3 = new JLabel("Nombre de usuario:");
    JLabel titulo4 = new JLabel("Contraseña:");

    ImageIcon icono = new ImageIcon("src/Imagenes/perfil.png");

    JPanel panel1 = new JPanel();

    JTextField user = new JTextField();
    JPasswordField pass = new JPasswordField();

    public CrearCuenta() {
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
        titulo3.setAlignmentX(Component.RIGHT_ALIGNMENT);
        titulo4.setAlignmentX(Component.RIGHT_ALIGNMENT);

        Image img = icono.getImage();
        Image imgsc = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        icono = new ImageIcon(imgsc);
        titulo1.setIcon(icono);
        titulo1.setHorizontalTextPosition(JLabel.CENTER);
        titulo1.setVerticalTextPosition(JLabel.TOP);
        titulo1.setIconTextGap(20);

        user.setPreferredSize(new Dimension(300,25));
        user.setMaximumSize(new Dimension(300,25));
        user.setAlignmentX(Component.CENTER_ALIGNMENT);
        pass.setPreferredSize(new Dimension(300,25));
        pass.setMaximumSize(new Dimension(300,25));
        pass.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
        panel1.setMaximumSize(new Dimension(500,500));

        panel1.add(Box.createVerticalGlue());

        panel1.add(titulo1);
        panel1.add(Box.createVerticalStrut(20));
        panel1.add(titulo2);
        panel1.add(Box.createVerticalStrut(10));
        panel1.add(titulo3);
        panel1.add(Box.createVerticalStrut(5));
        panel1.add(user);
        panel1.add(Box.createVerticalStrut(20));
        panel1.add(titulo4);
        panel1.add(Box.createVerticalStrut(5));
        panel1.add(pass);

        panel1.add(Box.createVerticalGlue());

        crearCuenta.add(panel1,BorderLayout.CENTER);
        crearCuenta.setVisible(true);
    }
}
