package Cashier;

import java.util.ArrayList;
import java.util.Scanner;

import Accounting.Accounting;
import Inventory.Inventory;

public class Cashier extends Inventory{
    public ArrayList<Integer> product_ids = new ArrayList<>();
    public ArrayList<Double> amount_products = new ArrayList<>();
    public String name_client = "";
    public int ci_client = 0;
    public double total_sell = 0;

    private final Inventory inventory;
    private final Accounting accounting;

    public Cashier(Inventory inventory, Accounting accounting){
        this.inventory = inventory;
        this.accounting = accounting;
    }

    private Scanner input = new Scanner(System.in);

    public void new_cashier(){

        System.out.println("##########################");
        System.out.println("#        NUEVA CAJA      #");
        System.out.println("##########################");
        System.out.println("Ingrese el nombre y apellido del cliente: ");
        this.name_client = input.nextLine();
        System.out.println("Ingrese la cédula de identidad del cliente: ");
        this.ci_client = input.nextInt();
        this.accounting.total_profit += 300;
        System.out.println(this.accounting.total_profit);
        this.get_cashier();
    }

    public void get_cashier(){
        double total_sell = 0;

        System.out.println("##########################");
        System.out.println("#          VENTA         #");
        System.out.println("##########################");
        System.out.println("Cliente: " + this.name_client);
        System.out.println("Cedula de identidad: " + this.ci_client);
        System.out.println("__________________________");
        System.out.println("  PRODUCTOS EN LA VENTA   ");
        System.out.println("__________________________");
        if (product_ids.size() > 0) {
            int index_product = 0;
            for(int product_id : product_ids){
                StringBuilder product = this.inventory.getProduct(product_id);
                double product_price = this.inventory.getPrice(product_id);
                double amount_product = this.amount_products.get(index_product);
                System.out.println(product
                        .append(" X ")
                        .append(amount_product)
                        .append(" Total: ")
                        .append(product_price * amount_product)
                );
                total_sell += product_price * amount_product;
                index_product++;
            }
        } else {
            System.out.println("No hay productos en la venta");
        }
        System.out.println("__________________________");
        System.out.println("Total productos: " + product_ids.size());
        System.out.println("Subtotal: " + total_sell * 0.16 + "$");
        System.out.println("Total: " + total_sell);
        System.out.println("__________________________");
        System.out.println("Ingrese 1 para añadir nuevo producto, 2 para finalizar venta, 0 para pausar la venta y volver a la selección de cajas.");
        int option = input.nextInt();
        input.nextLine();
        switch (option) {
            case 1 -> this.add_product_to_sell();
            case 2 -> this.get_cashier();
        }
    }

    private void add_product_to_sell(){
        System.out.println(this.inventory.getProducts());
        System.out.println("Selecciona un producto de la lista o pulsa s para volver al resumen de venta");
        int option = this.input.nextInt();
        input.nextLine();
        product_ids.add(option);
        System.out.println("Selecciona la cantidad a comprar:");
        double amount = this.input.nextDouble();
        input.nextLine();
        this.amount_products.add(amount);
        this.get_cashier();
    }

}
