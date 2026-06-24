package com.pattern.observer;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String stockName, double price);
}

interface Stock {
    void register(Observer o);
    void deregister(Observer o);
    void notifyObservers();
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double price;

    public StockMarket(String stockName, double initialPrice) {
        this.stockName = stockName;
        this.price = initialPrice;
    }

    public void register(Observer o) {
        observers.add(o);
    }

    public void deregister(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, price);
        }
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
        notifyObservers();
    }
}

class MobileApp implements Observer {
    private String userName;

    public MobileApp(String userName) {
        this.userName = userName;
    }

    public void update(String stockName, double price) {
        System.out.println("Mobile App [" + userName + "] Alert: Stock " + stockName + " updated to $" + price);
    }
}

class WebApp implements Observer {
    private String url;

    public WebApp(String url) {
        this.url = url;
    }

    public void update(String stockName, double price) {
        System.out.println("Web Portal [" + url + "] Broadcast: " + stockName + " price ticker: $" + price);
    }
}

public class ObserverPatternTest {
    public static void main(String[] args) {
        StockMarket techStock = new StockMarket("GOOGL", 180.50);

        Observer user1 = new MobileApp("Alice");
        Observer user2 = new MobileApp("Bob");
        Observer webPortal = new WebApp("financials.com");

        System.out.println("--- Registering Alice, Bob, and Web Portal ---");
        techStock.register(user1);
        techStock.register(user2);
        techStock.register(webPortal);

        System.out.println("\n--- Stock Price Update: $182.75 ---");
        techStock.setPrice(182.75);

        System.out.println("\n--- Deregistering Bob ---");
        techStock.deregister(user2);

        System.out.println("\n--- Stock Price Update: $185.00 ---");
        techStock.setPrice(185.00);
    }
}
