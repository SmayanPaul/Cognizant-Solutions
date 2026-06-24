# Exercise 4: Arrange-Act-Assert (AAA) Pattern

## Description
This exercise covers structuring unit tests using the Arrange-Act-Assert (AAA) pattern and managing test lifecycle hooks using `@Before` (setup) and `@After` (teardown) annotations for test fixtures.

## How to Compile & Run

### 1. Compile
Run the following command from this directory:
```cmd
javac -cp "..\lib\*" -d bin src\com\junit\aaa\BankAccountTest.java
```

### 2. Run
Run the tests using the JUnit console runner:
```cmd
java -cp "bin;..\lib\*" org.junit.runner.JUnitCore com.junit.aaa.BankAccountTest
```
