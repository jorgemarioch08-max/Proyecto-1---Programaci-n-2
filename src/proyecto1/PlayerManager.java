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

    public void createPlayer(String nombre, String contra) {
        //Verificar la contraseña
        try {
            if (contra.length() != 5 || contra.contains(" ")) {
                throw new InvalidPasswordException();
            }
        } catch (InvalidPasswordException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        //Verificar el username
        try {
            if (nombre.trim().isEmpty()) {
                throw new InvalidUsernameException();
            }
        } catch (InvalidUsernameException ex)  {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }

        for (int i=0; i<this.players.length || this.players[i] != null; i++) {
            players[i] = new Player(nombre, contra, 0, 0, 0, false);
        }
    }

    public void deletePlayer() {
        System.out.println("Delete player");
    }

    public void findPlayer() {
        System.out.println("Find player");
    }

}
