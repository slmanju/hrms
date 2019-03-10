package com.slmanju.hrms.leaves.service.impl;

import com.manjula.eleave.employee.model.Employee;
import com.manjula.eleave.employee.service.EmployeeService;
import com.manjula.eleave.employee.view.EmployeeView;
import com.manjula.eleave.leaves.model.LeaveEntitlement;
import com.manjula.eleave.leaves.model.LeaveType;
import com.manjula.eleave.leaves.repository.LeaveEntitlementRepository;
import com.manjula.eleave.leaves.service.LeaveEntitlementService;
import com.manjula.eleave.leaves.service.LeaveService;
import com.manjula.eleave.leaves.view.LeaveEntitlementView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LeaveEntitlementServiceImpl implements LeaveEntitlementService {

    private LeaveEntitlementRepository leaveEntitlementRepository;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private LeaveService leaveService;
    
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
        List<LeaveEntitlementView> views = new ArrayList<>();
        for (LeaveEntitlement leaveEntitlement : entitlements) {
            views.add(leaveEntitlement.view());
        }
        return views;
    }

    @Autowired
    public void setLeaveSummaryRepository(LeaveEntitlementRepository leaveSummaryRepository) {
        this.leaveEntitlementRepository = leaveSummaryRepository;
    }

}
