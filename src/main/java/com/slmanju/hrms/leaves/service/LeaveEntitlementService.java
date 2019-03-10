package com.slmanju.hrms.leaves.service;

import com.slmanju.hrms.leaves.view.LeaveEntitlementView;

import java.util.List;

public interface LeaveEntitlementService {

    void saveAllForYear(int year);

    void save(LeaveEntitlementView leaveEntitlementView);

    List<LeaveEntitlementView> findByEmployee(String employeeId);

}
