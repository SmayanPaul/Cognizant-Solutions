SET SERVEROUTPUT ON;

DECLARE
    CURSOR c_statements IS
        SELECT c.Name, a.AccountID, t.TransactionID, t.TransactionDate, t.Amount, t.TransactionType
        FROM Transactions t
        JOIN Accounts a ON t.AccountID = a.AccountID
        JOIN Customers c ON a.CustomerID = c.CustomerID
        WHERE TRUNC(t.TransactionDate, 'MM') = TRUNC(SYSDATE, 'MM');
    v_rec c_statements%ROWTYPE;
BEGIN
    OPEN c_statements;
    LOOP
        FETCH c_statements INTO v_rec;
        EXIT WHEN c_statements%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Customer: ' || v_rec.Name || ' | Account: ' || v_rec.AccountID || ' | Transaction: ' || v_rec.TransactionID || ' | Date: ' || TO_CHAR(v_rec.TransactionDate, 'YYYY-MM-DD') || ' | Type: ' || v_rec.TransactionType || ' | Amount: ' || v_rec.Amount);
    END LOOP;
    CLOSE c_statements;
END;
/
