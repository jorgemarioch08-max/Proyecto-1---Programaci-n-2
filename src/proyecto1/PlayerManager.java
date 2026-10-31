package proyecto1;

import Exceptions.InvalidPasswordException;
import Exceptions.InvalidUsernameException;
import Exceptions.NoAccountLoggedException;

import javax.swing.*;

public class PlayerManager {

    Player[] players;
    public int playerLimit;
    private Player activePlayer;


    public PlayerManager(int playerLimit) {
        this.playerLimit = playerLimit;
        this.players = new Player[playerLimit];
        this.activePlayer = null;
    }

    public void createPlayer(String nombre, String contra) throws InvalidPasswordException, InvalidUsernameException {
        //Verificar la contraseña
        if (contra.length() != 5 || contra.contains(" ")) {
            throw new InvalidPasswordException();
        }
        //Verificar el username
        if (nombre.trim().isEmpty()) {
            throw new InvalidUsernameException();
        }

        for (int i=0; i<this.players.length; i++) {
            if (this.players[i] == null) {
                players[i] = new Player(nombre.trim(), contra, 0, 0, 0, true);
                activePlayer = players[i];
                break;
            }
        }
    }

    public void loginPlayer() {
        System.out.println("Log in Player");
    }

    public void logoutPlayer() throws NoAccountLoggedException {
        checkActivePlayer();
        activePlayer.login=false;
        activePlayer = null;
    }

    public void checkActivePlayer() throws NoAccountLoggedException {
        if (activePlayer == null) {
            throw new NoAccountLoggedException();
        }
    }

    public void deletePlayer() {
        System.out.println("Delete player");
    }

    public void findPlayer() {
        System.out.println("Find player");
    }

}
