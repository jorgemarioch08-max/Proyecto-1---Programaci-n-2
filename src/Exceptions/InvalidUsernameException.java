package Exceptions;

public class InvalidUsernameException extends Exception {
    public InvalidUsernameException() {
        super("Nombre de usuario invalido: Este campo no puede estár vacío.");
    }
}
