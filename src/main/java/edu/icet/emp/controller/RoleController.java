package edu.icet.emp.controller;

import edu.icet.emp.dto.Role;
import edu.icet.emp.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService service;

    @PostMapping("")
    public void persist(@RequestBody Role role){
        service.addRole(role);
    }

    @GetMapping
    public List<Role> retrieve(){
        return service.retrieve();
    }
}
