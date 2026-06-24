# Exercise 10: Implementing the MVC Pattern

This folder contains the implementation and analysis of a Student Record Management system leveraging the Model-View-Controller (MVC) architectural pattern.

## Deliverables in this Folder

1. **`src/com/pattern/mvc/MVCPatternTest.java`**: The single Java source file containing the `Student` (Model) class, `StudentView` (View) class, `StudentController` (Controller) class, and test runner. Contains zero comments.
2. **`bin/`**: Compiled Java bytecode binaries.
3. **`output.txt`**: Redirected console stdout verifying MVC synchronization.
4. **`Exercise 10 Implementing the MVC Pattern Answers.docx`**: A professionally styled Word Document answering the design questions.
5. **`README.md`**: This guide describing the folder structure and execution instructions.

## Key Design Principles Applied

- **Separation of Concerns**: Pure data attributes and business logic are isolated in the Model, console formatting and rendering in the View, and interactions in the Controller.
- **Indirect Binding**: The client never directly calls view methods on the model; instead, the controller acts as the broker to synchronize state updates with display refreshes.
- **Maintainability**: Modifying the view rendering format requires no changes to the student model structure, making code maintenance safe and straightforward.

## How to Compile & Run

To compile and run the application manually from this folder:

```cmd
# Compile the Java file into the bin directory
javac -d bin src\com\pattern\mvc\MVCPatternTest.java

# Run the compiled application
java -cp bin com.pattern.mvc.MVCPatternTest
```
