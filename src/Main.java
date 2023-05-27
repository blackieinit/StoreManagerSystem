import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);
    private static final Inventory inventory = new Inventory();

    public static void main(String[] args) {
        try {
            showMainMenu();
        } catch (Exception e){
            System.out.println(e.getMessage());
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
            case 6:
                updateProduct();
        }
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
    public static void updateProduct(){
        System.out.println(inventory.getProducts());
        System.out.println("Selecciona el producto que deseas actualizar: ");
        int product_id = input.nextInt();
        StringBuilder product_to_update = inventory.getProduct(product_id);
        input.nextLine();
        System.out.println("Pulse 1 para actualizar nombre del producto, 2 para actualizar precio, 3 para actulizar ambos datos o 0 para cancelar.");
        int option_to_update = input.nextInt();
        input.nextLine();
        if (option_to_update == 0) return;
        String new_name_product = "";
        double new_price_product = 0;

        switch (option_to_update) {
            case 1 -> {
                System.out.println("Ingrese el nuevo nombre para el producto: ");
                new_name_product = input.nextLine();
            }
            case 2 -> {
                System.out.println("Ingrese el nuevo precio del producto: ");
                new_price_product = input.nextFloat();
            }
            case 3 -> {
                System.out.println("Ingrese el nuevo nombre para el producto: ");
                new_name_product = input.nextLine();
                System.out.println("Ingrese el nuevo precio del producto: ");
                new_price_product = input.nextFloat();
            }
        }

        StringBuilder product_updated = inventory.updateProduct(product_id, new_name_product, new_price_product);

        System.out.println("Producto: " + product_to_update + " Modificado a: " + product_updated);
        System.out.println("Pulse 1 para actualizar otro producto o 0 para volver al menú principal.");
        int option = input.nextInt();

        if (option == 1){
            updateProduct();
        } else {
            showMainMenu();
        }
    }
}