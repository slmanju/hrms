package com.slmanju.hrms.leaves.repository;

import com.manjula.eleave.leaves.model.LeaveEntitlement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveEntitlementRepository extends JpaRepository<LeaveEntitlement, String> {

    List<LeaveEntitlement> findByEmployeeId(String employeeId);
    
}
