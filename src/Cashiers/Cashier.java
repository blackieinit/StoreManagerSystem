package Cashiers;

import Accounting.Accounting;
import Inventory.Inventory;

import java.util.ArrayList;
import java.util.Scanner;

public class Cashier {
    public ArrayList<Integer> product_ids = new ArrayList<>();
    public ArrayList<Double> amount_products = new ArrayList<>();
    private String name_client;
    private int ci_client;
    public double total_sell_cashier = 0;

    public Cashier(String name_client, int ci_client){
        this.name_client = name_client;
        this.ci_client = ci_client;
    }

    public double get_total(){
        return this.total_sell_cashier;
    }

    public double set_total(double total){
        return this.total_sell_cashier = total;
    }

    public String get_client_name(){
        return this.name_client;
    }

    public int get_client_ci(){
        return this.ci_client;
    }
}
