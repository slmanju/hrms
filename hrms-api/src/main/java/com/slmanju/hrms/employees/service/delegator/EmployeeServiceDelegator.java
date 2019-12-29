package com.slmanju.hrms.employees.service.delegator;

import com.slmanju.hrms.core.SearchResult;
import com.slmanju.hrms.employees.service.transfer.dto.EmployeeDto;
import com.slmanju.hrms.employees.service.transfer.dto.EmployeeSearchRequest;
import com.slmanju.hrms.employees.service.transfer.view.EmployeeView;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public interface EmployeeServiceDelegator {

  SearchResult<EmployeeView> search(EmployeeSearchRequest searchRequest);

  EmployeeView findById(Integer id);

  EmployeeView saveEmployee(EmployeeDto employeeDto);

  EmployeeView updateEmployee(Integer id, EmployeeDto employeeDto);

  void deleteEmployee(Integer id);

}
