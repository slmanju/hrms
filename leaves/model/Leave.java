package com.slmanju.hrms.leaves.model;

import com.manjula.eleave.employee.model.Employee;
import com.manjula.eleave.leaves.view.LeaveView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "el_leave")
@Data @NoArgsConstructor @AllArgsConstructor  @Builder
public class Leave {

    @Column(name = "id")
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    private String id;
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @Column(name = "leave_type")
    @Enumerated(EnumType.STRING)
    private LeaveType type;
    @Column(name = "from_date")
    @Temporal(TemporalType.DATE)
    private Date fromDate;
    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date toDate;
    @Column(name = "no_of_days")
    private int noOfDays;
    @Column(name = "comment")
    private String comment;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
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
