package proyecto1;

import javax.swing.*;

public class Villano extends Ficha {

    public Villano(String nombre, int rango) {
        super(nombre, rango, Bando.VILLANOS);
    }

    @Override
    public ImageIcon getImagen() {
        return new ImageIcon("src/Imagenes/villanos/"+getNombre()+".png");
    }

}