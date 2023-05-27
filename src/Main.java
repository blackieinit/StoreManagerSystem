import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);
    private static final Inventory inventory = new Inventory();

    public static void main(String[] args) {
        try {
            showMainMenu();
        } catch (Exception e){
            System.out.println(e.toString());
        }
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
        input.nextLine();

        switch (option_main_menu) {
            case 3:
                showInventory();
            case 4:
                addProduct();
            case 5:
                deleteProduct();
        }
        return;
    }

    private static void showInventory(){
        System.out.println(inventory.getProducts());
        System.out.println("Pulse 0 para volver al menú pricipal");
        input.nextInt();
        showMainMenu();
    }

    public static void addProduct() {
        System.out.println("Ingrese nombre del producto: ");
        String name_product = input.nextLine();
        System.out.println("Ingrese precio del producto: ");
        double price_product = input.nextDouble();
        inventory.setProduct( name_product, price_product );

        int option;
        System.out.println("Producto añadido correctamente. pulse 1 para añadir otro producto o 0 para volver al menu principal");
        option = input.nextInt();
        input.nextLine();

        if (option == 1) {
            addProduct();
        } else {
            showMainMenu();
        }
    }

    public static void deleteProduct() {
        System.out.println(inventory.getProducts());
        System.out.println("Selecciona el producto que deseas eliminar: ");
        int option = input.nextInt();
        String product_to_delete = inventory.deleteProduct(option);
        input.nextLine();
        System.out.println("Producto eliminado: " + product_to_delete);
        System.out.println("Pulse 1 para eliminar otro producto o 0 para volver al menú principal.");
        option = input.nextInt();

        if (option == 1){
            deleteProduct();
        } else {
            showMainMenu();
        }
    }
}