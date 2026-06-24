# Exercise 5: Triggers

This exercise contains PL/SQL triggers demonstrating event-driven behavior like logging, integrity validation, and timestamp updates.

## Scenarios

### Scenario 1: Update Last Modified Date
Automatically update the `LastModified` column of the `Customers` table to the current date whenever a customer's record is updated.
- Script: `scenario1.sql`

### Scenario 2: Transaction Audit Log
Maintain an audit log by inserting a record into the `AuditLog` table whenever a transaction is inserted into the `Transactions` table.
- Script: `scenario2.sql`

### Scenario 3: Enforce Transaction Rules
Ensure withdrawals do not exceed the account balance and deposits/withdrawals are positive before inserting a transaction.
- Script: `scenario3.sql`

## How to Execute

1. Connect to your Oracle database.
2. Run the scripts to compile the triggers.
3. Verify by running the test blocks:
   - For `UpdateCustomerLastModified`:
     ```sql
     UPDATE Customers SET Name = 'John Updated' WHERE CustomerID = 1;
     SELECT LastModified FROM Customers WHERE CustomerID = 1;
     ```
   - For `LogTransaction`:
     ```sql
     INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
     VALUES (3, 1, SYSDATE, 50, 'Deposit');
     SELECT * FROM AuditLog;
     ```
   - For `CheckTransactionRules`:
     ```sql
     -- Attempt withdrawal of an excessive amount
     INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
     VALUES (4, 1, SYSDATE, 50000, 'Withdrawal'); -- Should fail with Insufficient balance error
     ```
