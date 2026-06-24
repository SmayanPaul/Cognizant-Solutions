# Exercise 3: Sorting Customer Orders

This folder contains the implementation and analysis of Sorting Customer Orders on an e-commerce platform by their total price, comparing the efficiency of **Bubble Sort** and **Quick Sort**.

## Deliverables in this Folder

1. **`src/com/order/sorting/SortingOrders.java`**: A single, clean Java source file (with all comments removed) implementing:
   - `Order` class with `orderId`, `customerName`, and `totalPrice`.
   - `bubbleSort` and `quickSort` algorithms.
   - `main` class execution demonstrating sorting and measuring execution times.
2. **`Exercise 3 Sorting Customer Orders Answers.docx`**: A professionally formatted Microsoft Word document containing detailed answers and analysis for each of the 4 steps of the task.
3. **`output.txt`**: Redirected program console output of the sorting demonstration.
4. **`README.md`**: This summary and overview documentation.

---

## 1. Understanding Sorting Algorithms (Step 1)

### Sorting Algorithms Explanation
- **Bubble Sort:** A simple sorting algorithm that works by repeatedly swapping adjacent elements if they are in the wrong order. It is inefficient for large lists.
- **Insertion Sort:** Iteratively inserts elements into their correct position. Highly efficient for small or nearly sorted arrays.
- **Quick Sort:** A divide-and-conquer sorting algorithm that selects a 'pivot' and partitions the array around it, then recursively sorts the sub-arrays. It is an in-place sort with high cache efficiency.
- **Merge Sort:** Divides the array in half, sorts each half recursively, and merges them. It is stable and always runs in $O(N \log N)$ but requires extra space.

---

## 2. Complexity Analysis & Comparison (Step 4)

| Algorithm | Best Case | Average Case | Worst Case | Space Complexity |
| :--- | :---: | :---: | :---: | :---: |
| **Bubble Sort** | $O(N)$ | $O(N^2)$ | $O(N^2)$ | $O(1)$ |
| **Quick Sort** | $O(N \log N)$ | $O(N \log N)$ | $O(N^2)$ | $O(\log N)$ |

### Why Quick Sort is Preferred
1. **Time Complexity:** Quick Sort operates in $O(N \log N)$ average-case time, which is substantially faster than Bubble Sort's $O(N^2)$ comparisons for any non-trivial dataset.
2. **Cache Locality & Space:** Quick Sort is an in-place algorithm that has excellent cache locality, consuming very little auxiliary memory ($O(\log N)$ space on call stack) compared to Merge Sort ($O(N)$ auxiliary space).

---

## 3. Running the Program

### Compilation
Navigate to this folder and run:
```bash
javac -d bin src/com/order/sorting/SortingOrders.java
```

### Execution
Run the compiled main program:
```bash
java -cp bin com.order.sorting.SortingOrders
```
