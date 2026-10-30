package proyecto1;

public class Main {

    public static void main(String[] args) {
        PlayerManager admin = new PlayerManager(10);

        MainMenu menu = new MainMenu();
        CrearCuenta crearCuenta = new CrearCuenta(admin);

    }

}
