# Exercise 1: Control Structures

This exercise contains PL/SQL blocks demonstrating basic control structures like loops, conditional statements, and output statements.

## Scenarios

### Scenario 1: Loan Discount for Seniors
Apply a 1% discount to the interest rate of all active loans for customers who are above 60 years old.
- Script: `scenario1.sql`

### Scenario 2: VIP Status Promotion
Promote customers with a total balance of more than $10,000 to VIP status (`IsVIP = 'TRUE'`).
- Script: `scenario2.sql`

### Scenario 3: Loan Due Reminders
Print reminder messages for all customers whose loans are due within the next 30 days.
- Script: `scenario3.sql`

## How to Execute

1. Make sure the database schema is initialized using `schema.sql`.
2. Connect to your Oracle database instance.
3. Enable console output by running:
   ```sql
   SET SERVEROUTPUT ON;
   ```
4. Run each scenario script in your SQL tool (SQL Developer, SQL*Plus, or Live SQL).
