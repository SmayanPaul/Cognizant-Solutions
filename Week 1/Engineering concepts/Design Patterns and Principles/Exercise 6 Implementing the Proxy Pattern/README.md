# Exercise 6: Implementing the Proxy Pattern

This folder contains the implementation and analysis of a lazy-loading and caching Image Viewer system using the Proxy Pattern.

## Deliverables in this Folder

1. **`src/com/pattern/proxy/ProxyPatternTest.java`**: The single Java source file implementing the `Image` interface, concrete `RealImage` class, proxy `ProxyImage` class, and the test class. Contains zero comments.
2. **`bin/`**: Compiled Java bytecode binaries.
3. **`output.txt`**: Redirected console stdout verifying lazy loading and caching behaviors.
4. **`Exercise 6 Implementing the Proxy Pattern Answers.docx`**: A professionally styled Word Document answering all design questions.
5. **`README.md`**: This guide describing the folder structure and execution instructions.

## Key Design Principles Applied

- **Lazy Initialization**: The heavy `RealImage` object is not loaded from the remote server until the client explicitly requests it via `display()`.
- **Caching / Virtual Proxy**: The proxy holds a reference to the `RealImage` once loaded, preventing subsequent display calls from re-triggering expensive network load operations.
- **Unified Interface**: The proxy and real subject implement the common `Image` interface, ensuring that the client remains unaware of the proxy layer.

## How to Compile & Run

To compile and run the application manually from this folder:

```cmd
# Compile the Java file into the bin directory
javac -d bin src\com\pattern\proxy\ProxyPatternTest.java

# Run the compiled application
java -cp bin com.pattern.proxy.ProxyPatternTest
```
