package edu.icet.emp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int depId;
    private int roleId;
}
