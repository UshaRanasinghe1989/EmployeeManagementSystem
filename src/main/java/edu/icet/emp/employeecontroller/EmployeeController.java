package edu.icet.emp.employeecontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.emp.dto.Employee;
import edu.icet.emp.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp-controller")
@RequiredArgsConstructor
public class EmployeeController {
    final EmployeeService employeeService;
    final ObjectMapper mapper;

    @PostMapping("add-employee")
    public Employee persist(@RequestBody Employee employee){
        return employeeService.persist(employee);
    }

    @GetMapping("get-all")
    public List<Employee> getAll(){
        return employeeService.retrieveAll();
    }
}
