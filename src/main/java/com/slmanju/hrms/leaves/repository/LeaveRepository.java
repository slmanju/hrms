package com.slmanju.hrms.leaves.repository;

import com.slmanju.hrms.leaves.model.Leave;
import com.slmanju.hrms.leaves.model.LeaveStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// TODO implements queries
@Repository
public interface LeaveRepository extends MongoRepository<Leave, String> {

//    @Query("SELECT leave FROM Leave leave " +
//            "join fetch leave.employee employee " +
//            "join fetch employee.role " +
//            "WHERE leave.employee.id = :employeeId")
    List<Leave> findAllByEmployeeId(@Param("employeeId") String employeeId);

//    @Query("SELECT leave FROM Leave leave WHERE leave.status = :status")
    List<Leave> findAllByStatus(@Param("status") LeaveStatus status);

}
