# Exercise 7: Financial Forecasting

This folder contains the implementation and analysis of a Financial Forecasting tool that uses **Recursive Algorithms** to predict future asset values based on past growth rates.

## Deliverables in this Folder

1. **`src/com/financial/forecasting/FinancialForecasting.java`**: A single, clean Java source file (with all comments removed) implementing:
   - Basic Recursive method to calculate future values.
   - Memoized (Optimized) Recursive method to calculate future values.
   - Iterative method to compare time and space complexities.
   - `main` class execution demonstrating correctness and execution times.
2. **`Exercise 7 Financial Forecasting Answers.docx`**: A professionally formatted Microsoft Word document containing detailed answers and analysis for each of the 4 steps of the task.
3. **`output.txt`**: Redirected program console output of the forecasting demonstration.
4. **`README.md`**: This summary and overview documentation.

---

## 1. Understanding Recursive Algorithms (Step 1)

### Recursion Concept
**Recursion** is a programming technique where a method calls itself directly or indirectly to solve a problem. It works by breaking down a complex problem into smaller sub-problems of the same nature until it reaches a base condition that can be solved directly without recursion.

### Core Components
Every recursive algorithm consists of:
1. **Base Case:** The condition under which the function returns a value immediately without making another recursive call. This prevents infinite call loops and Stack Overflow errors.
2. **Recursive Case:** The block of code where the function calls itself with modified parameters that progressively move closer to the base case.

---

## 2. Implementation & Analysis (Steps 3 & 4)

### Recursive Logic
- **Base Case:** If the forecasting period is $0$ years, return the present value ($FV = PV$).
- **Recursive Step:** Calculate the future value for $t-1$ periods, then multiply it by $(1 + GrowthRate)$ to get the value for $t$ periods.
- **Formula:** 
  $$FV(t) = FV(t-1) \times (1 + GrowthRate)$$

### Complexity
- **Basic Recursive:**
  - **Time Complexity:** $O(N)$ where $N$ is the number of periods/years. There are exactly $N$ linear recursive steps.
  - **Space Complexity:** $O(N)$ due to the call stack depth holding active function contexts.
- **Optimized Iterative:**
  - **Time Complexity:** $O(N)$
  - **Space Complexity:** $O(1)$ (no recursion stack overhead).

### Optimization Strategies
1. **Memoization:** Caching previously calculated values in a data structure (e.g. Map/Array) to avoid re-evaluating sub-problems. Highly effective in branching recursion.
2. **Iterative Approach:** Converting the recursion to a loop (e.g. `for` or `while` loop) to eliminate the $O(N)$ space complexity of the system call stack, which prevents `StackOverflowError` for very large periods.

---

## 3. Running the Program

### Compilation
Navigate to this folder and run:
```bash
javac -d bin src/com/financial/forecasting/FinancialForecasting.java
```

### Execution
Run the compiled main program:
```bash
java -cp bin com.financial.forecasting.FinancialForecasting
```
