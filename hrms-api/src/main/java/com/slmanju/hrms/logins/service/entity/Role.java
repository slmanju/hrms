package com.slmanju.hrms.logins.service.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Data
@Entity
@Table(name = "tbl_role")
public class Role {

  @GeneratedValue
  @Id
  private Integer id;

  private String code;

  private String name;

  private String description;

}
