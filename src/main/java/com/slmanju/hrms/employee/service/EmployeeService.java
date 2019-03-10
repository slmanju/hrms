package com.slmanju.hrms.employee.service;

import com.slmanju.hrms.employee.view.EmployeeView;

import java.util.List;

public interface EmployeeService {
    
    List<EmployeeView> findAll();

    void save(EmployeeView employee);

    void update(EmployeeView employee);

    EmployeeView findById(String id);

    void delete(String id);

}
