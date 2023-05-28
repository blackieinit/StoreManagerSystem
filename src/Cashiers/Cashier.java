package Cashiers;

import Accounting.Accounting;
import Inventory.Inventory;

import java.util.ArrayList;
import java.util.Scanner;

public class Cashier {
    public ArrayList<Integer> productsIds = new ArrayList<>();
    public ArrayList<Double> amountProducts = new ArrayList<>();
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
}
