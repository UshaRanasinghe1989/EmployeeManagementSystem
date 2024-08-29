package edu.icet.emp.controller;

import edu.icet.emp.dto.Department;
import edu.icet.emp.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService service;

    @PostMapping()
    public void persist(@RequestBody Department department){
       service.persist(department);
    }

    @GetMapping()
    public List<Department> retrieve(){
        return service.retrieve();
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        return service.delete(id);
    }
}
