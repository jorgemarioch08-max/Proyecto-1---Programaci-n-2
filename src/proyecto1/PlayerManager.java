package proyecto1;

import Exceptions.*;

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

    public void createPlayer(String nombre, String contra) throws InvalidPasswordException, InvalidUsernameException, DuplicatedUserException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new InvalidUsernameException();
        }
        if (findPlayer(nombre) != null) {
            throw new DuplicatedUserException();
        }
        if (contra == null || contra.length() != 5 || contra.contains(" ")) {
            throw new InvalidPasswordException();
        }
        for (int i = 0; i < players.length; i++) {
            if (players[i] == null) {
                players[i] = new Player(nombre.trim(), contra, 0, 0, 0, false
                );
                break;
            }
        }
    }

    public void loginPlayer(String findUser, String password) throws IncorrectUsernameException, IncorrectPasswordException {
        Player foundPlayer = findPlayer(findUser);

        if (foundPlayer == null) {
            throw new IncorrectUsernameException();
        }
        if (!foundPlayer.checkPassword(password)) {
            throw new IncorrectPasswordException();
        }

        activePlayer = foundPlayer;
        activePlayer.login = true;
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

    public boolean deletePlayer(String password) throws NoAccountLoggedException {
        checkActivePlayer();
        if (!activePlayer.checkPassword(password)) {
            return false;
        }

        Player eliminado = activePlayer;

        for (int i = 0; i < players.length; i++) {
            if (players[i] == eliminado) {
                players[i] = null;
                break;
            }
        }

        eliminado.login = false;
        activePlayer = null;
        return true;
    }

    public Player findPlayer(String findUser) {
        if (findUser == null) {
            return null;
        }
        Player foundPlayer = null;

        for (int i = 0; i < players.length; i++) {
            if (players[i] != null && players[i].username.equalsIgnoreCase(findUser.trim())) {
                foundPlayer = players[i];
                break;
            }
        }
        return foundPlayer;
    }

    public boolean changePassword(String currentPassword, String newPassword) throws NoAccountLoggedException, InvalidPasswordException {
        checkActivePlayer();
        if (!activePlayer.checkPassword(currentPassword)) {
            return false;
        }
        if (newPassword == null || newPassword.length() != 5 || newPassword.contains(" ")) {
            throw new InvalidPasswordException();
        }

        activePlayer.changePassword(newPassword);
        return true;
    }

    //Getters
    public Player[] getPlayers() {
        return players;
    }
    public int getPlayerLimit() {
        return playerLimit;
    }
    public Player getActivePlayer() {
        return activePlayer;
    }

    //Setters
    public void setPlayers(Player[] players) {
        this.players = players;
    }
    public void setPlayerLimit(int playerLimit) {
        this.playerLimit = playerLimit;
    }
    public void setActivePlayer(Player activePlayer) {
        this.activePlayer = activePlayer;
    }
}
