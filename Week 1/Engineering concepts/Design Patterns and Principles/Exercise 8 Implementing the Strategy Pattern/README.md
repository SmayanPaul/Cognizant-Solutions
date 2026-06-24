# Exercise 8: Implementing the Strategy Pattern

This folder contains the implementation and analysis of a flexible checkout and payment transaction context utilizing the Strategy Pattern.

## Deliverables in this Folder

1. **`src/com/pattern/strategy/StrategyPatternTest.java`**: The single Java source file containing the `PaymentStrategy` interface, concrete strategy classes (`CreditCardPayment`, `PayPalPayment`), context manager class (`PaymentContext`), and test runner class. Contains zero comments.
2. **`bin/`**: Compiled Java bytecode binaries.
3. **`output.txt`**: Redirected console stdout verifying strategy interchanges.
4. **`Exercise 8 Implementing the Strategy Pattern Answers.docx`**: A professionally styled Word Document answering the design questions.
5. **`README.md`**: This guide describing the folder structure and execution instructions.

## Key Design Principles Applied

- **Open/Closed Principle**: We can easily add a new payment strategy (e.g. `CryptoPayment`) by implementing the `PaymentStrategy` interface without altering the `PaymentContext` or existing strategy implementations.
- **Encapsulation**: Each payment method hides its specialized parameter requirements (e.g. credit card details vs. PayPal email credentials) within its class block.
- **Dynamic Selection**: The context's strategy instance can be configured or changed dynamically at runtime by invoking `setPaymentStrategy()`.

## How to Compile & Run

To compile and run the application manually from this folder:

```cmd
# Compile the Java file into the bin directory
javac -d bin src\com\pattern\strategy\StrategyPatternTest.java

# Run the compiled application
java -cp bin com.pattern.strategy.StrategyPatternTest
```
