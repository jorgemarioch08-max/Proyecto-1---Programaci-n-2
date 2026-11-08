package proyecto1;

import enums.Bando;

import javax.swing.*;

public class Heroe extends Ficha {

    public Heroe(String nombre, int rango) {
        super(nombre, rango, Bando.HEROES);
    }

    @Override
    public ImageIcon getImagen() {
        return new ImageIcon("src/Imagenes/heroes/"+getNombre()+".png");
    }

}