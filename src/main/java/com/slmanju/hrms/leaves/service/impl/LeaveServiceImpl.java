package com.slmanju.hrms.leaves.service.impl;

import com.slmanju.hrms.employee.service.EmployeeService;
import com.slmanju.hrms.employee.view.EmployeeView;
import com.slmanju.hrms.leaves.model.Leave;
import com.slmanju.hrms.leaves.model.LeaveStatus;
import com.slmanju.hrms.leaves.model.LeaveType;
import com.slmanju.hrms.leaves.repository.LeaveRepository;
import com.slmanju.hrms.leaves.service.LeaveService;
import com.slmanju.hrms.leaves.view.LeaveView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class LeaveServiceImpl implements LeaveService {

    private final LeaveRepository leaveRepository;
    private final EmployeeService employeeService;

    @Autowired
    public LeaveServiceImpl(LeaveRepository leaveRepository, EmployeeService employeeService) {
        this.leaveRepository = leaveRepository;
        this.employeeService = employeeService;
    }

    @Override
    public void submitLeave(LeaveView view) {
        EmployeeView employee = employeeService.findById(view.getId());
        view.setEmployee(employee);
        leaveRepository.save(Leave.valueOf(view));
    }

    @Override
    public void updateLeave(LeaveView leave, EmployeeView updatedBy) {
        leaveRepository.save(Leave.valueOf(leave));
    }
    
    @Override
    public LeaveView getLeave(String id) {
        Optional<Leave> leave = leaveRepository.findById(id);
        return leave.map(Leave::view).orElse(null);
    }

    @Override
    public List<LeaveType> getAllLeaveTypes() {
        return Arrays.stream(LeaveType.values()).collect(toList());
    }

    @Override
    public List<LeaveView> getAllLeavesFor(String employeeId) {
        List<Leave> leaves = leaveRepository.findAllByEmployeeId(employeeId);
        return leaves.stream().map(Leave::view).collect(toList());
    }

    @Override
    public List<LeaveView> getAllLeavesFor(String employeeId, LeaveStatus status) {
        List<Leave> leaves = leaveRepository.findAllByEmployeeId(employeeId);
        return leaves.stream().map(Leave::view).collect(toList());
    }

    @Override
    public List<LeaveView> getAllPendingLeaves() {
        List<Leave> leaves = leaveRepository.findAllByStatus(LeaveStatus.PENDING);
        return leaves.stream().map(Leave::view).collect(toList());
    }

}
