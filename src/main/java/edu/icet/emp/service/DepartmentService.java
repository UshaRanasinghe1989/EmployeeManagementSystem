package edu.icet.emp.service;

import edu.icet.emp.dto.Department;

import java.util.List;

public interface DepartmentService {
    void persist(Department department);

    List<Department> retrieve();

    boolean delete(Long id);
}
