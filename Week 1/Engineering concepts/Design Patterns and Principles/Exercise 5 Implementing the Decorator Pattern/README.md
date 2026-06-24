# Exercise 5: Implementing the Decorator Pattern

This folder contains the implementation and analysis of a dynamic alert/notification system employing the Decorator Pattern.

## Deliverables in this Folder

1. **`src/com/pattern/decorator/DecoratorPatternTest.java`**: The single Java source file implementing the `Notifier` interface, concrete `EmailNotifier` component, abstract decorator `NotifierDecorator`, concrete decorators (`SMSNotifierDecorator`, `SlackNotifierDecorator`), and a test class. Contains zero comments.
2. **`bin/`**: Compiled Java bytecode binaries.
3. **`output.txt`**: Redirected console stdout verifying the correct execution of decorator nesting.
4. **`Exercise 5 Implementing the Decorator Pattern Answers.docx`**: A professionally styled Word Document answering the design questions.
5. **`README.md`**: This guide describing the folder structure and execution instructions.

## Key Design Principles Applied

- **Composition Over Inheritance**: Extends functionality at runtime by wrapping objects instead of subclassing.
- **Runtime Composition**: Decoupled notification paths (Email, Email + SMS, Email + SMS + Slack) are constructed dynamically at runtime.
- **Single Responsibility Principle**: Individual notification dispatchers are isolated in their own classes (email logic in email component, SMS logic in SMS decorator).

## How to Compile & Run

To compile and run the application manually from this folder:

```cmd
# Compile the Java file into the bin directory
javac -d bin src\com\pattern\decorator\DecoratorPatternTest.java

# Run the compiled application
java -cp bin com.pattern.decorator.DecoratorPatternTest
```
