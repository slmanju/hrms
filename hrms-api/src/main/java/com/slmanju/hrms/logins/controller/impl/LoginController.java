package com.slmanju.hrms.logins.controller.impl;

import com.slmanju.hrms.core.ResultView;
import com.slmanju.hrms.core.SearchResult;
import com.slmanju.hrms.logins.controller.LoginControllerSpec;
import com.slmanju.hrms.logins.service.delegator.LoginServiceDelegator;
import com.slmanju.hrms.logins.service.entity.Login;
import com.slmanju.hrms.logins.service.transfer.dto.LoginDto;
import com.slmanju.hrms.logins.service.transfer.dto.LoginSearchRequest;
import com.slmanju.hrms.logins.service.transfer.view.LoginView;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@RestController
public class LoginController implements LoginControllerSpec {

  private final LoginServiceDelegator loginServiceDelegator;

  public LoginController(LoginServiceDelegator loginServiceDelegator) {
    this.loginServiceDelegator = loginServiceDelegator;
  }

  @Override
  public ResponseEntity<SearchResult<LoginView>> search(int start, int size, LoginSearchRequest searchRequest) {
    searchRequest.setStart(start);
    searchRequest.setSize(size);

    SearchResult<LoginView> searchView = loginServiceDelegator.search(searchRequest);

    return ResponseEntity.ok(searchView);
  }

  @Override
  public ResponseEntity<ResultView<LoginView>> findLogin(Integer id) {
    LoginView loginView = loginServiceDelegator.findById(id);

    ResultView<LoginView> resultView = new ResultView<>();
    resultView.setData(loginView);

    return ResponseEntity.ok(resultView);
  }

  @Override
  public ResponseEntity<ResultView<Login>> createLogin(LoginDto loginDto) {
    Login login = loginServiceDelegator.saveLogin(loginDto);

    ResultView<Login> result = new ResultView<>();
    result.setData(login);

    return ResponseEntity.status(HttpStatus.CREATED).body(result);
  }

  @Override
  public ResponseEntity<ResultView<LoginView>> updateLogin(Integer id, LoginDto loginDto) {
    LoginView loginView = loginServiceDelegator.updateLogin(id, loginDto);

    ResultView<LoginView> resultView = new ResultView<>();
    resultView.setData(loginView);

    return ResponseEntity.ok(resultView);
  }

  @Override
  public ResponseEntity<Void> deleteLogin(Integer id) {
    loginServiceDelegator.deleteLogin(id);

    return ResponseEntity.noContent().build();
  }

}
