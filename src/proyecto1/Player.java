package proyecto1;

public class Player {

    public String username;
    private String password;
    public int points;
    public int partidasHeroes;
    public int partidasVillanos;

    public Player(String username, String password, int points, int partidasHeroes, int partidasVillanos){
        this.username = username;
        this.password = password;
        this.points = 0;
        this.partidasHeroes = 0;
        this.partidasVillanos = 0;
    }

}
