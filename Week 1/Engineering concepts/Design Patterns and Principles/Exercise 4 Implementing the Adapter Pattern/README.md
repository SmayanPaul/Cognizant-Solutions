# Exercise 4: Implementing the Adapter Pattern

This folder contains the implementation and analysis of a payment processing integration utilizing the Adapter Pattern.

## Deliverables in this Folder

1. **`src/com/pattern/adapter/AdapterPatternTest.java`**: The single Java source file containing the `PaymentProcessor` interface, concrete third-party gateways (`PayPalGateway`, `StripeGateway`), adapters (`PayPalAdapter`, `StripeAdapter`), and test runner class. Contains zero comments.
2. **`bin/`**: Compiled Java bytecode binaries.
3. **`output.txt`**: Redirected console stdout verifying the correct execution of the adapters.
4. **`Exercise 4 Implementing the Adapter Pattern Answers.docx`**: A professionally styled Word Document answering all design and implementation questions.
5. **`README.md`**: This guide describing the folder structure and execution instructions.

## Key Design Principles Applied

- **Target Interface**: The client interacts only with the `PaymentProcessor` interface, keeping the code unified and clean.
- **Object Composition**: Adapters store a reference to their respective gateway (Adaptee) instances rather than inheriting from them, favoring composition over inheritance.
- **Translational Wrapper**: Each adapter implements the Target interface and translates the input parameters and method calls to the Adaptee's interface.

## How to Compile & Run

To compile and run the application manually from this folder:

```cmd
# Compile the Java file into the bin directory
javac -d bin src\com\pattern\adapter\AdapterPatternTest.java

# Run the compiled application
java -cp bin com.pattern.adapter.AdapterPatternTest
```
