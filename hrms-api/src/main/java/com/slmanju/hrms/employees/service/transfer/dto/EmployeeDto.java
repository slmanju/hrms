package com.slmanju.hrms.employees.service.transfer.dto;

import com.slmanju.hrms.employees.service.transfer.types.EmployeeType;
import com.slmanju.hrms.employees.service.transfer.types.Gender;
import com.slmanju.hrms.logins.service.transfer.dto.LoginDto;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Data
public class EmployeeDto {

  private Integer id;

  private String firstName;

  private String lastName;

  private Gender gender;

  private LocalDate dateOfBirth;

  private EmployeeType employeeType;

  private String mobile;

  private String email;

  private LoginDto login;

}
