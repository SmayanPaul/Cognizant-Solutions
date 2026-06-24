# Exercise 1: Implementing the Singleton Pattern

This folder contains the implementation and analysis of a thread-safe Singleton Logger utility.

## Deliverables in this Folder

1. **`src/com/pattern/singleton/LoggerTest.java`**: The single Java source file implementing the `Logger` singleton pattern and test runner. Contains zero comments.
2. **`bin/`**: Compiled Java bytecode binaries.
3. **`output.txt`**: Redirected console stdout verifying the correct execution and singleton state.
4. **`Exercise 1 Implementing the Singleton Pattern Answers.docx`**: A professionally styled Word Document explaining the Singleton pattern, design steps, and testing verification.
5. **`README.md`**: This guide describing the folder structure and execution instructions.

## Key Design Principles Applied

- **Private Constructor**: Prevents instantiation from other classes, enforcing that the only way to obtain an instance is via the `getInstance()` method.
- **Lazy Initialization with Double-Checked Locking**: The instance is initialized only when requested, and double-checked locking is used to ensure thread safety without the performance overhead of full synchronization.
- **Reference Comparison**: Compares memory addresses (`logger1 == logger2`) to verify that the same instance is shared globally.

## How to Compile & Run

To compile and run the application manually from this folder:

```cmd
# Compile the Java file into the bin directory
javac -d bin src\com\pattern\singleton\LoggerTest.java

# Run the compiled application
java -cp bin com.pattern.singleton.LoggerTest
```
