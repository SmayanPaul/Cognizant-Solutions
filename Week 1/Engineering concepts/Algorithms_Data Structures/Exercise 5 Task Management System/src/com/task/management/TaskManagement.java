package com.task.management;

class Task {
    private String taskId;
    private String taskName;
    private String status;

    public Task(String taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId='" + taskId + '\'' +
                ", taskName='" + taskName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class TaskManagement {
    private Node head;

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public Task searchTask(String taskId) {
        Node temp = head;
        while (temp != null) {
            if (temp.task.getTaskId().equalsIgnoreCase(taskId)) {
                return temp.task;
            }
            temp = temp.next;
        }
        return null;
    }

    public void traverseTasks() {
        if (head == null) {
            System.out.println("  No tasks found.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.println("  " + temp.task);
            temp = temp.next;
        }
    }

    public boolean deleteTask(String taskId) {
        if (head == null) {
            return false;
        }
        if (head.task.getTaskId().equalsIgnoreCase(taskId)) {
            head = head.next;
            return true;
        }
        Node current = head;
        Node prev = null;
        while (current != null && !current.task.getTaskId().equalsIgnoreCase(taskId)) {
            prev = current;
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        prev.next = current.next;
        return true;
    }

    public static void main(String[] args) {
        TaskManagement tm = new TaskManagement();

        System.out.println("==================================================================");
        System.out.println("                     Task Management System                       ");
        System.out.println("==================================================================");

        System.out.println("\nAdding tasks...");
        tm.addTask(new Task("T001", "Design Database Schema", "Done"));
        tm.addTask(new Task("T002", "Implement Authentication API", "In Progress"));
        tm.addTask(new Task("T003", "Write Unit Tests", "Pending"));
        tm.addTask(new Task("T004", "Setup CI/CD Pipeline", "Pending"));
        tm.traverseTasks();

        System.out.println("\nSearching for Task T002...");
        Task found = tm.searchTask("T002");
        System.out.println(found != null ? "  Found: " + found : "  Task not found.");

        System.out.println("\nSearching for non-existent Task T009...");
        Task notFound = tm.searchTask("T009");
        System.out.println(notFound != null ? "  Found: " + notFound : "  Task not found.");

        System.out.println("\nDeleting Task T002...");
        boolean deleted = tm.deleteTask("T002");
        System.out.println(deleted ? "  Deletion successful." : "  Task not found.");
        tm.traverseTasks();

        System.out.println("\nAttempting to delete non-existent Task T002 again...");
        boolean deleteFailed = tm.deleteTask("T002");
        System.out.println(deleteFailed ? "  Deletion successful." : "  Task not found (already deleted).");
        System.out.println("==================================================================");
    }
}
