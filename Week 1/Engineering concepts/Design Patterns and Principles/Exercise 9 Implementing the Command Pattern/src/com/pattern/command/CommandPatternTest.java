package com.pattern.command;

interface Command {
    void execute();
}

class Light {
    public void turnOn() {
        System.out.println("The light is turned ON.");
    }

    public void turnOff() {
        System.out.println("The light is turned OFF.");
    }
}

class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }
}

class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        if (command == null) {
            System.out.println("No command assigned to this button.");
        } else {
            command.execute();
        }
    }
}

public class CommandPatternTest {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();

        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();

        System.out.println("--- Pressing ON Button ---");
        remote.setCommand(lightOn);
        remote.pressButton();

        System.out.println("\n--- Pressing OFF Button ---");
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
