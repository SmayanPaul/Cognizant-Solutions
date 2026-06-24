SET SERVEROUTPUT ON;

BEGIN
    FOR r IN (
        SELECT c.Name, l.LoanID, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || r.Name || ' has loan ID ' || r.LoanID || ' due on ' || TO_CHAR(r.EndDate, 'YYYY-MM-DD'));
    END LOOP;
END;
/
