package com.slmanju.hrms.logins.service.delegator.impl;

import com.slmanju.hrms.core.SearchResult;
import com.slmanju.hrms.logins.service.RoleService;
import com.slmanju.hrms.logins.service.delegator.RoleServiceDelegator;
import com.slmanju.hrms.logins.service.entity.Role;
import com.slmanju.hrms.logins.service.mapper.RoleMapper;
import com.slmanju.hrms.logins.service.transfer.dto.RoleDto;
import com.slmanju.hrms.logins.service.transfer.dto.RoleSearchRequest;
import com.slmanju.hrms.logins.service.transfer.view.RoleView;

import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Service
public class RoleServiceDelegatorImpl implements RoleServiceDelegator {

  private final RoleService roleService;

  private final RoleMapper roleMapper;

  public RoleServiceDelegatorImpl(RoleService roleService, RoleMapper roleMapper) {
    this.roleService = roleService;
    this.roleMapper = roleMapper;
  }

  public SearchResult<RoleView> search(RoleSearchRequest searchRequest) {
    return roleService.search(searchRequest);
  }

  public RoleView findById(Integer id) {
    Optional<Role> role = roleService.findById(id);

    return role.map(roleMapper::toView).orElse(null);
  }

  public Integer saveRole(RoleDto roleDto) {
    return roleService.saveRole(roleDto);
  }

  public RoleView updateRole(Integer id, RoleDto roleDto) {
    Role role = roleService.updateRole(id, roleDto);

    return roleMapper.toView(role);
  }

  public void deleteRole(Integer id) {
    roleService.deleteRole(id);
  }

}
