package com.slmanju.hrms.logins.service.mapper;

import com.slmanju.hrms.core.DataMapper;
import com.slmanju.hrms.logins.service.entity.Login;
import com.slmanju.hrms.logins.service.transfer.dto.LoginDto;
import com.slmanju.hrms.logins.service.transfer.view.LoginView;

import com.slmanju.hrms.logins.service.transfer.view.RoleView;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Component
public class LoginMapper implements DataMapper<Login, LoginView, LoginDto> {

  private final RoleMapper roleMapper;

  public LoginMapper(RoleMapper roleMapper) {
    this.roleMapper = roleMapper;
  }

  @Override
  public LoginView toView(Login entity) {
    LoginView view = view();

    BeanUtils.copyProperties(entity, view);

    RoleView roleView = roleMapper.toView(entity.getRole());
    view.setRoleView(roleView);

    return view;
  }

  @Override
  public Login entity() {
    return new Login();
  }

  @Override
  public LoginView view() {
    return new LoginView();
  }

}
