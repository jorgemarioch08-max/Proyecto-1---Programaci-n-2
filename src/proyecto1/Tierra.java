package proyecto1;

import javax.swing.*;

public class Tierra implements Pieza {

    private Bando bando;
    private boolean revelada;

    public Tierra(Bando bando) {
        this.bando = bando;
        this.revelada = false;
    }

    @Override
    public Bando getBando() {
        return bando;
    }

    @Override
    public ImageIcon getImagen() {
        return null;
    }

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