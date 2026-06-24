CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_EmployeeID IN NUMBER,
    p_Percentage IN NUMBER
) AS
    v_Salary NUMBER;
BEGIN
    SELECT Salary INTO v_Salary
    FROM Employees
    WHERE EmployeeID = p_EmployeeID
    FOR UPDATE;
    
    UPDATE Employees
    SET Salary = Salary * (1 + p_Percentage / 100)
    WHERE EmployeeID = p_EmployeeID;
    
    COMMIT;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: Employee with ID ' || p_EmployeeID || ' does not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Failed to update salary. ' || SQLERRM);
END;
/
