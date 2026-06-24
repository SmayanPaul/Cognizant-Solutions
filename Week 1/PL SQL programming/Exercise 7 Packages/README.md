# Exercise 7: Packages

This exercise contains PL/SQL packages grouping related procedures and functions for modular management of customers, employees, and account operations.

## Scenarios

### Scenario 1: Customer Management
Create a package `CustomerManagement` containing procedures for adding a customer, updating customer details, and a function to get the customer's balance.
- Script: `scenario1.sql`

### Scenario 2: Employee Management
Create a package `EmployeeManagement` containing procedures to hire new employees, update details, and a function to calculate their annual salary.
- Script: `scenario2.sql`

### Scenario 3: Account Operations
Create a package `AccountOperations` containing procedures to open and close accounts, and a function to calculate a customer's total balance across all accounts.
- Script: `scenario3.sql`

## How to Execute

1. Connect to your Oracle database.
2. Run the scripts to compile the packages (specification and body).
3. Verify by executing package routines:
   - For `CustomerManagement`:
     ```sql
     EXEC CustomerManagement.AddCustomer(5, 'Charlie', TO_DATE('1988-10-12', 'YYYY-MM-DD'), 3000);
     ```
   - For `EmployeeManagement`:
     ```sql
     EXEC EmployeeManagement.HireEmployee(3, 'David', 'Analyst', 5000, 'Finance', SYSDATE);
     ```
   - For `AccountOperations`:
     ```sql
     SELECT AccountOperations.GetTotalBalance(1) FROM DUAL;
     ```
