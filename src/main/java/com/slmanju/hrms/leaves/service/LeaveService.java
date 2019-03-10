package com.slmanju.hrms.leaves.service;

import com.slmanju.hrms.employee.view.EmployeeView;
import com.slmanju.hrms.leaves.model.LeaveStatus;
import com.slmanju.hrms.leaves.model.LeaveType;
import com.slmanju.hrms.leaves.view.LeaveView;

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
