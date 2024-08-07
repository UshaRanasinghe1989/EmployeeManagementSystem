package edu.icet.emp.service.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.emp.dto.Employee;
import edu.icet.emp.entity.EmployeeEntity;
import edu.icet.emp.repository.EmployeeRepository;
import edu.icet.emp.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    final EmployeeRepository repository;
    final ObjectMapper mapper;
    @Override
    public Employee persist(Employee dto) {
        EmployeeEntity entity = mapper.convertValue(dto, EmployeeEntity.class);
        return mapper.convertValue(repository.save(entity), Employee.class);
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

    @Override
    public void deleteById(Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        if (repository.findById((long) employee.getId()).isPresent()){
            repository.save(mapper.convertValue(employee, EmployeeEntity.class));
        }
    }

    @Override
    public Employee findById(Long id) {
        return mapper.convertValue(repository.findById(id), Employee.class);
    }

    @Override
    public Employee findByFirstName(String firstName) {
        return new ObjectMapper().convertValue(repository.findByFirstName(firstName), Employee.class);
    }
}
