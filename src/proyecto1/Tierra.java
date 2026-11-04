package proyecto1;

import javax.swing.*;

public class Tierra implements Pieza {

    private Bando bando;

    public Tierra(Bando bando) {
        this.bando = bando;
    }

    @Override
    public Bando getBando() {
        return bando;
    }

    @Override
    public ImageIcon getImagen() {
        return null;
    }

    @Override
    public void revelar() {

    }

    @Override
    public void ocultar() {

    }

    @Override
    public boolean estaRevelada() {
        return true;
    }

}