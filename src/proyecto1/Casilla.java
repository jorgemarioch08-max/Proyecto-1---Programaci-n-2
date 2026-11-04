package proyecto1;

public class Casilla {

    Pieza pieza;
    boolean prohibida;
    int fila;
    int columna;

    public Casilla(Pieza pieza, int fila, int columna) {
        this.pieza = null;
        this.fila = fila;
        this.columna = columna;
        this.prohibida = false;
    }

    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setProhibida(boolean prohibida) {
        this.prohibida = prohibida;
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
