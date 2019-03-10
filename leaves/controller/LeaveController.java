package com.slmanju.hrms.leaves.controller;

import com.manjula.eleave.commons.SecurityUtils;
import com.manjula.eleave.leaves.model.LeaveStatus;
import com.manjula.eleave.leaves.model.LeaveType;
import com.manjula.eleave.leaves.service.LeaveService;
import com.manjula.eleave.leaves.view.LeaveView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/leaves")
public class LeaveController {

    private LeaveService leaveService;
    
    @GetMapping(value = "")
    public String leaves(ModelMap model) {
        List<LeaveView> leaves = leaveService.getAllLeavesFor(SecurityUtils.userId());
        model.addAttribute("leaves", leaves);
        return "/leave/leaves";
    }

    @GetMapping(value = "/request")
    public String applyLeave(ModelMap model) {
        model.addAttribute("leave", new LeaveView());
        model.addAttribute("message", model.get("message"));
        return "leave/leave-request";
    }
    
    @PostMapping(value = "/request")
    public String submitLeave(@ModelAttribute("leave") LeaveView leave, ModelMap model, RedirectAttributes redirectAttributes) {
        leaveService.submitLeave(leave);
        redirectAttributes.addAttribute("message", "Leave Request Sent");
        return "redirect:/leaves/request";
    }
    
    @GetMapping(value = "/pending")
    public String findAll(ModelMap model) {
        List<LeaveView> leaves = leaveService.getAllPendingLeaves();
        model.addAttribute("leaves", leaves);
        return "/leave/leaves";
    }
    
    @PostMapping(value = "/update", params = "action=Approve")
    public String approveLeave(@ModelAttribute("leaveId") String leaveId) {
        LeaveView leaveView = leaveService.getLeave(leaveId);
        leaveView.setStatus(LeaveStatus.APPRVOED);
        leaveService.updateLeave(leaveView, null);
        return "redirect:/leave/pending";
    }
    
    @PostMapping(value = "/update", params = "action=Reject")
    public String rejectLeave(@ModelAttribute("leaveId") String leaveId) {
        LeaveView leaveView = leaveService.getLeave(leaveId);
        leaveView.setStatus(LeaveStatus.REJECTED);
        leaveService.updateLeave(leaveView, null);
        return "redirect:/leave/pending";
    }

    @Autowired
    public void setLeaveService(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

}
