package com.slmanju.hrms.leaves.model;

import com.slmanju.hrms.employee.model.Employee;
import com.slmanju.hrms.leaves.view.LeaveView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("leaves")
@Data @NoArgsConstructor @AllArgsConstructor  @Builder
public class Leave {

    @Id
    private String id;
    private Employee employee;
    private LeaveType type;
    private LocalDate fromDate;
    private LocalDate toDate;
    private int noOfDays;
    private String comment;
    private LeaveStatus status = LeaveStatus.PENDING;

    public static Leave valueOf(LeaveView view) {
        Leave leave = new Leave();
        BeanUtils.copyProperties(view, leave);
        return leave;
    }
    
    public LeaveView view() {
        LeaveView view = new LeaveView();
        BeanUtils.copyProperties(this, view);
        return view;
    }

}
