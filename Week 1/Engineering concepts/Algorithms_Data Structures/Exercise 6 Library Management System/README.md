# Exercise 6: Library Management System

This folder contains the implementation and analysis of the Library Management System, comparing **Linear Search** and **Binary Search** for finding books by their title.

## Deliverables in this Folder

1. **`src/com/library/management/LibraryManagement.java`**: A single, clean Java source file (with all comments removed) implementing:
   - `Book` class with `bookId`, `title`, and `author` attributes.
   - `linearSearch` and `binarySearch` algorithms.
   - `main` class execution demonstrating book lookup and measuring execution times.
2. **`Exercise 6 Library Management System Answers.docx`**: A professionally formatted Microsoft Word document containing detailed answers and analysis for each of the 4 steps of the task.
3. **`output.txt`**: Redirected program console output of the execution.
4. **`README.md`**: This summary and overview documentation.

---

## 1. Understanding Search Algorithms (Step 1)

### Linear Search
Linear search iterates sequentially through each element of a collection until it finds the target. It does not require data to be sorted, making it ideal for small, unsorted, or rapidly changing collections.

### Binary Search
Binary search repeatedly divides a sorted collection's search space in half by comparing the middle element to the target. This provides much faster lookups ($O(\log N)$) but requires the collection to remain sorted.

---

## 2. Complexity Analysis & Usage (Step 4)

### Complexity Table
- **Linear Search:** $O(N)$ average/worst-case time complexity.
- **Binary Search:** $O(\log N)$ average/worst-case time complexity.

### Discussion: When to Use Which
- **Linear Search:** Use for small datasets (e.g. less than 50 elements) or unsorted lists where sorting overhead is not justified.
- **Binary Search:** Crucial for large, relatively static datasets (e.g. library catalogs with thousands of books) where lookups are frequent and sorting can be performed once in advance.

---

## 3. Running the Program

### Compilation
Navigate to this folder and run:
```bash
javac -d bin src/com/library/management/LibraryManagement.java
```

### Execution
Run the compiled main program:
```bash
java -cp bin com.library.management.LibraryManagement
```
