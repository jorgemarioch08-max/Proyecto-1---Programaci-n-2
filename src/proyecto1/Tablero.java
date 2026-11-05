package proyecto1;

public class Tablero {

    private Casilla[][] casillas;

    private int[] rangos = {10, 9, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 1};

    private String[] nombresHeroes = {"mr_fantastic", "captain_america", "professor_x", "nick_fury",
            "spider_man", "wolverine", "namor", "daredevil", "silver_surfer", "hulk", "iron_man",
            "thor", "human_torch", "cyclops", "invisible_woman", "ghost_rider", "punisher", "blade",
            "the_thing", "emma_frost", "she_hulk", "giant_man", "beast", "colossus", "gambit",
            "spider_girl", "iceman", "storm", "phoenix", "dr_strange", "elektra", "nightcrawler",
            "black_widow_hero"};

    private String[] nombresVillanos = {"dr_doom", "galactus", "kingpin", "magneto", "apocalypse",
            "green_goblin", "venom", "bullseye", "omega_red", "onslaught", "red_skull", "mystique",
            "mysterio", "dr_octopus", "deadpool", "abomination", "thanos", "black_cat", "sabretooth",
            "juggernaut", "rhino", "carnage", "mole_man", "lizard", "mr_sinister", "sentinel_1",
            "ultron", "sandman", "leader", "viper", "sentinel_2", "electro", "black_widow_villain"};

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

    public Pieza[] crearPiezas(Pieza[] piezas, Bando bando) {
        piezas = new Pieza[40];
        for (int i = 0; i < 40; i++) {
            if (i >= 0 && i < 33) {
                if (bando.equals(Bando.HEROES)) {
                    piezas[i] = new Heroe(nombresHeroes[i], rangos[i]);
                }
                else {
                    piezas[i] = new Villano(nombresVillanos[i], rangos[i]);
                }
            } else if (i >= 33 && i < 39) {
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

}
