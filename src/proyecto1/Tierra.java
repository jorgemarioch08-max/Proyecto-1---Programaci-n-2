package proyecto1;

import enums.Bando;

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
        if (bando == Bando.HEROES) {
            return new ImageIcon("src/Imagenes/heroes/la_tierra_hero.png");
        }
        return new ImageIcon("src/Imagenes/villanos/la_tierra_villain.png");
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