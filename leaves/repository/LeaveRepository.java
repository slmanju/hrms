package com.slmanju.hrms.leaves.repository;

import com.manjula.eleave.leaves.model.Leave;
import com.manjula.eleave.leaves.model.LeaveStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, String> {

    @Query(name = "SELECT leave FROM Leave leave " +
            "join fetch leave.employee employee " +
            "join fetch employee.role " +
            "WHERE leave.employee.id = :employeeId")
    List<Leave> findAllByEmployeeId(@Param("employeeId") String employeeId);

    @Query(name = "SELECT leave FROM Leave leave WHERE leave.status = :status")
    List<Leave> findAllByStatus(@Param("status") LeaveStatus status);

}
