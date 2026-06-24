# Exercise 4: Functions

This exercise contains PL/SQL user-defined functions demonstrating calculation returns and checks.

## Scenarios

### Scenario 1: Calculate Age
A function `CalculateAge` that takes a customer's date of birth as input and returns their age in years.
- Script: `scenario1.sql`

### Scenario 2: Calculate Monthly Installment
A function `CalculateMonthlyInstallment` that takes the loan amount, interest rate (annual percentage), and loan duration in years as input and returns the monthly installment amount.
- Script: `scenario2.sql`

### Scenario 3: Has Sufficient Balance
A function `HasSufficientBalance` that takes an account ID and an amount as input and returns a boolean indicating whether the account has at least the specified amount.
- Script: `scenario3.sql`

## How to Execute

1. Connect to your Oracle database.
2. Run the scripts to compile the functions.
3. Verify by running the test blocks:
   - For `CalculateAge`:
     ```sql
     SELECT CalculateAge(DOB) FROM Customers WHERE CustomerID = 1;
     ```
   - For `CalculateMonthlyInstallment`:
     ```sql
     SELECT CalculateMonthlyInstallment(5000, 5, 5) FROM DUAL;
     ```
   - For `HasSufficientBalance`:
     ```sql
     SET SERVEROUTPUT ON;
     DECLARE
         v_result BOOLEAN;
     BEGIN
         v_result := HasSufficientBalance(1, 200);
         IF v_result THEN
             DBMS_OUTPUT.PUT_LINE('Sufficient balance');
         ELSE
             DBMS_OUTPUT.PUT_LINE('Insufficient balance');
         END IF;
     END;
     /
     ```
