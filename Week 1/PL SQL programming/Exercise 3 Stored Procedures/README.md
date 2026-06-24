# Exercise 3: Stored Procedures

This exercise contains PL/SQL stored procedures executing state mutations such as interest processing, bonus updates, and fund transfers.

## Scenarios

### Scenario 1: Savings Accounts Monthly Interest
Calculate and update the balance of all savings accounts by applying an interest rate of 1% to the current balance.
- Script: `scenario1.sql`

### Scenario 2: Employee Bonus Scheme
Update the salary of employees in a given department by adding a bonus percentage passed as a parameter.
- Script: `scenario2.sql`

### Scenario 3: Transfer Funds
Transfer a specified amount from one account to another, checking that the source account has sufficient balance before making the transfer.
- Script: `scenario3.sql`

## How to Execute

1. Connect to your Oracle database.
2. Run the scripts to compile the stored procedures.
3. Verify by running the test blocks:
   - For `ProcessMonthlyInterest`:
     ```sql
     EXEC ProcessMonthlyInterest;
     ```
   - For `UpdateEmployeeBonus`:
     ```sql
     EXEC UpdateEmployeeBonus('HR', 5);
     ```
   - For `TransferFunds`:
     ```sql
     EXEC TransferFunds(1, 2, 100);
     ```
