package org.example;

import java.util.HashMap;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class    Main {

    public static String addProduct(HashMap<String, Integer> products, String productName, int value){
        int beforeLength = products.size();
        products.put(productName, value);
        int afterLength = products.size();
        if (beforeLength > afterLength){
            return "Product: Not Added";
        }
        return "Product: Added";
    }

    public static void viewInventory(HashMap<String, Integer> products){
        for (String i : products.keySet()){
            System.out.println(i+" - "+products.get(i)+" pcs");
        }
    }
    public static String updateStock(HashMap<String, Integer> products, String productName, int value){
        if(!products.replace(productName, products.get(productName),value)){
            System.out.println("Stock not updated");
            return "Product not updated";
        }
        System.out.println("Stock updated");
        return "Product Updated";
    }
    public static String removeProduct(HashMap<String, Integer> products, String productName){
        products.remove(productName);
        if(products.get(productName)!= null){
            System.out.print("Product not removed");
            return "ERR: Cant remove product";
        }
        System.out.println("Product Removed");
        return "Product removed";
    }

    public static String checkProduct(HashMap<String, Integer> products, String productName){
        if (products.get(productName) == null){
            System.out.println(productName + " is not in stock");
            return "Product not Found";
        }
        System.out.println(productName + " is in stock: " + products.get(productName));

        return "Product Found";
    }
    public static void main(String[] args) {
        HashMap<String, Integer> products = new HashMap<>();
        int choice = 0;
        Scanner scanner = new Scanner(System.in);

        while (choice != 6){
            // view, add, check, update, remove,exit

            System.out.println("--- Grocery Inventory Menu ---");
            System.out.println("1. View Inventory");
            System.out.println("2. Add Product");
            System.out.println("3. Check Product");
            System.out.println("4. Update Stock");
            System.out.println("5. Remove Product");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            choice = scanner.nextInt();

            switch (choice){
                case 1:
                    // View Inventory
                    System.out.println("Current Inventory");
                    viewInventory(products);
                    break;
                case 2:
                    // Add products
                    System.out.print("Enter product name: ");
                    String product= scanner.next();
                    System.out.println("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    addProduct(products, product, quantity);
                    break;
                case 3:
                    System.out.print("Enter product name to check: ");
                    product = scanner.next();
                    checkProduct(products, product);
                    break;
                case 4:
                    System.out.print("Enter product name to update: ");
                    product = scanner.next();
                    System.out.println("Enter new stock quantity: ");
                    quantity = scanner.nextInt();
                    updateStock(products, product, quantity);
                    break;
                case 5:
                    System.out.print("Enter product name to remove: ");
                    product = scanner.next();
                    removeProduct(products, product);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}