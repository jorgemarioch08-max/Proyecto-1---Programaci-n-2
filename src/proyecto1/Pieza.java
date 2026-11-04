package proyecto1;

import javax.swing.*;

public interface Pieza {

    public Bando getBando();

    public ImageIcon getImagen();

    public void revelar();

    public void ocultar();

    public boolean estaRevelada();

}
