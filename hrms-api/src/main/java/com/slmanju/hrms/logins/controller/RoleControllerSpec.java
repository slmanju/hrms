package com.slmanju.hrms.logins.controller;

import com.slmanju.hrms.core.ResultView;
import com.slmanju.hrms.core.SearchResult;
import com.slmanju.hrms.logins.service.transfer.dto.RoleDto;
import com.slmanju.hrms.logins.service.transfer.dto.RoleSearchRequest;
import com.slmanju.hrms.logins.service.transfer.view.RoleView;

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
public interface RoleControllerSpec {

  @GetMapping(value = "/api/roles/search/{start}/{size}")
  ResponseEntity<SearchResult<RoleView>> search(@PathVariable int start, @PathVariable int size, RoleSearchRequest searchRequest);

  @GetMapping(value = "/api/roles/{id}")
  ResponseEntity<ResultView<RoleView>> findRole(@PathVariable("id") Integer id);

  @PostMapping(value = "/api/roles")
  ResponseEntity<ResultView<Integer>> createRole(@RequestBody RoleDto roleDto);

  @PutMapping(value = "/api/roles/{id}")
  ResponseEntity<ResultView<RoleView>> updateRole(@PathVariable("id") Integer id, @RequestBody RoleDto roleDto);

  @DeleteMapping(value = "/api/roles/{id}")
  ResponseEntity<Void> deleteRole(@PathVariable("id") Integer id);

}
