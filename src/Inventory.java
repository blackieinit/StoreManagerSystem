import java.util.ArrayList;

public class Inventory {
    public ArrayList<String> inventory = new ArrayList<>();
    public ArrayList<Double> prices = new ArrayList<>();

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
            System.out.println(e.getMessage());
        }
    }

    public StringBuilder getProducts(){
        try {
            StringBuilder list_inventory = new StringBuilder();
            int current_index_price = 0;

            for (String s : this.inventory) {
                list_inventory.append(current_index_price + 1).append(") ").append(s).append(" ").append(this.prices.get(current_index_price).toString()).append("$").append("\n");
                current_index_price++;
            }

            return list_inventory;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String deleteProduct(int id_product){
        try {
            id_product = id_product - 1;
            String product_to_delete = this.inventory.get(id_product);
            this.inventory.remove(id_product);
            this.prices.remove(id_product);
            return product_to_delete;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
