# Exercise 1: Mocking and Stubbing

## Description
This exercise covers creating a mock object for an external API interface (`ExternalApi`) using Mockito, stubbing its return values, and validating that a client service (`MyService`) fetches the stubbed value properly.

## How to Compile & Run

### 1. Compile
Run the following command from this directory:
```cmd
javac -cp "..\lib\*" -d bin src\com\mockito\exercises\MyServiceTest.java
```

### 2. Run
Run the test program:
```cmd
java -cp "bin;..\lib\*" com.mockito.exercises.MyServiceTest
```
