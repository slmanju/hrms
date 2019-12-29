package com.slmanju.hrms.logins.service.delegator;

import com.slmanju.hrms.core.SearchResult;
import com.slmanju.hrms.logins.service.transfer.dto.RoleDto;
import com.slmanju.hrms.logins.service.transfer.dto.RoleSearchRequest;
import com.slmanju.hrms.logins.service.transfer.view.RoleView;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public interface RoleServiceDelegator {

  SearchResult<RoleView> search(RoleSearchRequest searchRequest);

  RoleView findById(Integer id);

  Integer saveRole(RoleDto roleDto);

  RoleView updateRole(Integer id, RoleDto roleDto);

  void deleteRole(Integer id);

}
