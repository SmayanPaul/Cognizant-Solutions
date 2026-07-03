package com.employee.EmployeeManagementSystem.service;

import com.employee.EmployeeManagementSystem.entity.Employee;
import com.employee.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.employee.EmployeeManagementSystem.exception.EmployeeNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

public Employee getEmployeeById(Long id) {
    return employeeRepository.findById(id)
            .orElseThrow(() ->
                    new EmployeeNotFoundException("Employee with ID " + id + " not found"));
}

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

public Employee updateEmployee(Long id, Employee employee) {

    Employee existing = employeeRepository.findById(id)
            .orElseThrow(() ->
                    new EmployeeNotFoundException("Employee with ID " + id + " not found"));

    existing.setName(employee.getName());
    existing.setEmail(employee.getEmail());
    existing.setDepartment(employee.getDepartment());

    return employeeRepository.save(existing);
}

public void deleteEmployee(Long id) {

    if (!employeeRepository.existsById(id)) {
        throw new EmployeeNotFoundException(
                "Employee with ID " + id + " not found");
    }

    employeeRepository.deleteById(id);
}
    public List<Employee> getEmployeesByName(String name) {
    return employeeRepository.findByName(name);
}

public List<Employee> getEmployeesByDepartment(String department) {
    return employeeRepository.findByDepartmentName(department);
}

public List<Employee> searchEmployeeEmail(String email) {
    return employeeRepository.searchByEmail(email);
}
public Page<Employee> getEmployees(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return employeeRepository.findAll(pageable);
}

public Page<Employee> getEmployeesSorted(int page, int size, String field) {
    Pageable pageable =
            PageRequest.of(page, size, Sort.by(field));

    return employeeRepository.findAll(pageable);
}

}