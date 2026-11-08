package proyecto1;

public class Player {

    public String username;
    private String password;
    public int puntos;
    public int partidasHeroes;
    public int partidasVillanos;
    public int partidasTotales;
    public boolean login;

    public Player(String username, String password, int puntos, int partidasHeroes, int partidasVillanos, boolean login) {
        this.username = username;
        this.password = password;
        this.puntos = 0;
        this.partidasHeroes = 0;
        this.partidasVillanos = 0;
        this.partidasTotales = partidasHeroes + partidasVillanos;
        this.login = false;
    }

    public boolean checkPassword(String contra) {
        return password.equals(contra);
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }
}
