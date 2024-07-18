package edu.icet.emp.repository;

import edu.icet.emp.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    EmployeeEntity findByFirstName(String firstName);
}
