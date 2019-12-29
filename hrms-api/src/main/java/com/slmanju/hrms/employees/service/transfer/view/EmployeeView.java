package com.slmanju.hrms.employees.service.transfer.view;

import com.slmanju.hrms.employees.service.transfer.types.EmployeeType;
import com.slmanju.hrms.employees.service.transfer.types.Gender;
import com.slmanju.hrms.logins.service.transfer.view.LoginView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class EmployeeView {

  private Integer id;

  private String firstName;

  private String lastName;

  private Gender gender;

  private LocalDate dateOfBirth;

  private EmployeeType employeeType;

  private String mobile;

  private String email;

  private LoginView login;

}
