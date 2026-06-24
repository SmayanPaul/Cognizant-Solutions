DECLARE
    CURSOR c_loans IS
        SELECT LoanID, InterestRate
        FROM Loans
        FOR UPDATE;
    v_rec c_loans%ROWTYPE;
BEGIN
    OPEN c_loans;
    LOOP
        FETCH c_loans INTO v_rec;
        EXIT WHEN c_loans%NOTFOUND;
        
        UPDATE Loans
        SET InterestRate = InterestRate + 0.5
        WHERE CURRENT OF c_loans;
    END LOOP;
    CLOSE c_loans;
    COMMIT;
END;
/
