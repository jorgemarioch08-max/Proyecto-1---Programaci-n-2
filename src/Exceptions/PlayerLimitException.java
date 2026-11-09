package Exceptions;

public class PlayerLimitException extends RuntimeException {
    public PlayerLimitException() {
        super("No hay espacio para más jugadores." +
                "\nElimine una cuenta para liberar espacio.");
    }
}
