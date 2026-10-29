package com.pluralsight;

import java.util.ArrayList;

public class StoreApp {
    public static void main(String[] args) {

        ArrayList<Product> products = getInventory();


        System.out.println("Products in inventory:");

        for (Product product : products) {
            System.out.printf("#%d %s - $%.2f%n", product.getId(), product.getName(), product.getPrice());
        }

    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product(1001, "Glow-in-the-Dark Socks", 8.99));
        products.add(new Product(1002, "Mini Desk Cactus", 12.50));
        products.add(new Product(1003, "Bubble Tea Plushie", 15.99));
        products.add(new Product(1004, "Rubber Duck Debugger", 4.99));
        products.add(new Product(1005, "Galaxy Night Light", 24.95));
        products.add(new Product(1006, "Chai Lover's Mug", 11.25));
        products.add(new Product(1007, "Fidget Cube", 6.75));
        products.add(new Product(1008, "LED Mechanical Keyboard", 59.99));

        return products;
    }
}
