import java.util.ArrayList;

public class Inventory {
    public ArrayList<String> inventory = new ArrayList<String>();
    public ArrayList<Double> prices = new ArrayList<Double>();

    public Inventory() {
        inventory.add("Coca-Cola 2ltrs");
        inventory.add("Harina Pan");
        inventory.add("Doritos 500gr");
        prices.add(1.3);
        prices.add(2.3);
        prices.add(1.4);
    }

    public void setProduct(String name, double price) {
        try {
            this.inventory.add(name);
            this.prices.add(price);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public ArrayList<String> getProducts(){
        try {
            return this.inventory;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }

    public ArrayList<Double> getPrices(){
        try {
            return this.prices;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }
}
