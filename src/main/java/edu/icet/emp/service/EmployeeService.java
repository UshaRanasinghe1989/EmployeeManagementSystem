package edu.icet.emp.service;

import edu.icet.emp.dto.Employee;

import java.util.List;

public interface EmployeeService {
    Employee persist(Employee dto);
    List<Employee> retrieveAll();

    void deleteById(Long id);

    void updateEmployee(Employee employee);
    Employee findById(Long id);
    Employee findByFirstName(String firstName);
}
