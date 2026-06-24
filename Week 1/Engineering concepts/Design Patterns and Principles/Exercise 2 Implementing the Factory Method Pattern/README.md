# Exercise 2: Implementing the Factory Method Pattern

This folder contains the implementation and analysis of a decoupled Document Management System leveraging the Factory Method Pattern.

## Deliverables in this Folder

1. **`src/com/pattern/factory/DocumentFactoryTest.java`**: The single Java source file containing the `Document` interface, concrete documents (`WordDocument`, `PdfDocument`, `ExcelDocument`), factories (`WordDocumentFactory`, `PdfDocumentFactory`, `ExcelDocumentFactory`), and test runner class. Contains zero comments.
2. **`bin/`**: Compiled Java bytecode binaries.
3. **`output.txt`**: Redirected console stdout verifying the correct execution of the factories.
4. **`Exercise 2 Implementing the Factory Method Pattern Answers.docx`**: A professionally styled Word Document answering all design and implementation questions.
5. **`README.md`**: This guide describing the folder structure and execution instructions.

## Key Design Principles Applied

- **Loose Coupling**: Client code interacts entirely with the `Document` interface and `DocumentFactory` abstract class, never depending directly on concrete document classes.
- **Single Responsibility Principle**: Instantiation logic is isolated within individual concrete factory classes.
- **Open/Closed Principle**: Adding new document types (e.g. PowerPointDocument) only requires writing a new concrete document subclass and corresponding factory subclass, without altering the existing code.

## How to Compile & Run

To compile and run the application manually from this folder:

```cmd
# Compile the Java file into the bin directory
javac -d bin src\com\pattern\factory\DocumentFactoryTest.java

# Run the compiled application
java -cp bin com.pattern.factory.DocumentFactoryTest
```
