package com.employee.EmployeeManagementSystem.controller;

import com.employee.EmployeeManagementSystem.entity.Employee;
import com.employee.EmployeeManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import java.util.List;
import java.util.Optional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

@PostMapping
public Employee addEmployee(@Valid @RequestBody Employee employee) {
    return employeeService.saveEmployee(employee);
}

@PutMapping("/{id}")
public Employee updateEmployee(@PathVariable Long id,
                               @RequestBody Employee employee) {
    return employeeService.updateEmployee(id, employee);
}

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
    @GetMapping("/name/{name}")
public List<Employee> getByName(@PathVariable String name) {
    return employeeService.getEmployeesByName(name);
}

@GetMapping("/department/{name}")
public List<Employee> getByDepartment(@PathVariable String name) {
    return employeeService.getEmployeesByDepartment(name);
}

@GetMapping("/email/{email}")
public List<Employee> searchEmail(@PathVariable String email) {
    return employeeService.searchEmployeeEmail(email);
}
@GetMapping("/page")
public Page<Employee> getEmployees(
        @RequestParam int page,
        @RequestParam int size) {

    return employeeService.getEmployees(page, size);
}

@GetMapping("/sort")
public Page<Employee> getSortedEmployees(
        @RequestParam int page,
        @RequestParam int size,
        @RequestParam String field) {

    return employeeService.getEmployeesSorted(page, size, field);
}
}