package com.slmanju.hrms.leaves.service.impl;

import com.slmanju.hrms.employee.model.Employee;
import com.slmanju.hrms.employee.service.EmployeeService;
import com.slmanju.hrms.employee.view.EmployeeView;
import com.slmanju.hrms.leaves.model.LeaveEntitlement;
import com.slmanju.hrms.leaves.model.LeaveType;
import com.slmanju.hrms.leaves.repository.LeaveEntitlementRepository;
import com.slmanju.hrms.leaves.service.LeaveEntitlementService;
import com.slmanju.hrms.leaves.view.LeaveEntitlementView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class LeaveEntitlementServiceImpl implements LeaveEntitlementService {

    private final LeaveEntitlementRepository leaveEntitlementRepository;
    private final EmployeeService employeeService;

    @Autowired
    public LeaveEntitlementServiceImpl(LeaveEntitlementRepository leaveEntitlementRepository,
                                       EmployeeService employeeService) {
        this.leaveEntitlementRepository = leaveEntitlementRepository;
        this.employeeService = employeeService;
    }

    public void saveAllForYear(int year) {
        List<EmployeeView> employeeViews = employeeService.findAll();
        List<LeaveEntitlement> leaveSummaries = new ArrayList<>();
        for (EmployeeView employeeView : employeeViews) {
            for (LeaveType leaveType : LeaveType.values()) {
                if (!(LeaveType.LIEUVE.equals(leaveType) || LeaveType.NO_PAY.equals(leaveType))) {
                    LeaveEntitlement leaveSummary = new LeaveEntitlement();
                    leaveSummary.setEntitlementDays(LeaveType.getDefaultDays(leaveType));
                    leaveSummary.setEmployee(Employee.valueOf(employeeView));
                    leaveSummary.setLeaveType(leaveType);
                    leaveSummary.setYear(year);
                    leaveSummaries.add(leaveSummary);
                }
            }
        }
        leaveEntitlementRepository.saveAll(leaveSummaries);
    }
    
    @Override
    public void save(LeaveEntitlementView leaveSummaryView) {
        leaveEntitlementRepository.save(LeaveEntitlement.valueOf(leaveSummaryView));
    }

    @Override
    public List<LeaveEntitlementView> findByEmployee(String employeeId) {
        List<LeaveEntitlement> entitlements = leaveEntitlementRepository.findByEmployeeId(employeeId);
        return entitlements.stream().map(LeaveEntitlement::view).collect(toList());
    }

}
