package proyecto1;

import javax.swing.*;

public abstract class Bomba implements Pieza {

    private Bando bando;

    public Bomba(Bando bando) {
        this.bando = bando;
    }

    @Override
    public Bando getBando() {
        return bando;
    }

    @Override
    public abstract ImageIcon getImagen();

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