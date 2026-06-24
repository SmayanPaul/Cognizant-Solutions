# Exercise 5: Task Management System

This folder contains the implementation and analysis of a custom Task Management System using a **Singly Linked List** to handle task records dynamically.

## Deliverables in this Folder

1. **`src/com/task/management/TaskManagement.java`**: A single, clean Java source file (with all comments removed) implementing:
   - `Task` class with `taskId`, `taskName`, and `status`.
   - `Node` helper class wrapping the `Task` and pointer references.
   - `TaskManagement` class managing the linked list, supporting add, search, traverse, and delete operations.
   - `main` class demonstrating operations and pointer updates.
2. **`Exercise 5 Task Management System Answers.docx`**: A professionally formatted Microsoft Word document containing detailed answers and analysis for each of the 4 steps of the task.
3. **`output.txt`**: Redirected program console output of the execution.
4. **`README.md`**: This summary and overview documentation.

---

## 1. Understanding Linked Lists (Step 1)

### Linked List Concept
A linked list is a linear data structure where elements (nodes) are stored dynamically in heap memory and linked together via references/pointers rather than contiguous blocks.

### Types of Linked Lists
1. **Singly Linked List:** Nodes link in a single direction (forward) via a `next` reference.
2. **Doubly Linked List:** Nodes contain both `next` and `prev` pointers, allowing bi-directional traversal.
3. **Circular Linked List:** The tail node links back to the head node, forming a continuous ring.

---

## 2. Complexity Analysis & Advantages (Step 4)

### Complexity Table
- **Add Task (to end):** $O(N)$ (requires traversing to the tail; optimized to $O(1)$ if keeping a tail reference)
- **Search Task:** $O(N)$ (requires sequential traversal)
- **Traverse Tasks:** $O(N)$ (visits all nodes)
- **Delete Task:** $O(N)$ (requires locating the element; the unlink step itself is $O(1)$)

### Advantages of Linked Lists over Arrays
1. **Dynamic Size:** Can grow or shrink dynamically without needing resize/copy steps.
2. **In-place Insertion/Deletion:** Inserting or deleting a node requires only updating references ($O(1)$ once located), avoiding array shifting costs.
3. **Memory Allocation:** Memory is allocated on-demand, preventing waste from unused contiguous blocks.

---

## 3. Running the Program

### Compilation
Navigate to this folder and run:
```bash
javac -d bin src/com/task/management/TaskManagement.java
```

### Execution
Run the compiled main program:
```bash
java -cp bin com.task.management.TaskManagement
```
