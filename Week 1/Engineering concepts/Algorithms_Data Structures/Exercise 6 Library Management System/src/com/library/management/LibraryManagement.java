package com.library.management;

import java.util.Arrays;

class Book implements Comparable<Book> {
    private String bookId;
    private String title;
    private String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int compareTo(Book other) {
        return this.title.compareToIgnoreCase(other.title);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

public class LibraryManagement {

    public static Book linearSearch(Book[] books, String title) {
        if (books == null || title == null) {
            return null;
        }
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String title) {
        if (books == null || title == null) {
            return null;
        }
        int low = 0;
        int high = books.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book("B002", "To Kill a Mockingbird", "Harper Lee"),
            new Book("B003", "1984", "George Orwell"),
            new Book("B004", "Pride and Prejudice", "Jane Austen"),
            new Book("B005", "The Catcher in the Rye", "J.D. Salinger"),
            new Book("B006", "The Hobbit", "J.R.R. Tolkien")
        };

        System.out.println("==================================================================");
        System.out.println("                     Library Management System                    ");
        System.out.println("==================================================================");

        System.out.println("\nOriginal Books list:");
        for (Book b : books) {
            System.out.println("  " + b);
        }

        Book[] sortedBooks = books.clone();
        Arrays.sort(sortedBooks);

        System.out.println("\nSorted Books list (for Binary Search):");
        for (Book b : sortedBooks) {
            System.out.println("  " + b);
        }

        String searchTitle = "1984";
        System.out.println("\n------------------------------------------------------------------");
        System.out.println("Searching for: \"" + searchTitle + "\"");
        System.out.println("------------------------------------------------------------------");

        long startTime = System.nanoTime();
        Book linearResult = linearSearch(books, searchTitle);
        long endTime = System.nanoTime();
        long linearTime = endTime - startTime;
        System.out.printf("  [Linear Search] Result: %s\n", (linearResult != null ? "FOUND -> " + linearResult : "NOT FOUND"));
        System.out.printf("  [Linear Search] Time Taken: %d ns\n\n", linearTime);

        startTime = System.nanoTime();
        Book binaryResult = binarySearch(sortedBooks, searchTitle);
        endTime = System.nanoTime();
        long binaryTime = endTime - startTime;
        System.out.printf("  [Binary Search] Result: %s\n", (binaryResult != null ? "FOUND -> " + binaryResult : "NOT FOUND"));
        System.out.printf("  [Binary Search] Time Taken: %d ns\n", binaryTime);

        String searchTitleNotFound = "Moby Dick";
        System.out.println("\n------------------------------------------------------------------");
        System.out.println("Searching for: \"" + searchTitleNotFound + "\"");
        System.out.println("------------------------------------------------------------------");

        startTime = System.nanoTime();
        Book linearResultNotFound = linearSearch(books, searchTitleNotFound);
        endTime = System.nanoTime();
        long linearTimeNotFound = endTime - startTime;
        System.out.printf("  [Linear Search] Result: %s\n", (linearResultNotFound != null ? "FOUND -> " + linearResultNotFound : "NOT FOUND"));
        System.out.printf("  [Linear Search] Time Taken: %d ns\n\n", linearTimeNotFound);

        startTime = System.nanoTime();
        Book binaryResultNotFound = binarySearch(sortedBooks, searchTitleNotFound);
        endTime = System.nanoTime();
        long binaryTimeNotFound = endTime - startTime;
        System.out.printf("  [Binary Search] Result: %s\n", (binaryResultNotFound != null ? "FOUND -> " + binaryResultNotFound : "NOT FOUND"));
        System.out.printf("  [Binary Search] Time Taken: %d ns\n", binaryTimeNotFound);
        System.out.println("==================================================================");
    }
}
