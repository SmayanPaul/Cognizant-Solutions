DECLARE
    CURSOR c_accounts IS
        SELECT AccountID, Balance
        FROM Accounts
        FOR UPDATE;
    v_rec c_accounts%ROWTYPE;
    v_fee CONSTANT NUMBER := 50;
BEGIN
    OPEN c_accounts;
    LOOP
        FETCH c_accounts INTO v_rec;
        EXIT WHEN c_accounts%NOTFOUND;
        
        UPDATE Accounts
        SET Balance = Balance - v_fee
        WHERE CURRENT OF c_accounts;
    END LOOP;
    CLOSE c_accounts;
    COMMIT;
END;
/
