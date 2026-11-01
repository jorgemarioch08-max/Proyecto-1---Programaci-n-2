package Exceptions;

public class IncorrectPasswordException extends RuntimeException {
    public IncorrectPasswordException() {
        super("La contraseña ingresada es incorrecta.");
    }
}
