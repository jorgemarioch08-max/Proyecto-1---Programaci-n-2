package Exceptions;

public class IncorrectUsernameException extends RuntimeException {
    public IncorrectUsernameException() {
        super("El usuario ingresado es incorrecto o no está registrado.");
    }
}
