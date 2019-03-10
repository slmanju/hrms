package com.slmanju.hrms.leaves.service;

import com.manjula.eleave.employee.view.EmployeeView;
import com.manjula.eleave.leaves.model.LeaveStatus;
import com.manjula.eleave.leaves.model.LeaveType;
import com.manjula.eleave.leaves.view.LeaveView;

import java.util.List;

public interface LeaveService {

    void submitLeave(LeaveView leave);
    
    void updateLeave(LeaveView leave, EmployeeView updatedBy);
    
    LeaveView getLeave(String id);
    
    List<LeaveType> getAllLeaveTypes();
    
    List<LeaveView> getAllLeavesFor(String employeeId);
    
    List<LeaveView> getAllLeavesFor(String employeeId, LeaveStatus status);
    
    List<LeaveView> getAllPendingLeaves();
    
}
