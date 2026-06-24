# Exercise 11: Implementing Dependency Injection

This folder contains the implementation and analysis of a decoupled Customer Management application using Constructor Dependency Injection.

## Deliverables in this Folder

1. **`src/com/pattern/di/DependencyInjectionTest.java`**: The single Java source file containing the `CustomerRepository` interface, concrete `CustomerRepositoryImpl` class, `CustomerService` class (with injected dependency), and test runner class. Contains zero comments.
2. **`bin/`**: Compiled Java bytecode binaries.
3. **`output.txt`**: Redirected console stdout verifying dependency injection.
4. **`Exercise 11 Implementing Dependency Injection Answers.docx`**: A professionally styled Word Document answering the design questions.
5. **`README.md`**: This guide describing the folder structure and execution instructions.

## Key Design Principles Applied

- **Dependency Inversion Principle**: High-level modules (e.g. `CustomerService`) do not depend on low-level modules (e.g. `CustomerRepositoryImpl`); instead, both depend on abstractions (e.g. `CustomerRepository`).
- **Constructor Injection**: Dependencies are injected into the dependent object at instantiation time via its constructor.
- **Unit Testability**: The service class can be isolated and tested easily by passing a mock implementation of the repository interface in unit tests.

## How to Compile & Run

To compile and run the application manually from this folder:

```cmd
# Compile the Java file into the bin directory
javac -d bin src\com\pattern\di\DependencyInjectionTest.java

# Run the compiled application
java -cp bin com.pattern.di.DependencyInjectionTest
```
