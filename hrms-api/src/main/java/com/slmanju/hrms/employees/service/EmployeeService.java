package com.slmanju.hrms.employees.service;

import com.slmanju.hrms.core.SearchResult;
import com.slmanju.hrms.employees.service.entity.Employee;
import com.slmanju.hrms.employees.service.transfer.dto.EmployeeDto;
import com.slmanju.hrms.employees.service.transfer.dto.EmployeeSearchRequest;
import com.slmanju.hrms.employees.service.transfer.view.EmployeeView;

import java.util.Optional;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public interface EmployeeService {

  SearchResult<EmployeeView> search(EmployeeSearchRequest searchRequest);

  Optional<Employee> findById(Integer id);

  Employee saveEmployee(EmployeeDto employeeDto);

  Employee updateEmployee(Integer id, EmployeeDto employeeDto);

  void deleteEmployee(Integer id);

}
