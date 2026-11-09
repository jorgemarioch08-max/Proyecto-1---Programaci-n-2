package proyecto1;

public class Main {

    public static void main(String[] args) {
        PlayerManager admin = new PlayerManager(50);

        MenuInicial menuInicial = new MenuInicial(admin);
        menuInicial.setVisible(true);
    }

}
