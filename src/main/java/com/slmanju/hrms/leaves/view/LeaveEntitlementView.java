package com.slmanju.hrms.leaves.view;

import com.slmanju.hrms.employee.view.EmployeeView;
import com.slmanju.hrms.leaves.model.LeaveType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class LeaveEntitlementView {

    private String id;
    private EmployeeView employeeView;
    private LeaveType leaveType;
    private int year;
    private int entitlementDays;
    private int takenDays;

}
