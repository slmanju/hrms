package com.slmanju.hrms.logins.service.delegator;

import com.slmanju.hrms.core.SearchResult;
import com.slmanju.hrms.logins.service.entity.Login;
import com.slmanju.hrms.logins.service.transfer.dto.LoginDto;
import com.slmanju.hrms.logins.service.transfer.dto.LoginSearchRequest;
import com.slmanju.hrms.logins.service.transfer.view.LoginView;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public interface LoginServiceDelegator {

  SearchResult<LoginView> search(LoginSearchRequest searchRequest);

  LoginView findById(Integer id);

  Login saveLogin(LoginDto loginDto);

  LoginView updateLogin(Integer id, LoginDto loginDto);

  void deleteLogin(Integer id);

}
