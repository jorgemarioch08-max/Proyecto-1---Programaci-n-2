package proyecto1;

public class PlayerManager {

    Player[] players;
    public int playerLimit;
    boolean login;

    public PlayerManager(Player[] players, int playerLimit, boolean login) {
        this.playerLimit = playerLimit=10;
        this.players = new Player[playerLimit];
        this.login = false;
    }

    public void create() {
        System.out.println("Create player");
    }

    public void delete() {
        System.out.println("Delete player");
    }

    public void find() {
        System.out.println("Find player");
    }

}
