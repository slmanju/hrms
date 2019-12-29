package com.slmanju.hrms.logins.service.impl;

import com.slmanju.hrms.core.ResourceNotFoundException;
import com.slmanju.hrms.core.SearchResult;
import com.slmanju.hrms.logins.repository.LoginRepository;
import com.slmanju.hrms.logins.service.LoginService;
import com.slmanju.hrms.logins.service.RoleService;
import com.slmanju.hrms.logins.service.entity.Login;
import com.slmanju.hrms.logins.service.entity.Role;
import com.slmanju.hrms.logins.service.mapper.LoginMapper;
import com.slmanju.hrms.logins.service.transfer.dto.LoginDto;
import com.slmanju.hrms.logins.service.transfer.dto.LoginSearchRequest;
import com.slmanju.hrms.logins.service.transfer.view.LoginView;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Service
public class LoginServiceImpl implements LoginService {

  private final LoginRepository loginRepository;

  private final LoginMapper loginMapper;

  private final RoleService roleService;

  public LoginServiceImpl(LoginRepository loginRepository, LoginMapper loginMapper, RoleService roleService) {
    this.loginRepository = loginRepository;
    this.loginMapper = loginMapper;
    this.roleService = roleService;
  }

  @Override
  public SearchResult<LoginView> search(LoginSearchRequest searchRequest) {
    Sort sort = Sort.by("id").ascending();
    PageRequest pageRequest = PageRequest.of(searchRequest.getStart(), searchRequest.getSize(), sort);

    Page<Login> page = loginRepository.search(searchRequest, pageRequest);

    return SearchResult.of(page, loginMapper);
  }

  @Override
  public Optional<Login> findById(Integer id) {
    return loginRepository.findById(id);
  }

  @Override
  public Login saveLogin(LoginDto loginDto) {
    Login login = loginMapper.toEntity(loginDto);

    Role role = roleService.findById(loginDto.getRoleId())
                            .orElseThrow(() -> ResourceNotFoundException.newInstance(loginDto.getRoleId(), "Role not found"));

    login.setRole(role);

    return loginRepository.save(login);
  }

  @Override
  public Login updateLogin(Integer id, LoginDto loginDto) {
    Optional<Login> loginOptional = findById(id);

    Login login = loginOptional.map(saved -> loginMapper.toUpdateEntity(loginDto, saved))
                                .orElseThrow(() -> ResourceNotFoundException.newInstance(loginDto.getRoleId(), "Login not found"));

    Role role = roleService.findById(loginDto.getRoleId())
            .orElseThrow(() -> ResourceNotFoundException.newInstance(loginDto.getRoleId(), "Role not found"));

    login.setRole(role);

    return loginRepository.save(login);
  }

  @Override
  public void deleteLogin(Integer id) {
    loginRepository.deleteById(id);
  }

}
