package edu.icet.emp.employeecontroller;

import edu.icet.emp.dto.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/emp-controller")
public class EmployeeController {
    List<Employee> list = new ArrayList<>();

    @PostMapping("add-employee")
    public boolean persist(@RequestBody Employee employee){
        return list.add(employee);
    }

    @GetMapping("get-all")
    public List<Employee> getAll(){
        return list;
    }
}
