package proyecto1;

import javax.swing.*;

public class PumpkinBomb extends Bomba {

    public PumpkinBomb(Bando bando) {
        super(bando);
    }

    @Override
    public ImageIcon getImagen() {
        return new ImageIcon("src/Imagenes/villanos/pumpkin_bomb.png");
    }

}