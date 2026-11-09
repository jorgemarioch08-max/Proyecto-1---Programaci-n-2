package proyecto1;

import enums.Bando;
import enums.Resultado;

import java.util.Random;

public class Tablero {

    private Casilla[][] casillas;
    private Random rd = new Random();
    private Bando turno;
    private Casilla seleccionada;

    private Bando ganador;
    private Pieza[] heroesVencidos = new Pieza[40];
    private Pieza[] villanosVencidos  = new Pieza[40];
    private int contHeroesV = 0;
    private int contVillanosV = 0;

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

    //Getters
    public Casilla getCasilla(int fila, int columna) {
        return casillas[fila][columna];
    }

    public Casilla getSeleccionada() {
        return seleccionada;
    }

    public Bando getTurno() {
        return turno;
    }

    public Bando getGanador() {
        return ganador;
    }

    public Pieza[] getHeroesVencidos() {
        return heroesVencidos;
    }

    public Pieza[] getVillanosVencidos() {
        return villanosVencidos;
    }

    public int getContHeroesV() {
        return contHeroesV;
    }

    public int getContVillanosV() {
        return contVillanosV;
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

    public boolean esMovimientoValido(int fila, int columna) {
        if (seleccionada == null) {
            return false;
        }

        Casilla destino = casillas[fila][columna];

        if (destino.isProhibida()) {
            return false;
        }
        if (!destino.isEmpty() && destino.getPieza().getBando() == turno) {
            return false;
        }

        int distancia = Math.abs(fila - seleccionada.getFila()) +  Math.abs(columna - seleccionada.getColumna());

        if (((Movible) seleccionada.getPieza()).getRango() == 2) {
            boolean enLinea = (fila == seleccionada.getFila() || columna == seleccionada.getColumna());
            return enLinea && distancia >= 1 && freeWay(seleccionada.getFila(), seleccionada.getColumna(), fila, columna);
        }

        return distancia == 1;
    }

    public Resultado combate(Movible atacante, Pieza defensor) {
        if (defensor instanceof Tierra) {
            return Resultado.GANA;
        }
        if (defensor instanceof Bomba) {
            if (atacante.getRango() == 3) {
                return Resultado.GANA;
            }
            else  {
                return Resultado.PIERDE;
            }
        }

        int rangoAtacante = atacante.getRango();
        int rangoDefensor = ((Movible) defensor).getRango();

        if (rangoAtacante == 1 && rangoDefensor == 10) {
            return Resultado.GANA;
        }
        if (rangoAtacante > rangoDefensor) {
            return Resultado.GANA;
        } else if (rangoAtacante < rangoDefensor) {
            return Resultado.PIERDE;
        }
        else  {
            return Resultado.EMPATE;
        }

    }

    public void mover(int fila, int columna) {
        Casilla destino = casillas[fila][columna];
        Pieza atacante = seleccionada.getPieza();
        Pieza defensor = destino.getPieza();

        int distancia = Math.abs(fila - seleccionada.getFila()) + Math.abs(columna - seleccionada.getColumna());
        if (distancia > 1) {
            atacante.revelar();
        }

        if (defensor == null) {
            destino.setPieza(atacante);
            seleccionada.setPieza(null);
        }
        else {
            atacante.revelar();
            defensor.revelar();

            switch (combate((Movible) atacante, defensor)) {
                case GANA:
                    if (defensor instanceof Tierra) {
                        ganador = turno;
                    }
                    agregarVencido(defensor);
                    destino.setPieza(atacante);
                    seleccionada.setPieza(null);
                    break;
                case PIERDE:
                    agregarVencido(atacante);
                    seleccionada.setPieza(null);
                    break;
                case EMPATE:
                    agregarVencido(atacante);
                    agregarVencido(defensor);
                    destino.setPieza(null);
                    seleccionada.setPieza(null);
                    break;
            }
        }
        seleccionada = null;
        cambiarTurno();
    }

    private void agregarVencido(Pieza pieza) {
        if (pieza.getBando().equals(Bando.HEROES)) {
            heroesVencidos[contHeroesV] = pieza;
            contHeroesV++;
        }
        else {
            villanosVencidos[contVillanosV] = pieza;
            contVillanosV++;
        }
    }

    private boolean freeWay(int fila, int columna, int filaDestino, int columnaDestino) {
        if (fila < filaDestino) {
            fila++;
        }
        else if (fila > filaDestino) {
            fila--;
        }

        if (columna < columnaDestino) {
            columna++;
        }
        else if (columna > columnaDestino) {
            columna--;
        }

        if (fila == filaDestino && columna == columnaDestino) {
            return true;
        }
        if (!casillas[fila][columna].isEmpty() || casillas[fila][columna].isProhibida()) {
            return false;
        }
        return freeWay(fila, columna, filaDestino, columnaDestino);
    }

    public boolean tieneMovimientos(Bando bandom, int pos) {
        if (pos == 100) {
            return false;
        }

        int fila=pos/10;
        int columna=pos%10;
        Pieza pieza = casillas[fila][columna].getPieza();

        if (pieza != null && pieza.getBando() == bandom && pieza instanceof Movible && puedeMoverse(fila, columna)) {
            return true;
        }
        return false;
    }

    public boolean puedeMoverse(int fila, int columna) {
        Pieza pieza = casillas[fila][columna].getPieza();
        int[] df = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int f = fila - df[i];
            int c = columna - dc[i];

            if (dentroDelTablero(f, c)) {
                Casilla ady =  casillas[f][c];
                if (!ady.isProhibida() && (ady.isEmpty() || ady.getPieza().getBando() != pieza.getBando())) {
                    return true;
                }
            }
        }
        return false;
    }

}
