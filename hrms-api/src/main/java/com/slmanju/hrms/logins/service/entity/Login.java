package com.slmanju.hrms.logins.service.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Data
@Entity
@Table(name = "tbl_login")
public class Login {

  @GeneratedValue
  @Id
  private Integer id;

  private String username;

  private String password;

  @OneToOne
  @JoinColumn(name = "role")
  private Role role;

}
