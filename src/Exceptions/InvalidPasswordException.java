package Exceptions;

public class InvalidPasswordException extends Exception {
    public InvalidPasswordException() {
        super("La contraseña debe tener exactamente 5 caracteres sin espacios.");
    }
}
