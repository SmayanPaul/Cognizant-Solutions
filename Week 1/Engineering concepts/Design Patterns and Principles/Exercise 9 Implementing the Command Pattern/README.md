# Exercise 9: Implementing the Command Pattern

This folder contains the implementation and analysis of a decoupled home automation remote control utility employing the Command Pattern.

## Deliverables in this Folder

1. **`src/com/pattern/command/CommandPatternTest.java`**: The single Java source file implementing the `Command` interface, concrete commands (`LightOnCommand`, `LightOffCommand`), receiver `Light` class, invoker `RemoteControl` class, and test runner class. Contains zero comments.
2. **`bin/`**: Compiled Java bytecode binaries.
3. **`output.txt`**: Redirected console stdout verifying command dispatch.
4. **`Exercise 9 Implementing the Command Pattern Answers.docx`**: A professionally styled Word Document answering the design questions.
5. **`README.md`**: This guide describing the folder structure and execution instructions.

## Key Design Principles Applied

- **Decoupling Sender and Receiver**: The `RemoteControl` (sender/invoker) knows nothing about the concrete `Light` class (receiver); it interacts solely via the `Command` interface.
- **Parameterizing Requests**: Different device commands can be bound to the remote buttons dynamically by passing command instances.
- **Command Extensibility**: Adding new devices (like a Fan) only requires creating new receiver classes and corresponding concrete commands without modifying existing remote control code.

## How to Compile & Run

To compile and run the application manually from this folder:

```cmd
# Compile the Java file into the bin directory
javac -d bin src\com\pattern\command\CommandPatternTest.java

# Run the compiled application
java -cp bin com.pattern.command.CommandPatternTest
```
