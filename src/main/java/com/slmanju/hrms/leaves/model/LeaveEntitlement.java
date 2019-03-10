package com.slmanju.hrms.leaves.model;

import com.slmanju.hrms.employee.model.Employee;
import com.slmanju.hrms.leaves.view.LeaveEntitlementView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("leave_entitlements")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class LeaveEntitlement {

    @Id
    private String id;
    private Employee employee;
    private LeaveType leaveType;
    private int year;
    private int entitlementDays;
    private int takenDays;
    
    public LeaveEntitlementView view() {
        LeaveEntitlementView view = new LeaveEntitlementView();
        BeanUtils.copyProperties(this, view);
        return view;
    }

    public static LeaveEntitlement valueOf(LeaveEntitlementView leaveEntitlementView) {
        LeaveEntitlement leaveEntitlement = new LeaveEntitlement();
        BeanUtils.copyProperties(leaveEntitlementView, leaveEntitlement);
        return leaveEntitlement;
    }

}
