package com.slmanju.hrms.leaves.controller;

import com.slmanju.hrms.leaves.model.LeaveStatus;
import com.slmanju.hrms.leaves.service.LeaveService;
import com.slmanju.hrms.leaves.view.LeaveView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leaves")
public class LeaveController {

    private final LeaveService leaveService;

    @Autowired
    public LeaveController(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<LeaveView>> leaves(@PathVariable String id) {
        List<LeaveView> leaves = leaveService.getAllLeavesFor(id);
        return ResponseEntity.ok(leaves);
    }
    
    @PostMapping(value = "/request")
    public ResponseEntity.BodyBuilder submitLeave(LeaveView leave) {
        leaveService.submitLeave(leave);
        return ResponseEntity.ok();
    }
    
    @GetMapping(value = "/pending")
    public ResponseEntity<List<LeaveView>> findAll() {
        List<LeaveView> leaves = leaveService.getAllPendingLeaves();
        return ResponseEntity.ok(leaves);
    }
    
    @PostMapping(value = "/approve/{id}")
    public ResponseEntity.BodyBuilder approveLeave(@PathVariable String id) {
        LeaveView leaveView = leaveService.getLeave(id);
        leaveView.setStatus(LeaveStatus.APPRVOED);
        leaveService.updateLeave(leaveView, null);
        return ResponseEntity.ok();
    }
    
    @PostMapping(value = "/reject/{id}")
    public ResponseEntity.BodyBuilder rejectLeave(@PathVariable String id) {
        LeaveView leaveView = leaveService.getLeave(id);
        leaveView.setStatus(LeaveStatus.REJECTED);
        leaveService.updateLeave(leaveView, null);
        return ResponseEntity.ok();
    }

}
