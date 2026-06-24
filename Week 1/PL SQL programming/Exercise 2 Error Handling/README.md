# Exercise 2: Error Handling

This exercise contains PL/SQL stored procedures demonstrating robust error handling using standard and custom exceptions, transactional commits, and rollbacks.

## Scenarios

### Scenario 1: Safe Fund Transfer
Transfer funds between two accounts. Ensure that if any error occurs (such as insufficient funds or non-existent accounts), the exception is handled, an error is printed, and the entire transaction rolls back.
- Script: `scenario1.sql`

### Scenario 2: Employee Salary Update
Increase the salary of an employee by a given percentage. If the employee ID does not exist, capture the `NO_DATA_FOUND` exception and log the error message.
- Script: `scenario2.sql`

### Scenario 3: Prevent Duplicate Customer Insertion
Insert a new customer into the database. If a customer with the same ID already exists, catch the `DUP_VAL_ON_INDEX` exception, print an error message, and prevent insertion.
- Script: `scenario3.sql`

## How to Execute

1. Connect to your Oracle database.
2. Enable console output:
   ```sql
   SET SERVEROUTPUT ON;
   ```
3. Run the scripts to compile the stored procedures.
4. Test the procedures by running test blocks:
   - For `SafeTransferFunds`:
     ```sql
     EXEC SafeTransferFunds(1, 2, 500); -- Success
     EXEC SafeTransferFunds(1, 2, 5000); -- Failure (Insufficient funds)
     ```
   - For `UpdateSalary`:
     ```sql
     EXEC UpdateSalary(1, 10); -- Success
     EXEC UpdateSalary(999, 10); -- Failure (Employee does not exist)
     ```
   - For `AddNewCustomer`:
     ```sql
     EXEC AddNewCustomer(4, 'New User', TO_DATE('1995-01-01', 'YYYY-MM-DD'), 2000); -- Success
     EXEC AddNewCustomer(1, 'Duplicate User', TO_DATE('1995-01-01', 'YYYY-MM-DD'), 2000); -- Failure (Already exists)
     ```
