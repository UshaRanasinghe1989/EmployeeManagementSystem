package edu.icet.emp.service.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.emp.dto.Employee;
import edu.icet.emp.entity.EmployeeEntity;
import edu.icet.emp.repository.EmployeeRepository;
import edu.icet.emp.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    Iterable<EmployeeEntity> list = new ArrayList<>();

    final EmployeeRepository repository;
    final ObjectMapper mapper;
    @Override
    public Employee persist(Employee dto) {
        EmployeeEntity savedEmployee = mapper.convertValue(dto, EmployeeEntity.class);
        return mapper.convertValue(savedEmployee, Employee.class);
    }

    @Override
    public List<Employee> retrieveAll() {
        List<Employee> employeeList = new ArrayList<>();
        Iterable<EmployeeEntity> iterable = repository.findAll();
        iterable.forEach(employeeEntity -> {
            Employee employee = mapper.convertValue(employeeEntity, Employee.class);
            employeeList.add(employee);
        });
        return employeeList;
    }
}