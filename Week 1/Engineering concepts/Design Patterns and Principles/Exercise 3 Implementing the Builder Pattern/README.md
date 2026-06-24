# Exercise 3: Implementing the Builder Pattern

This folder contains the implementation and analysis of a complex object creation pipeline using the Builder Pattern.

## Deliverables in this Folder

1. **`src/com/pattern/builder/BuilderPatternTest.java`**: The single Java source file containing the `Computer` product class with a static nested `Builder` class and the test runner. Contains zero comments.
2. **`bin/`**: Compiled Java bytecode binaries.
3. **`output.txt`**: Redirected console stdout verifying the correct execution of the builder client.
4. **`Exercise 3 Implementing the Builder Pattern Answers.docx`**: A professionally styled Word Document answering the design questions and demonstrating results.
5. **`README.md`**: This guide describing the folder structure and execution instructions.

## Key Design Principles Applied

- **Fluent Interface**: Builder setter methods return the builder instance (`this`) to support method chaining.
- **Immutability**: The constructed `Computer` object lacks setter methods, rendering it thread-safe and immutable once built.
- **Handling Optional Parameters**: Mandatory properties (e.g. CPU, RAM) are passed to the Builder's constructor, while optional parameters (e.g. storage, GPU, Bluetooth) are set step-by-step.

## How to Compile & Run

To compile and run the application manually from this folder:

```cmd
# Compile the Java file into the bin directory
javac -d bin src\com\pattern\builder\BuilderPatternTest.java

# Run the compiled application
java -cp bin com.pattern.builder.BuilderPatternTest
```
