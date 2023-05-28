package Cashiers;

import Accounting.Accounting;
import Inventory.Inventory;

import java.util.ArrayList;

public class CashierManager {
    public final ArrayList<Cashier> cashiers = new ArrayList<>();
    private final Inventory inventory;
    private final Accounting accounting;

    public CashierManager(Inventory inventory, Accounting accounting){
        this.inventory = inventory;
        this.accounting = accounting;
    }

    public void create_cashier(){
        cashiers.add(new Cashier(this.inventory, this.accounting));
        cashiers.get(cashiers.size() - 1).new_cashier();
    }

    public void get_cashier(int cashier_id){
        Cashier cashier = this.cashiers.get(cashier_id);
    }

    public ArrayList<Cashier> get_cashiers(){
        return cashiers;
    }
}
