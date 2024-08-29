package edu.icet.emp.service.impl;

import edu.icet.emp.dto.Department;
import edu.icet.emp.entity.DepartmentEntity;
import edu.icet.emp.repository.DepartmentRepository;
import edu.icet.emp.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository repository;
    private final ModelMapper mapper;
    @Override
    public void persist(Department department) {
        repository.save(mapper.map(department, DepartmentEntity.class));
    }

    @Override
    public List<Department> retrieve() {
        List<Department> departmentList = new ArrayList<>();
        repository.findAll().forEach(obj -> {
            departmentList.add(mapper.map(obj, Department.class));
        });
        return departmentList;
    }
}
