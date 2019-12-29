package com.slmanju.hrms.logins.service.transfer.dto;

import lombok.Data;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Data
public class LoginDto {

  private Integer id;

  private String username;

  private String password;

  private Integer roleId;

}
