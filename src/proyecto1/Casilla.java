package proyecto1;

public class Casilla {

    private Pieza pieza;
    private boolean prohibida;
    private int fila;
    private int columna;

    public Casilla(int fila, int columna, boolean prohibida) {
        this.fila = fila;
        this.columna = columna;
        this.prohibida = prohibida;
    }

    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }

    public boolean isEmpty() {
        if (pieza == null) {
            return true;
        }
        else  {
            return false;
        }
    }

    public Pieza getPieza() {
        return pieza;
    }

    public boolean isProhibida() {
        return prohibida;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }



}
