package Cashiers;

import Accounting.Accounting;

import java.util.ArrayList;
public class Cashier extends Accounting {
    private ArrayList<Integer> productsIds = new ArrayList<>();
    private ArrayList<Double> amountProducts = new ArrayList<>();
    private final String nameClient;
    private final int ciClient;
    public double totalSellCashier = 0;

    public Cashier(String name_client, int ci_client){
        this.nameClient = name_client;
        this.ciClient = ci_client;
    }

    public double get_total(){
        return this.totalSellCashier;
    }

    public void set_total(double total){
        this.totalSellCashier = total;
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
        System.out.println("dAsdasd");
        return this.productsIds.get(product_id) * this.amountProducts.get(product_id);
    }

    public void addProduct(int product_id){
        this.productsIds.add(product_id);
    }
}
