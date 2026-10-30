package proyecto1;

import Exceptions.InvalidPasswordException;
import Exceptions.InvalidUsernameException;

import javax.swing.*;

public class PlayerManager {

    Player[] players;
    public int playerLimit;


    public PlayerManager(int playerLimit) {
        this.playerLimit = playerLimit;
        this.players = new Player[playerLimit];
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
                players[i] = new Player(nombre.trim(), contra, 0, 0, 0, false);
                break;
            }
        }
    }

    public void deletePlayer() {
        System.out.println("Delete player");
    }

    public void findPlayer() {
        System.out.println("Find player");
    }

}
