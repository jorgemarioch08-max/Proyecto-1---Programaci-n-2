package Exceptions;

public class NoAccountLoggedException extends Exception {
    public NoAccountLoggedException(){
        super("No hay ninguna cuenta con una sesiòn iniciada.");
    }
}
