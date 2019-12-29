package com.slmanju.hrms.logins.service.transfer.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class RoleView {

  private Integer id;

  private String code;

  private String name;

  private String description;

}
