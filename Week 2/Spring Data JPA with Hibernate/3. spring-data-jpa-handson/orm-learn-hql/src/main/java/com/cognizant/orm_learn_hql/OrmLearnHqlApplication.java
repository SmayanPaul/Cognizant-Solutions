package com.cognizant.orm_learn_hql;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.orm_learn_hql.model.Employee;
import com.cognizant.orm_learn_hql.service.EmployeeService;

@SpringBootApplication
public class OrmLearnHqlApplication {

    private static EmployeeService employeeService;

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(OrmLearnHqlApplication.class, args);

        employeeService = context.getBean(EmployeeService.class);

        // Uncomment ONE test at a time

        // testGetAllPermanentEmployees();

        // testGetAllPermanentEmployeesFetch();

        // testAverageSalary();

        // testAverageSalaryByDepartment();

         testNativeQuery();
    }

    private static void testGetAllPermanentEmployees() {

        System.out.println("===== Permanent Employees =====");

        List<Employee> employees =
                employeeService.getAllPermanentEmployees();

        employees.forEach(System.out::println);
    }

    private static void testGetAllPermanentEmployeesFetch() {

        System.out.println("===== Permanent Employees (Fetch) =====");

        List<Employee> employees =
                employeeService.getAllPermanentEmployeesFetch();

        for (Employee e : employees) {

            System.out.println(e);

            System.out.println(e.getDepartment());

            System.out.println(e.getSkillList());

            System.out.println();
        }
    }

    private static void testAverageSalary() {

        System.out.println("Average Salary = "
                + employeeService.getAverageSalary());
    }

    private static void testAverageSalaryByDepartment() {

        System.out.println("Average Salary (Dept 1) = "
                + employeeService.getAverageSalary(1));
    }

    private static void testNativeQuery() {

        System.out.println("===== Native Query =====");

        employeeService
                .getAllEmployeesNative()
                .forEach(System.out::println);
    }
}