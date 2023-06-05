package Inventory;

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

    public StringBuilder getProduct(int product_id){
        System.out.println("Get product");
        StringBuilder product = new StringBuilder();
        return product
                .append(this.inventory.get(product_id))
                .append(" Precio: ")
                .append(this.prices.get(product_id))
                .append("$");
    }

    public double getPrice(int product_id){
        return this.prices.get(product_id);
    }

    public StringBuilder getProducts(){
        try {
            StringBuilder list_inventory = new StringBuilder();
            int current_index_price = 0;

            for (String item : this.inventory) {
                list_inventory
                        .append(current_index_price + 1)
                        .append(") ")
                        .append(item)
                        .append(" ")
                        .append(this.prices.get(current_index_price).toString())
                        .append("$")
                        .append("\n");
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

    public StringBuilder updateProduct(int id_product, String new_name, double new_price){
        try{
            id_product = id_product - 1;
            if (!new_name.isBlank()) this.inventory.set(id_product, new_name);
            if (new_price > 0) this.prices.set(id_product, new_price);
            StringBuilder product_updated = new StringBuilder();

            return product_updated
                    .append(this.inventory.get(id_product))
                    .append(" Precio: ")
                    .append(this.prices.get(id_product));

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
