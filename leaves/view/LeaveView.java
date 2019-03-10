package com.slmanju.hrms.leaves.view;

import com.manjula.eleave.employee.view.EmployeeView;
import com.manjula.eleave.leaves.model.LeaveStatus;
import com.manjula.eleave.leaves.model.LeaveType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeaveView {

    private String id;
    private EmployeeView employee;
    private LeaveType type;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fromDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date toDate;
    private int noOfDays;
    private String comment;
    private LeaveStatus status = LeaveStatus.PENDING;

}
