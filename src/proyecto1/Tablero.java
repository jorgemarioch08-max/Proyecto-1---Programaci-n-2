package proyecto1;

public class Tablero {

    private Casilla[][] casillas;

    public Tablero() {
        casillas = new Casilla[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                boolean prohibida = (i == 4 || i == 5) && (j == 2 || j == 3 || j == 6 || j == 7);
                casillas[i][j] = new Casilla(i, j, prohibida);
            }
        }

    }

    public Casilla getCasilla(int fila, int columna) {
        return casillas[fila][columna];
    }

    public boolean dentroDelTablero(int fila, int columna) {
        return fila >= 0 && fila < 10 && columna >= 0 && columna < 10;
    }


}
