# Exercise 4: Employee Management System

This folder contains the implementation and analysis of a custom Employee Management System that utilizes a fixed-size array to store employee records.

## Deliverables in this Folder

1. **`src/com/employee/management/EmployeeManagement.java`**: A single, clean Java source file (with all comments removed) implementing:
   - `Employee` class with attributes `employeeId`, `name`, `position`, and `salary`.
   - `EmployeeManagement` class managing the array and implementing add, search, traverse, and delete operations.
   - `main` class demonstrating operations and tracking array limits.
2. **`Exercise 4 Employee Management System Answers.docx`**: A professionally formatted Microsoft Word document containing detailed answers and analysis for each of the 4 steps of the task.
3. **`output.txt`**: Redirected program console output of the execution.
4. **`README.md`**: This summary and overview documentation.

---

## 1. Understanding Array Representation (Step 1)

### Array in Memory
An array is represented in memory as a contiguous block of cells. Because cells are stored consecutively, any element's memory address can be determined in constant time using its index:
$$\text{Address}(\text{Index}) = \text{BaseAddress} + \text{Index} \times \text{ElementSize}$$

### Advantages
1. **Constant-Time Access ($O(1)$):** Immediate access using elements' indices.
2. **Memory Efficiency:** Contiguous allocation minimizes structural overhead compared to node-based list pointers.
3. **Cache Friendliness:** Contiguous layout aligns with CPU pre-fetching (spatial locality).

---

## 2. Complexity Analysis & Limitations (Step 4)

### Complexity Table
- **Add Element:** $O(1)$ average (appending at the end)
- **Search Element:** $O(N)$ (requires traversing from index $0$ to $size-1$)
- **Traverse:** $O(N)$ (iterates through active elements)
- **Delete Element:** $O(N)$ (requires matching the element and shifting remaining items to fill the gap)

### Limitations of Arrays
1. **Fixed Size:** The size cannot be dynamically adjusted once declared. If the database expands beyond capacity, additional entries are blocked.
2. **Shifting Costs:** Deleting or inserting elements at arbitrary positions requires shifting elements left or right, generating $O(N)$ computational overhead.

---

## 3. Running the Program

### Compilation
Navigate to this folder and run:
```bash
javac -d bin src/com/employee/management/EmployeeManagement.java
```

### Execution
Run the compiled main program:
```bash
java -cp bin com.employee.management.EmployeeManagement
```
