package com.slmanju.hrms.employees.service.mapper;

import com.slmanju.hrms.core.DataMapper;
import com.slmanju.hrms.employees.service.entity.Employee;
import com.slmanju.hrms.employees.service.transfer.dto.EmployeeDto;
import com.slmanju.hrms.employees.service.transfer.view.EmployeeView;

import com.slmanju.hrms.logins.service.mapper.LoginMapper;
import com.slmanju.hrms.logins.service.transfer.view.LoginView;
import com.slmanju.hrms.logins.service.transfer.view.RoleView;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Component
public class EmployeeMapper implements DataMapper<Employee, EmployeeView, EmployeeDto> {

  private final LoginMapper loginMapper;

  public EmployeeMapper(LoginMapper loginMapper) {
    this.loginMapper = loginMapper;
  }

  @Override
  public EmployeeView toView(Employee entity) {
    EmployeeView view = view();

    BeanUtils.copyProperties(entity, view);

    LoginView loginView = loginMapper.toView(entity.getLogin());
    view.setLogin(loginView);

    return view;
  }

  @Override
  public Employee entity() {
    return new Employee();
  }

  @Override
  public EmployeeView view() {
    return new EmployeeView();
  }

}
