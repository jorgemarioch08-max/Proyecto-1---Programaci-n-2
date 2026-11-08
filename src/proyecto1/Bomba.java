package proyecto1;

import enums.Bando;

import javax.swing.*;

public abstract class Bomba implements Pieza {

    private Bando bando;
    private boolean revelada;

    public Bomba(Bando bando) {
        this.bando = bando;
        this.revelada = false;
    }

    @Override
    public Bando getBando() {
        return bando;
    }

    @Override
    public abstract ImageIcon getImagen();

    //Estado
    @Override
    public void revelar() {
        revelada = true;
    }

    @Override
    public void ocultar() {
        revelada = false;
    }

    @Override
    public boolean estaRevelada() {
        return revelada;
    }

}