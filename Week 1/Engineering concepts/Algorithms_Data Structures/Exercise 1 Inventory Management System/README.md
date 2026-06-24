# Exercise 1: Inventory Management System

This folder contains the implementation and analysis of the Inventory Management System, comparing different data structures for managing items in a warehouse.

## Deliverables in this Folder

1. **`src/com/inventory/InventoryManagement.java`**: A single, clean Java source file (with all comments removed) implementing:
   - `Product` class with `productId`, `productName`, `quantity`, and `price`.
   - `InventoryManagement` class utilizing a `HashMap` for $O(1)$ operations.
   - `main` class execution demonstrating adding, updating, and deleting products.
2. **`Exercise 1 Inventory Management System Answers.docx`**: A professionally formatted Microsoft Word document containing detailed answers and analysis for each of the 4 steps of the task.
3. **`output.txt`**: Redirected program console output of the execution.
4. **`README.md`**: This summary and overview documentation.

---

## 1. Understanding the Problem (Step 1)

### Need for Data Structures and Algorithms
In an inventory system storing hundreds of thousands of items, simple linear searches through unsorted arrays or lists are extremely slow ($O(N)$). Having optimal data structures (like a `HashMap`) reduces search, update, and deletion times to constant time ($O(1)$), ensuring the system remains responsive as the inventory grows.

### Suitable Data Structures
- **ArrayList:** Good for random access by index ($O(1)$), but searching for a specific product ID requires a full scan ($O(N)$). Inserting or deleting items requires shifting elements, which takes $O(N)$ time.
- **LinkedList:** Easy insertion and deletion of nodes, but lookup still requires traversing elements sequentially ($O(N)$).
- **HashMap:** Highly suitable. Maps the `productId` to the `Product` object. Allows insertion, retrieval, and deletion in $O(1)$ average time complexity.

---

## 2. Complexity Analysis & Optimization (Step 4)

### Time Complexity (HashMap)
- **Add Product:** $O(1)$ average
- **Update Product:** $O(1)$ average
- **Delete Product:** $O(1)$ average

### Optimization Discussion
- **Initial Capacity & Load Factor:** Correctly sizing the hash map avoids costly resize/rehash operations as the inventory database grows.
- **Collision Reduction:** Utilizing unique product IDs with high-quality hash codes distributes entries evenly, preventing performance from degrading to $O(N)$ in the worst-case scenario.

---

## 3. Running the Program

### Compilation
Navigate to this folder and run:
```bash
javac -d bin src/com/inventory/InventoryManagement.java
```

### Execution
Run the compiled main program:
```bash
java -cp bin com.inventory.InventoryManagement
```
