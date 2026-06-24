package com.pattern.strategy;

interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    private String name;
    private String cardNumber;
    private String cvv;
    private String expiryDate;

    public CreditCardPayment(String name, String cardNumber, String cvv, String expiryDate) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    public void pay(double amount) {
        String lastFour = cardNumber.substring(cardNumber.length() - 4);
        System.out.println("Paid $" + amount + " using Credit Card (holder: " + name + ", card ending in: " + lastFour + ").");
    }
}

class PayPalPayment implements PaymentStrategy {
    private String emailId;
    private String password;

    public PayPalPayment(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }

    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal (email: " + emailId + ").");
    }
}

class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        if (paymentStrategy == null) {
            System.out.println("No payment strategy selected.");
        } else {
            paymentStrategy.pay(amount);
        }
    }
}

public class StrategyPatternTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        System.out.println("--- Selecting Credit Card Strategy ---");
        PaymentStrategy cc = new CreditCardPayment("John Doe", "1234567890123456", "123", "12/28");
        context.setPaymentStrategy(cc);
        context.executePayment(250.00);

        System.out.println("\n--- Selecting PayPal Strategy ---");
        PaymentStrategy paypal = new PayPalPayment("john.doe@example.com", "securepass123");
        context.setPaymentStrategy(paypal);
        context.executePayment(89.95);
    }
}
