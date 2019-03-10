package com.slmanju.hrms.leaves.repository;

import com.slmanju.hrms.leaves.model.LeaveEntitlement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// TODO implement queries
@Repository
public interface LeaveEntitlementRepository extends MongoRepository<LeaveEntitlement, String> {

    List<LeaveEntitlement> findByEmployeeId(String employeeId);
    
}
