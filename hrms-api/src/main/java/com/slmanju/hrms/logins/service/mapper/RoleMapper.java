package com.slmanju.hrms.logins.service.mapper;

import com.slmanju.hrms.core.DataMapper;
import com.slmanju.hrms.logins.service.entity.Role;
import com.slmanju.hrms.logins.service.transfer.dto.RoleDto;
import com.slmanju.hrms.logins.service.transfer.view.RoleView;

import org.springframework.stereotype.Component;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Component
public class RoleMapper implements DataMapper<Role, RoleView, RoleDto> {

  @Override
  public Role entity() {
    return new Role();
  }

  @Override
  public RoleView view() {
    return new RoleView();
  }

}
