package com.slmanju.hrms.employee.view;

import com.slmanju.hrms.employee.model.JobPosition;
import com.slmanju.hrms.employee.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class EmployeeView {

    private String id;
    @NotEmpty(message = "First name is required")
    private String firstName;
    @NotEmpty(message = "Last name is required")
    private String lastName;
    @Email(message = "Valid email is required")
    private String email;
    private JobPosition jobPosition;
    private Role role;

}
