package edu.icet.emp.employeecontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.emp.dto.Employee;
import edu.icet.emp.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp-controller")
@RequiredArgsConstructor
public class EmployeeController {
    final EmployeeService employeeService;
    final ObjectMapper mapper;

    @PostMapping("add-employee")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee persist(@RequestBody Employee employee){
        return employeeService.persist(employee);
    }

    @GetMapping("get-all")
    public List<Employee> getAll(){
        return employeeService.retrieveAll();
    }

    @PostMapping("/update-employee")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateEmployee(@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping("delete-emp/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteEmployee(@PathVariable Long id){
        employeeService.deleteById(id);
        return "Deleted";
    }

    @GetMapping("/find-by-firstName/{firstName}")
    public Employee findByFirstName(@PathVariable String firstName){
        return employeeService.findByFirstName(firstName);
    }
}
