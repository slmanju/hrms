package com.slmanju.hrms.logins.service;

import com.slmanju.hrms.core.SearchResult;
import com.slmanju.hrms.logins.service.entity.Role;
import com.slmanju.hrms.logins.service.transfer.dto.RoleDto;
import com.slmanju.hrms.logins.service.transfer.dto.RoleSearchRequest;
import com.slmanju.hrms.logins.service.transfer.view.RoleView;

import java.util.Optional;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public interface RoleService {

  SearchResult<RoleView> search(RoleSearchRequest searchRequest);

  Optional<Role> findById(Integer id);

  Integer saveRole(RoleDto roleDto);

  Role updateRole(Integer id, RoleDto roleDto);

  void deleteRole(Integer id);

}
