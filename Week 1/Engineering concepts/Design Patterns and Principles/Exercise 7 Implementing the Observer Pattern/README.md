# Exercise 7: Implementing the Observer Pattern

This folder contains the implementation and analysis of a stock market pricing ticker and push notification system using the Observer Pattern.

## Deliverables in this Folder

1. **`src/com/pattern/observer/ObserverPatternTest.java`**: The single Java source file implementing the `Observer` and `Stock` (Subject) interfaces, `StockMarket` concrete subject, concrete observer classes (`MobileApp`, `WebApp`), and test runner class. Contains zero comments.
2. **`bin/`**: Compiled Java bytecode binaries.
3. **`output.txt`**: Redirected console stdout verifying observer notifications.
4. **`Exercise 7 Implementing the Observer Pattern Answers.docx`**: A professionally styled Word Document answering the design questions.
5. **`README.md`**: This guide describing the folder structure and execution instructions.

## Key Design Principles Applied

- **Loose Coupling**: The `StockMarket` subject depends only on the `Observer` interface, never on concrete implementation classes (`MobileApp`, `WebApp`).
- **Push-Based Updates**: Observers do not need to poll the subject; the subject pushes state changes to all subscribers synchronously when they occur.
- **Dynamic Subscriptions**: Observers can register or deregister at runtime, and the subject dynamically adjusts the delivery pool.

## How to Compile & Run

To compile and run the application manually from this folder:

```cmd
# Compile the Java file into the bin directory
javac -d bin src\com\pattern\observer\ObserverPatternTest.java

# Run the compiled application
java -cp bin com.pattern.observer.ObserverPatternTest
```
