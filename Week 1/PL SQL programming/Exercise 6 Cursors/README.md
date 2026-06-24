# Exercise 6: Cursors

This exercise contains PL/SQL blocks demonstrating the use of explicit cursors, cursor loops, and row locking using `FOR UPDATE` and `WHERE CURRENT OF`.

## Scenarios

### Scenario 1: Generate Monthly Statements
An explicit cursor `GenerateMonthlyStatements` that retrieves all transactions for the current month and prints a statement for each customer.
- Script: `scenario1.sql`

### Scenario 2: Apply Annual Fee
An explicit cursor `ApplyAnnualFee` that deducts an annual maintenance fee of $50 from the balance of all accounts.
- Script: `scenario2.sql`

### Scenario 3: Update Loan Interest Rates
An explicit cursor `UpdateLoanInterestRates` that fetches all loans and updates their interest rates (e.g., increasing by 0.5% based on a new policy).
- Script: `scenario3.sql`

## How to Execute

1. Connect to your Oracle database.
2. Run the scripts to execute the cursors.
3. Enable console output before executing Scenario 1:
   ```sql
   SET SERVEROUTPUT ON;
   ```
4. Verify by querying the modified tables (`Accounts` and `Loans`).
