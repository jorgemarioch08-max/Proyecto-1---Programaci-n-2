package proyecto1;

import javax.swing.*;

public class Ficha implements Pieza {

    private int rango;
    private Bando bando;
    private boolean revelada;

    public Ficha(int rango, Bando bando, boolean revelada) {
        this.rango = rango;
        this.bando = bando;
        this.revelada = revelada;
    }

    public Ficha(int rango, Bando bando) {
        this(rango, bando, false);
    }

    public int getRango() {
        return rango;
    }

    public Bando getBando() {
        return bando;
    }

    public ImageIcon getImagen() {
        return null;
    }

    public void revelar() {
        revelada = true;
    }

    public void ocultar() {
        revelada = false;
    }

    public boolean estaRevelada() {
        return revelada;
    }

}