# Exercise 2: E-commerce Platform Search Function

This folder contains the implementation and analysis of the E-commerce Platform Search Function, which compares the performance of **Linear Search** and **Binary Search**.

## Deliverables in this Folder

1. **`src/com/ecommerce/search/ECommerceSearch.java`**: A single, clean Java source file (with all comments removed) implementing:
   - `Product` class with `productId`, `productName`, and `category` fields.
   - `linearSearch` and `binarySearch` algorithms.
   - `main` class executing tests and measuring high-precision runtime performance.
2. **`Exercise 2 E-commerce Platform Search Function Answers.docx`**: A professionally formatted Microsoft Word document containing answers and detailed analysis for each of the 4 steps of the task.
3. **`output.txt`**: Redirected program console output of the search test.
4. **`output_screenshot.png`**: High-quality terminal execution screenshot showcasing search results and timing comparison.

---

## 1. Understanding Asymptotic Notation (Step 1)

### Big O Notation
**Big O Notation** is a mathematical notation used to describe the upper bound of an algorithm's running time or space complexity in terms of the input size ($N$). It helps developers analyze the efficiency of algorithms and predict how their performance scales as data volume grows, independent of hardware or environmental factors.

### Search Operation Scenarios

1. **Linear Search:**
   - **Best Case ($O(1)$):** The target element is located at the first index.
   - **Average Case ($O(N)$):** The target element is somewhere in the middle.
   - **Worst Case ($O(N)$):** The target element is at the last index or not present.

2. **Binary Search:**
   - **Best Case ($O(1)$):** The target element is at the middle index on the first check.
   - **Average Case ($O(\log N)$):** The search space is halved repeatedly.
   - **Worst Case ($O(\log N)$):** The search space is reduced to 1 or the element is not present.

---

## 2. Complexity Analysis & Comparison (Step 4)

| Algorithm | Time Complexity (Best Case) | Time Complexity (Average Case) | Time Complexity (Worst Case) | Space Complexity |
| :--- | :---: | :---: | :---: | :---: |
| **Linear Search** | $O(1)$ | $O(N)$ | $O(N)$ | $O(1)$ |
| **Binary Search** | $O(1)$ | $O(\log N)$ | $O(\log N)$ | $O(1)$ |

### Suitability Discussion
- **Linear Search** is simple and has zero setup cost. It is only suitable for small, unsorted datasets.
- **Binary Search** is far superior for larger datasets but requires the array to be sorted first.
- **E-commerce Platform Recommendation:** For a catalog with thousands or millions of items, **Binary Search** is highly recommended. It avoids linear growth of search times and keeps response times below milliseconds, ensuring a fluid customer experience.

---

## 3. Running the Program

### Compilation
Navigate to this folder and run:
```bash
javac -d bin src/com/ecommerce/search/ECommerceSearch.java
```

### Execution
Run the compiled main program:
```bash
java -cp bin com.ecommerce.search.ECommerceSearch
```

---

## 4. Execution Output Screenshot
![Program Execution Output](output_screenshot.png)
