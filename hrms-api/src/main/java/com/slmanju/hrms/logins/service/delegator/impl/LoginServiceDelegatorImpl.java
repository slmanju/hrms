package com.slmanju.hrms.logins.service.delegator.impl;

import com.slmanju.hrms.core.SearchResult;
import com.slmanju.hrms.logins.service.LoginService;
import com.slmanju.hrms.logins.service.delegator.LoginServiceDelegator;
import com.slmanju.hrms.logins.service.entity.Login;
import com.slmanju.hrms.logins.service.mapper.LoginMapper;
import com.slmanju.hrms.logins.service.mapper.RoleMapper;
import com.slmanju.hrms.logins.service.transfer.dto.LoginDto;
import com.slmanju.hrms.logins.service.transfer.dto.LoginSearchRequest;
import com.slmanju.hrms.logins.service.transfer.view.LoginView;

import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Service
public class LoginServiceDelegatorImpl implements LoginServiceDelegator {

  private final LoginService loginService;

  private final LoginMapper loginMapper;

  private final RoleMapper roleMapper;

  public LoginServiceDelegatorImpl(LoginService loginService, LoginMapper loginMapper, RoleMapper roleMapper) {
    this.loginService = loginService;
    this.loginMapper = loginMapper;
    this.roleMapper = roleMapper;
  }

  public SearchResult<LoginView> search(LoginSearchRequest searchRequest) {
    return loginService.search(searchRequest);
  }

  public LoginView findById(Integer id) {
    Optional<Login> loginOptional = loginService.findById(id);
    return loginOptional.map(loginMapper::toView).orElse(null);
  }

  public Login saveLogin(LoginDto loginDto) {
    return loginService.saveLogin(loginDto);
  }

  public LoginView updateLogin(Integer id, LoginDto loginDto) {
    Login login = loginService.updateLogin(id, loginDto);

    return loginMapper.toView(login);
  }

  public void deleteLogin(Integer id) {
    loginService.deleteLogin(id);
  }

}
