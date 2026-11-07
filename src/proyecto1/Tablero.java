package proyecto1;

import java.util.Random;

public class Tablero {

    private Casilla[][] casillas;
    private Random rd = new Random();
    private Bando turno;
    private Casilla seleccionada;

    private final int[] rangos = {10, 9, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 1};

    private final String[] nombresHeroes = {"mr_fantastic", "captain_america", "professor_x", "nick_fury",
            "spider_man", "wolverine", "namor", "daredevil", "silver_surfer", "hulk", "iron_man",
            "thor", "human_torch", "cyclops", "invisible_woman", "ghost_rider", "punisher", "blade",
            "the_thing", "emma_frost", "she_hulk", "giant_man", "beast", "colossus", "gambit",
            "spider_girl", "iceman", "storm", "phoenix", "dr_strange", "elektra", "nightcrawler",
            "black_widow_hero"};

    private final String[] nombresVillanos = {"dr_doom", "galactus", "kingpin", "magneto", "apocalypse",
            "green_goblin", "venom", "bullseye", "omega_red", "onslaught", "red_skull", "mystique",
            "mysterio", "dr_octopus", "deadpool", "abomination", "thanos", "black_cat", "sabretooth",
            "juggernaut", "rhino", "carnage", "mole_man", "lizard", "mr_sinister", "sentinel_1",
            "ultron", "sandman", "leader", "viper", "sentinel_2", "electro", "black_widow_villain"};

    //Constructor
    public Tablero() {
        casillas = new Casilla[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                boolean prohibida = (i == 4 || i == 5) && (j == 2 || j == 3 || j == 6 || j == 7);
                casillas[i][j] = new Casilla(i, j, prohibida);
            }
        }

        turno = Bando.HEROES;

        ordenarPiezas(Bando.HEROES);
        ordenarPiezas(Bando.VILLANOS);

    }

    public Casilla getCasilla(int fila, int columna) {
        return casillas[fila][columna];
    }

    public Casilla getCasilla() {
        return seleccionada;
    }

    public Bando getTurno() {
        return turno;
    }

    public void cambiarTurno() {
        if (turno == Bando.HEROES) {
            turno = Bando.VILLANOS;
        }
        else {
            turno = Bando.HEROES;
        }
    }

    public boolean esVisible(Pieza pieza) {
        if (pieza.getBando() == turno || pieza.estaRevelada()) {
            return true;
        }
        else  {
            return false;
        }
    }

    public boolean dentroDelTablero(int fila, int columna) {
        return fila >= 0 && fila < 10 && columna >= 0 && columna < 10;
    }

    public Pieza[] crearPiezas(Bando bando) {
        Pieza[] piezas = new Pieza[40];
        for (int i = 0; i < 40; i++) {
            if (i < 33) {
                if (bando.equals(Bando.HEROES)) {
                    piezas[i] = new Heroe(nombresHeroes[i], rangos[i]);
                }
                else {
                    piezas[i] = new Villano(nombresVillanos[i], rangos[i]);
                }
            } else if (i < 39) {
                if (bando.equals(Bando.HEROES)) {
                    piezas[i] = new NovaBlast(bando);
                }
                else {
                    piezas[i] = new PumpkinBomb(bando);
                }
            }
            else {
                piezas[i] = new Tierra(bando);
            }
        }

        return piezas;
    }

    private void colocarRdm (Pieza pieza, int filaMin, int filaMax) {
        int fila = filaMin + rd.nextInt(filaMax - filaMin + 1);
        int columna = rd.nextInt(10);

        if (casillas[fila][columna].isEmpty()) {
            casillas[fila][columna].setPieza(pieza);
        }
        else {
            colocarRdm(pieza, filaMin, filaMax);
        }

    }

    private void ordenarPiezas(Bando bando) {
        Pieza[] piezas = crearPiezas(bando);

        int filaTierra;
        int filaFrente;
        int fondoMin;
        int fondoMax;
        int medioMin;
        int medioMax;
        int filaMin;
        int filaMax;

        if (bando == Bando.VILLANOS) {
            filaTierra = 0;
            filaFrente = 1;
            fondoMin = 0;
            fondoMax = 1;
            medioMin = 2;
            medioMax = 3;
            filaMin = 0;
            filaMax = 3;
        }
        else {
            filaTierra = 9;
            filaFrente = 8;
            fondoMin = 8;
            fondoMax = 9;
            medioMin = 6;
            medioMax = 7;
            filaMin = 6;
            filaMax = 9;
        }

        int columna = rd.nextInt(8) + 1;
        casillas[filaTierra][columna].setPieza(piezas[39]);
        casillas[filaTierra][columna - 1].setPieza(piezas[33]);
        casillas[filaTierra][columna + 1].setPieza(piezas[34]);
        casillas[filaFrente][columna].setPieza(piezas[35]);

        for (int i = 36; i < 39; i++) {
            colocarRdm(piezas[i], fondoMin, fondoMax);
        }

        for (int i = 24; i < 32; i++) {
            colocarRdm(piezas[i], medioMin, medioMax);
        }

        for (int i = 0; i < 24; i++) {
            colocarRdm(piezas[i], filaMin, filaMax);
        }
        colocarRdm(piezas[32], filaMin, filaMax);
    }

    public void seleccionar(int fila, int columna) {
        Casilla casilla = casillas[fila][columna];
        Pieza pieza = casilla.getPieza();

        if (!casilla.isEmpty() && pieza.getBando() == turno && pieza instanceof Movible) {
            seleccionada = casilla;
        }
        else  {
            seleccionada = null;
        }
    }


}
