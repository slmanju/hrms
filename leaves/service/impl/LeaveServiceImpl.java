package com.slmanju.hrms.leaves.service.impl;

import com.manjula.eleave.employee.service.EmployeeService;
import com.manjula.eleave.employee.view.EmployeeView;
import com.manjula.eleave.leaves.model.Leave;
import com.manjula.eleave.leaves.model.LeaveStatus;
import com.manjula.eleave.leaves.model.LeaveType;
import com.manjula.eleave.leaves.repository.LeaveRepository;
import com.manjula.eleave.leaves.service.LeaveService;
import com.manjula.eleave.leaves.view.LeaveView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LeaveServiceImpl implements LeaveService {

    private LeaveRepository leaveRepository;
    @Autowired
    private EmployeeService employeeService;

    @Override
    public void submitLeave(LeaveView view) {
        EmployeeView employee = employeeService.findById("042d7409-491a-4abe-a7d3-170395420f60");
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
        return leave.get().view();
    }

    @Override
    public List<LeaveType> getAllLeaveTypes() {
        return null;
    }

    @Override
    public List<LeaveView> getAllLeavesFor(String employeeId) {
        List<Leave> leaves = leaveRepository.findAllByEmployeeId(employeeId);
        List<LeaveView> views = new ArrayList<>();
        for (Leave leave : leaves) {
            views.add(leave.view());
        }
        return views;
    }

    @Override
    public List<LeaveView> getAllLeavesFor(String employeeId, LeaveStatus status) {
        List<Leave> leaves = leaveRepository.findAllByEmployeeId(employeeId);
        List<LeaveView> views = new ArrayList<>();
        for (Leave leave : leaves) {
            views.add(leave.view());
        }
        return views;
    }

    @Override
    public List<LeaveView> getAllPendingLeaves() {
        List<Leave> leaves = leaveRepository.findAllByStatus(LeaveStatus.PENDING);
        List<LeaveView> views = new ArrayList<>();
        for (Leave leave : leaves) {
            views.add(leave.view());
        }
        return views;
    }

    @Autowired
    public void setLeaveRepository(LeaveRepository leaveRepository) {
        this.leaveRepository = leaveRepository;
    }

}
