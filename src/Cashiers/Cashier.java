package Cashiers;

import Accounting.Accounting;
import Inventory.Inventory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Cashier {
    private ArrayList<Integer> productsIds = new ArrayList<>();
    private ArrayList<Double> amountProducts = new ArrayList<>();
    private final String nameClient;
    private final int ciClient;
    private double totalSellCashier = 0;
    private double amountMoneyClient = 0;
    private Inventory inventory;
    private Accounting accounting;


    public Cashier(String name_client, int ci_client, Inventory inventory, Accounting accounting){
        this.nameClient = name_client;
        this.ciClient = ci_client;
        this.inventory = inventory;
        this.accounting = accounting;
    }

    public double get_total(){
        return this.totalSellCashier;
    }

    public void set_total(double total){
        this.totalSellCashier = total;
    }

    public double getTotalSellCashier() {
        return totalSellCashier;
    }

    public double getIva(){
        return totalSellCashier * 0.16;
    }

    public double getSubtotal(){
        return totalSellCashier - (totalSellCashier * 0.16);
    }

    public String get_client_name(){
        return this.nameClient;
    }

    public int get_client_ci(){
        return this.ciClient;
    }

    public Double getAmountProduct(int product_id){
        return this.amountProducts.get(product_id);
    }

    public void setAmountProduct(double amount) {
        this.amountProducts.add(amount);
    }

    public ArrayList<Integer> getProductsIds(){
        return this.productsIds;
    }

    public double getTotalAmountProduct(int product_id){
        return this.productsIds.get(product_id) * this.amountProducts.get(product_id);
    }

    public void addProduct(int product_id){
        this.productsIds.add(product_id);
    }

    public void setAmountMoneyClient(double amountMoneyClient) {
        this.amountMoneyClient = amountMoneyClient;
    }

    public double getAmountMoneyClient() {
        return amountMoneyClient;
    }

    public void payCashier(){
        accounting.setTotalProfit(this.get_total() * 0.30);
        accounting.setAmountSales();
        accounting.setTotalSales(this.get_total());
    }

    public void printInvoice(){
        StringBuilder invoice = new StringBuilder();

        invoice.append("     BODEGON EL KIRITO PARRA C.A     \n")
                .append("Av 2 antigua calle comercio edif LE\n")
                .append("Piso 1 Oficina 2 - Higuerote Miranda\n")
                .append("_____________________________________\n")
                .append("Información del cliente\n")
                .append("Nombre ")
                .append(this.get_client_name())
                .append("\nRIF/CI:")
                .append(this.get_client_ci())
                .append("\n              FACTURA                \n")
                .append("_____________________________________\n");
        for (int product_id : this.getProductsIds()){
            invoice.append(inventory.getProduct(product_id))
                    .append(" X ")
                    .append(this.getAmountProduct(product_id))
                    .append(" = ")
                    .append(this.inventory.prices.get(product_id) * this.getAmountProduct(product_id))
                    .append("$\n");
        }

        invoice.append("____________________________________\n");
        invoice.append("Subtotal: ").append(String.format("%.2f", this.getSubtotal())).append("$");
        invoice.append("\nIVA: ").append(String.format("%.2f", this.getIva())).append("$");
        invoice.append("\nTotal: ").append(String.format("%.2f", this.getTotalSellCashier())).append("$");
        invoice.append("\nPago: ").append(String.format("%.2f", this.amountMoneyClient)).append("$");
        invoice.append("\nVuelto: ").append(String.format("%.2f", this.amountMoneyClient - this.totalSellCashier)).append("$");
        invoice.append("\n____________________________________\n");
        invoice.append("\nGRACIAS POR SU COMPRA");
        invoice.append("\nFecha: ").append(this.getDate());
        invoice.append("\n____________________________________\n");


        System.out.println(invoice);

    }


    private String getDate(){
        DateFormat dateFormat = new SimpleDateFormat("d/MM/yyyy - HH:mm:ss");
        return dateFormat.format(new Date());
    }
}
