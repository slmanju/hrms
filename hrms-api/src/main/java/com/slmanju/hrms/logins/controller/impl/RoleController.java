package com.slmanju.hrms.logins.controller.impl;

import com.slmanju.hrms.core.ResultView;
import com.slmanju.hrms.core.SearchResult;
import com.slmanju.hrms.logins.controller.RoleControllerSpec;
import com.slmanju.hrms.logins.service.delegator.RoleServiceDelegator;
import com.slmanju.hrms.logins.service.transfer.dto.RoleDto;
import com.slmanju.hrms.logins.service.transfer.dto.RoleSearchRequest;
import com.slmanju.hrms.logins.service.transfer.view.RoleView;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@RestController
public class RoleController implements RoleControllerSpec {

  private final RoleServiceDelegator roleServiceDelegator;

  public RoleController(RoleServiceDelegator roleServiceDelegator) {
    this.roleServiceDelegator = roleServiceDelegator;
  }

  @Override
  public ResponseEntity<SearchResult<RoleView>> search(int start, int size, RoleSearchRequest searchRequest) {
    searchRequest.setStart(start);
    searchRequest.setSize(size);

    SearchResult<RoleView> searchView = roleServiceDelegator.search(searchRequest);

    return ResponseEntity.ok(searchView);
  }

  @Override
  public ResponseEntity<ResultView<RoleView>> findRole(Integer id) {
    RoleView roleView = roleServiceDelegator.findById(id);

    ResultView<RoleView> resultView = new ResultView<>();
    resultView.setData(roleView);

    return ResponseEntity.ok(resultView);
  }

  @Override
  public ResponseEntity<ResultView<Integer>> createRole(RoleDto roleDto) {
    Integer id = roleServiceDelegator.saveRole(roleDto);

    ResultView<Integer> result = new ResultView<>();
    result.setData(id);

    return ResponseEntity.status(HttpStatus.CREATED).body(result);
  }

  @Override
  public ResponseEntity<ResultView<RoleView>> updateRole(Integer id, RoleDto roleDto) {
    RoleView roleView = roleServiceDelegator.updateRole(id, roleDto);

    ResultView<RoleView> resultView = new ResultView<>();
    resultView.setData(roleView);

    return ResponseEntity.ok(resultView);
  }

  @Override
  public ResponseEntity<Void> deleteRole(Integer id) {
    roleServiceDelegator.deleteRole(id);

    return ResponseEntity.noContent().build();
  }

}
