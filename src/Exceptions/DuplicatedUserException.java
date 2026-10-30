package Exceptions;

public class DuplicatedUserException extends Exception {
    public DuplicatedUserException() {
        super("Nombre de usuario invalido: Este usuario ya està registrado.");
    }
}
