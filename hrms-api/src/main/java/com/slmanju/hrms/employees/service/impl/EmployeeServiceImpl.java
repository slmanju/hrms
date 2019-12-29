package com.slmanju.hrms.employees.service.impl;

import com.slmanju.hrms.core.ResourceNotFoundException;
import com.slmanju.hrms.core.SearchResult;
import com.slmanju.hrms.employees.repository.EmployeeRepository;
import com.slmanju.hrms.employees.service.EmployeeService;
import com.slmanju.hrms.employees.service.entity.Employee;
import com.slmanju.hrms.employees.service.mapper.EmployeeMapper;
import com.slmanju.hrms.employees.service.transfer.dto.EmployeeDto;
import com.slmanju.hrms.employees.service.transfer.dto.EmployeeSearchRequest;
import com.slmanju.hrms.employees.service.transfer.view.EmployeeView;

import com.slmanju.hrms.logins.service.LoginService;
import com.slmanju.hrms.logins.service.entity.Login;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Service
public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeRepository employeeRepository;

  private final EmployeeMapper employeeMapper;

  private final LoginService loginService;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper, LoginService loginService) {
    this.employeeRepository = employeeRepository;
    this.employeeMapper = employeeMapper;
    this.loginService = loginService;
  }

  @Override
  public SearchResult<EmployeeView> search(EmployeeSearchRequest searchRequest) {
    Sort sort = Sort.by("id").ascending();
    PageRequest pageRequest = PageRequest.of(searchRequest.getStart(), searchRequest.getSize(), sort);

    Page<Employee> page = employeeRepository.search(searchRequest, pageRequest);

    return SearchResult.of(page, employeeMapper);
  }

  @Override
  public Optional<Employee> findById(Integer id) {
    return employeeRepository.findById(id);
  }

  @Override
  public Employee saveEmployee(EmployeeDto employeeDto) {
    Employee employee = employeeMapper.toEntity(employeeDto);

    Login login = loginService.saveLogin(employeeDto.getLogin());
    employee.setLogin(login);

    return employeeRepository.save(employee);
  }

  @Override
  public Employee updateEmployee(Integer id, EmployeeDto employeeDto) {
    Optional<Employee> employeeOptional = findById(id);

    return employeeOptional.map(saved -> {
      Employee updateEntity = employeeMapper.toUpdateEntity(employeeDto, saved);
      updateEntity.setLogin(saved.getLogin());
      return employeeRepository.save(updateEntity);
    }).orElseThrow(() -> ResourceNotFoundException.newInstance(id, "Employee not found"));
  }

  @Override
  public void deleteEmployee(Integer id) {
    employeeRepository.deleteById(id);
  }

}
