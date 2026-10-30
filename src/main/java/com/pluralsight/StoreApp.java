package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Search Inventory
 * Loads the store's products from inventory.csv into an ArrayList
 * and displays each product's ID, name and price.
 */
public class StoreApp {
    public static void main(String[] args) {

        // Get the full product list from getInventory()
        ArrayList<Product> products = getInventory();

        // Sort the products A to Z by name.
        Collections.sort(products, Comparator.comparing(Product::getName));

        System.out.println("Products in inventory:");

        // Print every product in the list
        for (Product product : products) {
            System.out.printf("#%d %s - $%.2f%n", product.getId(), product.getName(), product.getPrice());
        }
    }

    /**
     * Reads inventory.csv and returns a list of Product objects.
     * Each line in the file looks like: id|name|price
     */
    public static ArrayList<Product> getInventory() {
        // Empty list that will hold the products from the file
        ArrayList<Product> products = new ArrayList<>();

        // Try: reading a file can fail (e.g. file not found)
        try {
            // Open inventory.csv for reading
            BufferedReader prodReader = new BufferedReader(new FileReader("inventory.csv"));
            String prodLine;

            // Read one line at a time until readLine() returns null (end of file)
            while ((prodLine = prodReader.readLine()) != null) {

                // Split the line on | into id, name and price
                String[] prodArr = prodLine.split("\\|");

                // Convert each part from text into the right data type
                int id = Integer.parseInt(prodArr[0]);
                String name = prodArr[1];
                double price = Double.parseDouble(prodArr[2]);

                // Create a Product and add it to the list
                products.add(new Product(id, name, price));
            }

            // Show how many products were loaded
            System.out.println("The inventory had " + products.size() + " products.");

            // Close the file
            prodReader.close();

        } catch (IOException e) {
            // Runs if the file can not be found or read
            System.out.println("Sorry, unable to find the file inventory.csv");
        }

        // Send the list back to main (empty if the file couldn't be read)
        return products;
    }
}