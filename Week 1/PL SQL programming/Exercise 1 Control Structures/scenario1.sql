BEGIN
    FOR r IN (
        SELECT l.LoanID, c.DOB, l.InterestRate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
    ) LOOP
        IF MONTHS_BETWEEN(SYSDATE, r.DOB) / 12 > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = r.LoanID;
        END IF;
    END LOOP;
    COMMIT;
END;
/
