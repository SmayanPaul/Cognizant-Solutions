package com.employee.management;

class Employee {
    private String employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=$" + salary +
                '}';
    }
}

public class EmployeeManagement {
    private Employee[] employees;
    private int size;
    private int capacity;

    public EmployeeManagement(int capacity) {
        this.capacity = capacity;
        this.employees = new Employee[capacity];
        this.size = 0;
    }

    public boolean add(Employee employee) {
        if (size >= capacity) {
            System.out.println("  Error: Array is full. Cannot add employee " + employee.getName());
            return false;
        }
        employees[size] = employee;
        size++;
        return true;
    }

    public Employee search(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equalsIgnoreCase(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverse() {
        if (size == 0) {
            System.out.println("  No employees found.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println("  " + employees[i]);
        }
    }

    public boolean delete(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equalsIgnoreCase(employeeId)) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        EmployeeManagement em = new EmployeeManagement(5);

        System.out.println("==================================================================");
        System.out.println("                   Employee Management System                     ");
        System.out.println("==================================================================");

        System.out.println("\nAdding employees...");
        em.add(new Employee("E001", "Alice Smith", "Software Engineer", 85000.00));
        em.add(new Employee("E002", "Bob Johnson", "Project Manager", 95000.00));
        em.add(new Employee("E003", "Charlie Brown", "QA Analyst", 65000.00));
        em.add(new Employee("E004", "Diana Prince", "Director", 150000.00));
        em.traverse();

        System.out.println("\nSearching for Employee E002...");
        Employee found = em.search("E002");
        System.out.println(found != null ? "  Found: " + found : "  Employee not found.");

        System.out.println("\nSearching for non-existent Employee E009...");
        Employee notFound = em.search("E009");
        System.out.println(notFound != null ? "  Found: " + notFound : "  Employee not found.");

        System.out.println("\nDeleting Employee E002...");
        boolean deleted = em.delete("E002");
        System.out.println(deleted ? "  Deletion successful." : "  Employee not found.");
        em.traverse();

        System.out.println("\nAttempting to delete non-existent Employee E002 again...");
        boolean deleteFailed = em.delete("E002");
        System.out.println(deleteFailed ? "  Deletion successful." : "  Employee not found (already deleted).");

        System.out.println("\nAdding two more employees (E005 and E006) to test capacity...");
        em.add(new Employee("E005", "Evan Wright", "UX Designer", 75000.00));
        em.add(new Employee("E006", "Fiona Gallagher", "HR Generalist", 60000.00));
        em.traverse();
        System.out.println("==================================================================");
    }
}
