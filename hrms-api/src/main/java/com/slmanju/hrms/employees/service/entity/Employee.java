package com.slmanju.hrms.employees.service.entity;

import com.slmanju.hrms.employees.service.transfer.types.EmployeeType;
import com.slmanju.hrms.employees.service.transfer.types.Gender;
import com.slmanju.hrms.logins.service.entity.Login;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Data
@Entity
@Table(name = "tbl_employee")
public class Employee {

  @GeneratedValue
  @Id
  private Integer id;

  private String firstName;

  private String lastName;

  private Gender gender;

  private LocalDate dateOfBirth;

  private EmployeeType employeeType;

  private String mobile;

  private String email;

  @OneToOne
  @JoinColumn(name = "login_id")
  private Login login;

}
