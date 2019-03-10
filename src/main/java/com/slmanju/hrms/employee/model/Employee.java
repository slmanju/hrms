package com.slmanju.hrms.employee.model;

import com.slmanju.hrms.employee.view.EmployeeView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Document
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Employee {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private JobPosition jobPosition;
    private Role role;
    
    public static Employee valueOf(EmployeeView view) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(view, employee);
        return employee;
    }

    public EmployeeView view() {
        EmployeeView view = new EmployeeView();
        BeanUtils.copyProperties(this, view);
        return view;
    }
    
    public static List<EmployeeView> views(List<Employee> employees) {
        return employees.stream().map(Employee::view).collect(toList());
    }

}
