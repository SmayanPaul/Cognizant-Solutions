# Exercise 2: Test Suites and Categories

## Description
This exercise covers creating a JUnit 5 test suite class `AllTests` to group multiple test classes (`FirstTest` and `SecondTest`) using `@Suite` and `@SelectClasses` annotations.

## How to Compile & Run

### 1. Compile
Run the following command from this directory:
```cmd
javac -cp "..\lib\*" -d bin src\com\junit\advanced\suite\AllTests.java
```

### 2. Run
Run the suite test launcher:
```cmd
java -cp "bin;..\lib\*" com.junit.advanced.suite.AllTests
```
