package com.pattern.builder;

class Computer {
    private String CPU;
    private String RAM;
    private String storage;
    private boolean isGPUEnabled;
    private boolean isBluetoothEnabled;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.isGPUEnabled = builder.isGPUEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    public String getCPU() {
        return CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public String getStorage() {
        return storage;
    }

    public boolean isGPUEnabled() {
        return isGPUEnabled;
    }

    public boolean isBluetoothEnabled() {
        return isBluetoothEnabled;
    }

    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + storage + 
               ", GPU=" + isGPUEnabled + ", Bluetooth=" + isBluetoothEnabled + "]";
    }

    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;
        private boolean isGPUEnabled;
        private boolean isBluetoothEnabled;

        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGPUEnabled(boolean isGPUEnabled) {
            this.isGPUEnabled = isGPUEnabled;
            return this;
        }

        public Builder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

public class BuilderPatternTest {
    public static void main(String[] args) {
        Computer gamingPC = new Computer.Builder("Intel Core i9", "32GB")
                .setStorage("2TB NVMe SSD")
                .setGPUEnabled(true)
                .setBluetoothEnabled(true)
                .build();

        Computer officePC = new Computer.Builder("Intel Core i5", "16GB")
                .setStorage("512GB SSD")
                .setGPUEnabled(false)
                .setBluetoothEnabled(false)
                .build();

        Computer budgetPC = new Computer.Builder("Intel Core i3", "8GB")
                .build();

        System.out.println(gamingPC);
        System.out.println(officePC);
        System.out.println(budgetPC);
    }
}
