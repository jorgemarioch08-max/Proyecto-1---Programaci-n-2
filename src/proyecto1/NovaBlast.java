package proyecto1;

import enums.Bando;

import javax.swing.*;

public class NovaBlast extends Bomba {

    public NovaBlast(Bando bando) {
        super(bando);
    }

    @Override
    public ImageIcon getImagen() {
        return new ImageIcon("src/Imagenes/heroes/novablast.png");
    }

}