import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);
    private static final Inventory inventory = new Inventory();

    public static void main(String[] args) {
        while(true) {
            try {
                showMainMenu();
            } catch (Exception e){
                System.out.println(e.toString());
            }
        }
    }

    public static void addProduct() {
        System.out.println("Ingrese nombre del producto: ");
        String name_product = input.next();
        System.out.println("Ingrese precio del producto: ");
        double price_product = input.nextDouble();
        inventory.setProduct( name_product, price_product );
    }

    public static void showMainMenu() {
        int option_main_menu;

        System.out.println(
        """
        ##############################
        # Bienvenido a SMS V1.0-BETA #
        ##############################
        Menu Principal:
        //Ventas
        1) Realizar venta.
        2) Estado actual de ventas y ganancias.
        //Inventario
        3) Ver inventario.
        4) Ingresar nuevo producto.
        5) Eliminar producto.
        6) Modificar producto.
        //Acciones
        0) Cierre de caja.
        """);
        System.out.println("Seleccione una opción: ");
        option_main_menu = input.nextInt();

        switch (option_main_menu) {
            case 3:
                showInventory();
        }
    }

    private static void showInventory(){
        ArrayList<String> current_inventory = inventory.getProducts();
        ArrayList<Double> current_prices = inventory.getPrices();
        StringBuilder list_inventory = new StringBuilder();
        int current_index_price = 0;

        for (String s : current_inventory) {
            list_inventory.append(s).append(" ").append(current_prices.get(current_index_price).toString()).append("$").append("\n");
            current_index_price++;
        }
        System.out.println(list_inventory);
        System.out.println("Pulse cualquier tecla para volver al menú pricipal");
        input.nextInt();
        return;
    }

}