# Exercise 1: Setting Up JUnit

## Description
This exercise covers setting up the JUnit 4 testing environment inside a Java project to enable writing and executing unit tests.

## How to Compile & Run

### 1. Compile
Run the following command from this directory:
```cmd
javac -cp "..\lib\*" -d bin src\com\junit\setup\JUnitSetupTest.java
```

### 2. Run
Run the test using the JUnit console runner:
```cmd
java -cp "bin;..\lib\*" org.junit.runner.JUnitCore com.junit.setup.JUnitSetupTest
```
