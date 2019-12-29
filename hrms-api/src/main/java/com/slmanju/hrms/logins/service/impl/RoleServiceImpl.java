package com.slmanju.hrms.logins.service.impl;

import com.slmanju.hrms.core.ResourceNotFoundException;
import com.slmanju.hrms.core.SearchResult;
import com.slmanju.hrms.logins.repository.RoleRepository;
import com.slmanju.hrms.logins.service.RoleService;
import com.slmanju.hrms.logins.service.entity.Role;
import com.slmanju.hrms.logins.service.mapper.RoleMapper;
import com.slmanju.hrms.logins.service.transfer.dto.RoleDto;
import com.slmanju.hrms.logins.service.transfer.dto.RoleSearchRequest;
import com.slmanju.hrms.logins.service.transfer.view.RoleView;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Service
public class RoleServiceImpl implements RoleService {

  private final RoleRepository roleRepository;

  private final RoleMapper roleMapper;

  public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
    this.roleRepository = roleRepository;
    this.roleMapper = roleMapper;
  }

  @Override
  public SearchResult<RoleView> search(RoleSearchRequest searchRequest) {
    Sort sort = Sort.by("id").descending();
    PageRequest pageRequest = PageRequest.of(searchRequest.getStart(), searchRequest.getSize(), sort);

    Page<Role> page = roleRepository.search(searchRequest, pageRequest);

    return SearchResult.of(page, roleMapper);
  }

  @Override
  public Optional<Role> findById(Integer id) {
    return roleRepository.findById(id);
  }

  @Override
  public Integer saveRole(RoleDto roleDto) {
    Role role = roleMapper.toEntity(roleDto);

    role = roleRepository.save(role);

    return role.getId();
  }

  @Override
  public Role updateRole(Integer id, RoleDto roleDto) {
    Optional<Role> roleOptional = findById(id);

    Role role = roleOptional.map(saved -> roleMapper.toUpdateEntity(roleDto, saved))
                            .orElseThrow(() -> ResourceNotFoundException.newInstance(id, "Role not found"));

    return roleRepository.save(role);
  }

  @Override
  public void deleteRole(Integer id) {
    roleRepository.deleteById(id);
  }

}
