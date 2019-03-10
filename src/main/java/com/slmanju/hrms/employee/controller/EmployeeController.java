package com.slmanju.hrms.employee.controller;

import com.slmanju.hrms.employee.service.EmployeeService;
import com.slmanju.hrms.employee.view.EmployeeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    private EmployeeService employeeService;
    
    @GetMapping(value = "")
    public ResponseEntity<List<EmployeeView>> index() {
        List<EmployeeView> employees = employeeService.findAll();
        return ResponseEntity.ok(employees);
    }

    @PostMapping(value = "/save")
    public ResponseEntity.BodyBuilder save(@Valid @RequestBody EmployeeView employee) {
        employeeService.save(employee);
        return ResponseEntity.ok();
    }

    @PutMapping(value = "/update")
    public ResponseEntity.BodyBuilder update(@Valid @RequestBody EmployeeView employee) {
        employeeService.update(employee);
        return ResponseEntity.ok();
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeView> view(@PathVariable String id) {
        EmployeeView employeeView = employeeService.findById(id);
        return ResponseEntity.ok(employeeView);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity.BodyBuilder delete(@PathVariable String id) {
        employeeService.delete(id);
        return ResponseEntity.ok();
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
}
