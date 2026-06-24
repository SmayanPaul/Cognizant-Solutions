CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_Balance NUMBER;
BEGIN
    IF :new.Amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Transaction amount must be positive.');
    END IF;
    
    IF :new.TransactionType = 'Withdrawal' THEN
        SELECT Balance INTO v_Balance
        FROM Accounts
        WHERE AccountID = :new.AccountID;
        
        IF v_Balance < :new.Amount THEN
            RAISE_APPLICATION_ERROR(-20003, 'Insufficient balance for withdrawal.');
        END IF;
    END IF;
END;
/
