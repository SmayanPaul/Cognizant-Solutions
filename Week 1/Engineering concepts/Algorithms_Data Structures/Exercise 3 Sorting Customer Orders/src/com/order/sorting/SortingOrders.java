package com.order.sorting;

class Order {
    private String orderId;
    private String customerName;
    private double totalPrice;

    public Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", totalPrice=$" + totalPrice +
                '}';
    }
}

public class SortingOrders {

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Order[] sampleOrders = {
            new Order("O001", "Alice", 250.50),
            new Order("O002", "Bob", 89.99),
            new Order("O003", "Charlie", 1200.00),
            new Order("O004", "David", 45.00),
            new Order("O005", "Emma", 310.00),
            new Order("O006", "Frank", 15.75),
            new Order("O007", "Grace", 620.40)
        };

        System.out.println("==================================================================");
        System.out.println("                  Customer Orders Sorting Performance             ");
        System.out.println("==================================================================");

        Order[] bubbleSorted = sampleOrders.clone();
        System.out.println("\n--- Before Bubble Sort ---");
        for (Order o : bubbleSorted) {
            System.out.println("  " + o);
        }

        long startTime = System.nanoTime();
        bubbleSort(bubbleSorted);
        long endTime = System.nanoTime();
        long bubbleTime = endTime - startTime;

        System.out.println("\n--- After Bubble Sort ---");
        for (Order o : bubbleSorted) {
            System.out.println("  " + o);
        }
        System.out.printf("  [Bubble Sort] Time Taken: %d ns\n", bubbleTime);

        Order[] quickSorted = sampleOrders.clone();
        System.out.println("\n------------------------------------------------------------------");
        System.out.println("--- Before Quick Sort ---");
        for (Order o : quickSorted) {
            System.out.println("  " + o);
        }

        startTime = System.nanoTime();
        quickSort(quickSorted, 0, quickSorted.length - 1);
        endTime = System.nanoTime();
        long quickTime = endTime - startTime;

        System.out.println("\n--- After Quick Sort ---");
        for (Order o : quickSorted) {
            System.out.println("  " + o);
        }
        System.out.printf("  [Quick Sort] Time Taken: %d ns\n", quickTime);
        System.out.println("==================================================================");
    }
}
