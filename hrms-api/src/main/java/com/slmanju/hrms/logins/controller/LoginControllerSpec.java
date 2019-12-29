package com.slmanju.hrms.logins.controller;

import com.slmanju.hrms.core.ResultView;
import com.slmanju.hrms.core.SearchResult;
import com.slmanju.hrms.logins.service.entity.Login;
import com.slmanju.hrms.logins.service.transfer.dto.LoginDto;
import com.slmanju.hrms.logins.service.transfer.dto.LoginSearchRequest;
import com.slmanju.hrms.logins.service.transfer.view.LoginView;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public interface LoginControllerSpec {

  @GetMapping(value = "/api/logins/search/{start}/{size}")
  ResponseEntity<SearchResult<LoginView>> search(@PathVariable int start, @PathVariable int size, LoginSearchRequest searchRequest);

  @GetMapping(value = "/api/logins/{id}")
  ResponseEntity<ResultView<LoginView>> findLogin(@PathVariable("id") Integer id);

  @PostMapping(value = "/api/logins")
  ResponseEntity<ResultView<Login>> createLogin(@RequestBody LoginDto loginDto);

  @PutMapping(value = "/api/logins/{id}")
  ResponseEntity<ResultView<LoginView>> updateLogin(@PathVariable("id") Integer id, @RequestBody LoginDto loginDto);

  @DeleteMapping(value = "/api/logins/{id}")
  ResponseEntity<Void> deleteLogin(@PathVariable("id") Integer id);

}
