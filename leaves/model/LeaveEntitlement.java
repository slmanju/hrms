package com.slmanju.hrms.leaves.model;

import com.manjula.eleave.employee.model.Employee;
import com.manjula.eleave.leaves.view.LeaveEntitlementView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Entity
@Table(name = "el_leave_entitlement")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class LeaveEntitlement {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @Column(name = "leave_type")
    @Enumerated(EnumType.STRING)
    private LeaveType leaveType;
    @Column(name = "year")
    private int year;
    @Column(name = "entitlement_days")
    private int entitlementDays;
    @Column(name = "taken_days")
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
