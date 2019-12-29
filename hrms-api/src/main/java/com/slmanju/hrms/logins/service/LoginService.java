package com.slmanju.hrms.logins.service;

import com.slmanju.hrms.core.SearchResult;
import com.slmanju.hrms.logins.service.entity.Login;
import com.slmanju.hrms.logins.service.transfer.dto.LoginDto;
import com.slmanju.hrms.logins.service.transfer.dto.LoginSearchRequest;
import com.slmanju.hrms.logins.service.transfer.view.LoginView;

import java.util.Optional;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public interface LoginService {

  SearchResult<LoginView> search(LoginSearchRequest searchRequest);

  Optional<Login> findById(Integer id);

  Login saveLogin(LoginDto loginDto);

  Login updateLogin(Integer id, LoginDto loginDto);

  void deleteLogin(Integer id);

}
