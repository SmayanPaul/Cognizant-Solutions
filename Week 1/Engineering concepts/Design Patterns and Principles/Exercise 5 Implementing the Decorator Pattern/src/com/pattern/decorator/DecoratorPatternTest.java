package com.pattern.decorator;

interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    public void send(String message) {
        wrappedNotifier.send(message);
    }
}

class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        sendSlack(message);
    }

    private void sendSlack(String message) {
        System.out.println("Sending Slack Message: " + message);
    }
}

public class DecoratorPatternTest {
    public static void main(String[] args) {
        System.out.println("--- Scenario 1: Base Email Notifier ---");
        Notifier emailNotifier = new EmailNotifier();
        emailNotifier.send("System Alert: Disk space is running low!");

        System.out.println("\n--- Scenario 2: Email + SMS Notifier ---");
        Notifier emailAndSMS = new SMSNotifierDecorator(new EmailNotifier());
        emailAndSMS.send("System Alert: High CPU usage detected!");

        System.out.println("\n--- Scenario 3: Email + SMS + Slack Notifier ---");
        Notifier allChannels = new SlackNotifierDecorator(new SMSNotifierDecorator(new EmailNotifier()));
        allChannels.send("System Alert: Critical error! Database server offline!");
    }
}
