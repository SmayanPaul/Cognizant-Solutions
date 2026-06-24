CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_LoanAmount IN NUMBER,
    p_InterestRate IN NUMBER,
    p_DurationYears IN NUMBER
) RETURN NUMBER AS
    v_MonthlyRate NUMBER;
    v_TotalPayments NUMBER;
    v_Installment NUMBER;
BEGIN
    v_MonthlyRate := p_InterestRate / 12 / 100;
    v_TotalPayments := p_DurationYears * 12;
    
    IF v_MonthlyRate = 0 THEN
        v_Installment := p_LoanAmount / v_TotalPayments;
    ELSE
        v_Installment := p_LoanAmount * v_MonthlyRate * POWER(1 + v_MonthlyRate, v_TotalPayments) / (POWER(1 + v_MonthlyRate, v_TotalPayments) - 1);
    END IF;
    
    RETURN ROUND(v_Installment, 2);
END;
/
