package Cashiers;

import Accounting.Accounting;
import Inventory.Inventory;

import java.util.ArrayList;
import java.util.Scanner;

public class CashierManager extends Inventory{
    private final Scanner input = new Scanner(System.in);
    public final ArrayList<Cashier> cashiers = new ArrayList<>();
    private Accounting accounting;
    private final Inventory inventory;
    private Cashier currentCashier = null;

    public CashierManager(Accounting accounting, Inventory inventory){
        this.accounting = accounting;
        this.inventory = inventory;
    }

    public void create_cashier(){
        System.out.println("##########################");
        System.out.println("#        NUEVA CAJA      #");
        System.out.println("##########################");
        System.out.println("Ingrese el nombre y apellido del cliente: ");
        String name_client = input.nextLine();
        System.out.println("Ingrese la cédula de identidad del cliente: ");
        int ci_client = input.nextInt();
        cashiers.add(new Cashier(name_client, ci_client, inventory, accounting));
        this.get_cashier(this.cashiers.size() - 1);
    }

    public void get_cashier(int cashier_id){
        this.currentCashier = cashiers.get(cashier_id);
        double total = 0;
        System.out.println("##########################");
        System.out.println("#          VENTA         #");
        System.out.println("##########################");
        System.out.println("Cliente: " + this.currentCashier.get_client_name());
        System.out.println("Cedula de identidad: " + this.currentCashier.get_client_ci());
        System.out.println("__________________________");
        System.out.println("  PRODUCTOS EN LA VENTA   ");
        System.out.println("__________________________");
        if (this.currentCashier.getProductsIds().size() > 0) {
            int index_product = 0;
            for(int product_id : this.currentCashier.getProductsIds()){
                StringBuilder product = getProduct(product_id);
                double product_price = getPrice(product_id);
                double amount_product = this.currentCashier.getAmountProduct(index_product);
                System.out.println(product
                        .append(" X ")
                        .append(amount_product)
                        .append(" Total: ")
                        .append(product_price * amount_product)
                );
                total += product_price * amount_product;
                index_product++;
            }
        } else {
            System.out.println("No hay productos en la venta");
        }
        this.currentCashier.set_total(total);
        System.out.println("__________________________");
        System.out.println("Total productos: " + this.currentCashier.getProductsIds().size());
        System.out.println("Subtotal: " + total* 0.16 + "$");
        System.out.println("Total: " + total + "$");
        System.out.println("__________________________");
        System.out.println("Ingrese 1 para añadir nuevo producto, 2 para finalizar venta, 0 para pausar la venta y volver a la selección de cajas.");
        int option = input.nextInt();
        input.nextLine();
        switch (option) {
            case 1 -> this.add_product_to_sell(cashier_id);
            case 2 -> this.charge_customer(cashier_id);
        }
    }

    private void add_product_to_sell(int cashier_id){
        System.out.println(getProducts());
        System.out.println("Selecciona un producto de la lista o pulsa s para volver al resumen de venta");
        int option = this.input.nextInt();
        input.nextLine();
        currentCashier.getProductsIds().add(option - 1);
        System.out.println("Selecciona la cantidad a comprar:");
        double amount = this.input.nextDouble();
        input.nextLine();
        currentCashier.setAmountProduct(amount);
        get_cashier(cashier_id);
    }

    private void charge_customer(int cashier_id){
        System.out.println("Total: " + currentCashier.get_total() + "$");
        System.out.println("Ingrese la cantidad de dinero del cliente: ");
        double amountMoney = input.nextDouble();
        this.currentCashier.setAmountMoneyClient(amountMoney);
        input.nextLine();
        if (amountMoney >= currentCashier.get_total()){
            this.currentCashier.payCashier();
            this.currentCashier.printInvoice();
            this.cashiers.remove(cashier_id);
        } else {
            System.out.println("Dinero ingresado no es suficiente, pulse 1 para modificar la cantidad de dinero o 0 para cancelar la venta");
            int option = input.nextInt();
            switch (option){
                case 1 -> this.charge_customer(cashier_id);
                case 2 -> this.cancel_sell();
            }
        }
    }


    private void cancel_sell(){
        System.out.println("Venta cancelada");
    }

    public ArrayList<Cashier> get_cashiers(){
        return cashiers;
    }
}
