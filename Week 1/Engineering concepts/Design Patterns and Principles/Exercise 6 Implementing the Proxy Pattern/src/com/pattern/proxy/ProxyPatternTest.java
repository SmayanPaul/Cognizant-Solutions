package com.pattern.proxy;

interface Image {
    void display();
}

class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromRemoteServer();
    }

    private void loadFromRemoteServer() {
        System.out.println("Loading " + filename + " from remote server...");
    }

    public void display() {
        System.out.println("Displaying " + filename);
    }
}

class ProxyImage implements Image {
    private String filename;
    private RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

public class ProxyPatternTest {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("high_res_photo_1.png");
        Image image2 = new ProxyImage("high_res_photo_2.png");

        System.out.println("--- Loading and Displaying Image 1 for the first time ---");
        image1.display();

        System.out.println("\n--- Displaying Image 1 again (caching test) ---");
        image1.display();

        System.out.println("\n--- Loading and Displaying Image 2 for the first time ---");
        image2.display();

        System.out.println("\n--- Displaying Image 2 again (caching test) ---");
        image2.display();
    }
}
