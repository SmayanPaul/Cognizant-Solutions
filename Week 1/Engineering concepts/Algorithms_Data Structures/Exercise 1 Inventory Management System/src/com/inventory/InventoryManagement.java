package com.inventory;

import java.util.HashMap;
import java.util.Map;

class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=$" + price +
                '}';
    }
}

public class InventoryManagement {
    private Map<String, Product> inventory;

    public InventoryManagement() {
        this.inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (product == null) {
            return;
        }
        inventory.put(product.getProductId(), product);
    }

    public void updateProduct(String productId, int newQuantity, double newPrice) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setQuantity(newQuantity);
            product.setPrice(newPrice);
        }
    }

    public void deleteProduct(String productId) {
        inventory.remove(productId);
    }

    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("  Inventory is empty.");
            return;
        }
        for (Product product : inventory.values()) {
            System.out.println("  " + product);
        }
    }

    public static void main(String[] args) {
        InventoryManagement im = new InventoryManagement();

        System.out.println("==================================================================");
        System.out.println("                   Inventory Management System                    ");
        System.out.println("==================================================================");

        System.out.println("\nAdding products...");
        im.addProduct(new Product("P001", "Laptop", 10, 999.99));
        im.addProduct(new Product("P002", "Smartphone", 25, 499.99));
        im.addProduct(new Product("P003", "Headphones", 50, 79.99));
        im.displayInventory();

        System.out.println("\nUpdating Smartphone quantity to 30 and price to 449.99...");
        im.updateProduct("P002", 30, 449.99);
        im.displayInventory();

        System.out.println("\nDeleting Laptop from inventory...");
        im.deleteProduct("P001");
        im.displayInventory();
        System.out.println("==================================================================");
    }
}
