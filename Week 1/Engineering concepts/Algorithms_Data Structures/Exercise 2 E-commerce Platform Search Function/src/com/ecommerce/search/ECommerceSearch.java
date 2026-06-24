package com.ecommerce.search;

import java.util.Arrays;

class Product implements Comparable<Product> {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public int compareTo(Product other) {
        return this.productName.compareToIgnoreCase(other.productName);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

public class ECommerceSearch {
    public static Product linearSearch(Product[] products, String targetName) {
        if (products == null || targetName == null) {
            return null;
        }
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String targetName) {
        if (products == null || targetName == null) {
            return null;
        }
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = products[mid].getProductName().compareToIgnoreCase(targetName);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product("P101", "Wireless Mouse", "Electronics"),
            new Product("P102", "Mechanical Keyboard", "Electronics"),
            new Product("P103", "Gaming Monitor", "Electronics"),
            new Product("P104", "Leather Wallet", "Accessories"),
            new Product("P105", "Running Shoes", "Footwear"),
            new Product("P106", "Bluetooth Speaker", "Electronics"),
            new Product("P107", "Stainless Steel Bottle", "Kitchenware"),
            new Product("P108", "Desk Organizer", "Office Supplies"),
            new Product("P109", "USB-C Hub", "Electronics"),
            new Product("P110", "Noise Cancelling Headphones", "Electronics")
        };

        System.out.println("==================================================================");
        System.out.println("            E-commerce Platform Search Performance Test           ");
        System.out.println("==================================================================");

        System.out.println("\n--- Original Product List (Unsorted) ---");
        for (Product p : products) {
            System.out.println("  " + p);
        }

        Product[] sortedProducts = products.clone();
        Arrays.sort(sortedProducts);

        System.out.println("\n--- Sorted Product List (For Binary Search) ---");
        for (Product p : sortedProducts) {
            System.out.println("  " + p);
        }

        String[] targets = {
            "Running Shoes",
            "Wireless Mouse",
            "Noise Cancelling Headphones",
            "Smartphone"
        };

        for (String target : targets) {
            System.out.println("\n------------------------------------------------------------------");
            System.out.println("Searching for: \"" + target + "\"");
            System.out.println("------------------------------------------------------------------");

            long startTime = System.nanoTime();
            Product linearResult = linearSearch(products, target);
            long endTime = System.nanoTime();
            long linearDuration = endTime - startTime;

            System.out.printf("  [Linear Search] Result: %s\n",
                (linearResult != null ? "FOUND -> " + linearResult : "NOT FOUND"));
            System.out.printf("  [Linear Search] Time Taken: %d ns\n\n", linearDuration);

            startTime = System.nanoTime();
            Product binaryResult = binarySearch(sortedProducts, target);
            endTime = System.nanoTime();
            long binaryDuration = endTime - startTime;

            System.out.printf("  [Binary Search] Result: %s\n",
                (binaryResult != null ? "FOUND -> " + binaryResult : "NOT FOUND"));
            System.out.printf("  [Binary Search] Time Taken: %d ns\n", binaryDuration);
        }
        System.out.println("==================================================================");
    }
}
