package proyecto1;

import javax.swing.*;

public class Ficha implements Pieza {

    private String nombre;
    private int rango;
    private Bando bando;
    private boolean revelada;

    public Ficha(String nombre, int rango, Bando bando, boolean revelada) {
        this.nombre = nombre;
        this.rango = rango;
        this.bando = bando;
        this.revelada = revelada;
    }

    public Ficha(String nombre, int rango, Bando bando) {
        this(nombre, rango, bando, false);
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public int getRango() {
        return rango;
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