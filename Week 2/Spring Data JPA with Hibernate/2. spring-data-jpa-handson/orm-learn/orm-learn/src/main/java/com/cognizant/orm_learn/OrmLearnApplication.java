package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.model.Skill;
import com.cognizant.orm_learn.service.DepartmentService;
import com.cognizant.orm_learn.service.EmployeeService;
import com.cognizant.orm_learn.service.SkillService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(OrmLearnApplication.class, args);

        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);

        testGetEmployee();

        // Uncomment this after testing the above
        // testAddSkillToEmployee();
    }

    private static void testGetEmployee() {

        Employee employee = employeeService.get(1);

        System.out.println("Employee:");
        System.out.println(employee);

        System.out.println();

        System.out.println("Department:");
        System.out.println(employee.getDepartment());

        System.out.println();

        System.out.println("Skills:");
        employee.getSkillList().forEach(System.out::println);
    }

    private static void testAddSkillToEmployee() {

        Employee employee = employeeService.get(3);

        Skill skill = skillService.get(1);

        employee.getSkillList().add(skill);

        employeeService.save(employee);

        System.out.println("Skill Added Successfully!");
    }
}