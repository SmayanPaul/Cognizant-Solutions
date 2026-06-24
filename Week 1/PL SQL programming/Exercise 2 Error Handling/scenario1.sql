CREATE OR REPLACE PROCEDURE SafeTransferFunds (
    p_SourceAccountID IN NUMBER,
    p_DestAccountID IN NUMBER,
    p_Amount IN NUMBER
) AS
    v_SourceBalance NUMBER;
    insufficient_funds EXCEPTION;
BEGIN
    SELECT Balance INTO v_SourceBalance
    FROM Accounts
    WHERE AccountID = p_SourceAccountID
    FOR UPDATE;
    
    IF v_SourceBalance < p_Amount THEN
        RAISE insufficient_funds;
    END IF;
    
    UPDATE Accounts
    SET Balance = Balance - p_Amount
    WHERE AccountID = p_SourceAccountID;
    
    UPDATE Accounts
    SET Balance = Balance + p_Amount
    WHERE AccountID = p_DestAccountID;
    
    COMMIT;
EXCEPTION
    WHEN insufficient_funds THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds in account ' || p_SourceAccountID);
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: One or both accounts do not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Transfer failed. ' || SQLERRM);
END;
/
