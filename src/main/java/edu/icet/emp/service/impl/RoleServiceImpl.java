package edu.icet.emp.service.impl;

import edu.icet.emp.dto.Role;
import edu.icet.emp.entity.RoleEntity;
import edu.icet.emp.repository.RoleRepository;
import edu.icet.emp.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;
    private final ModelMapper mapper;
    @Override
    public void addRole(Role role) {
        repository.save(mapper.map(role, RoleEntity.class));
    }

    @Override
    public List<Role> retrieve() {
        List<Role> roleList = new ArrayList<>();
        repository.findAll().forEach(obj -> {
            roleList.add(mapper.map(obj, Role.class));
        });
        return roleList;
    }
}
