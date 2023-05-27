package Cashier;

import java.util.Scanner;

public class Cashier {
    public int[] product_ids = {};
    public float[] amount_products = {};
    public String name_client = "";
    public int ci_client = 0;
    public double total_sell = 0;

    private Scanner input = new Scanner(System.in);

    public void new_cashier(){
        System.out.println("##########################");
        System.out.println("#        NUEVA CAJA      #");
        System.out.println("##########################");
        System.out.println("Ingrese el nombre y apellido del cliente: ");
        this.name_client = input.nextLine();
        System.out.println("Ingrese la cédula de identidad del cliente: ");
        this.ci_client = input.nextInt();
        this.get_cashier();
    }

    public void get_cashier(){
        System.out.println("##########################");
        System.out.println("#          VENTA         #");
        System.out.println("##########################");
        System.out.println("Cliente: " + this.name_client);
        System.out.println("Cedula de identidad: " + this.ci_client);
        System.out.println("Ingrese 1 para añadir nuevo producto, 2 para finalizar venta, 0 para pausar la venta y volver a la selección de cajas.");
        int option = input.nextInt();

        switch (option) {
            case 1 -> this.get_cashier();
            case 2 -> this.get_cashier();
        }

    }

}
