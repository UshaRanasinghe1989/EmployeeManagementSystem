package edu.icet.emp.service;

import edu.icet.emp.dto.Role;

import java.util.List;

public interface RoleService {
    void addRole(Role role);

    List<Role> retrieve();

    boolean delete(Long id);
}
