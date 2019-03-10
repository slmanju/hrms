package com.slmanju.hrms.leaves.controller;//package com.manjula.eleave.leaves.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.manjula.myleave.leave.service.LeaveEntitlementService;
//import com.manjula.myleave.leave.view.LeaveEntitlementView;
//
//@Controller
//public class LeaveEntitlementController {
//
//    private LeaveEntitlementService leaveEntitlementService;
//
//    @RequestMapping(value = "/leave/year/{year}")
//    @ResponseBody
//    public String saveForYear(@PathVariable("year") int year) {
//        leaveEntitlementService.saveAllForYear(year);
//        return "added";
//    }
//
//    @RequestMapping(value = "/leave/employee/{employeeId}")
//    @ResponseBody
//    public List<LeaveEntitlementView> getUserLeaveEntitlement(@PathVariable("employeeId") String employeeId) {
//        List<LeaveEntitlementView> entitlementViews = leaveEntitlementService.findByEmployee(employeeId);
//        return entitlementViews;
//    }
//
//    @Autowired
//    public void setLeaveEntitlementService(LeaveEntitlementService leaveEntitlementService) {
//        this.leaveEntitlementService = leaveEntitlementService;
//    }
//
//}
