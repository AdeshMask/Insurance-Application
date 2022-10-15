package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.model.InsuranceClaim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceClaimRepo extends JpaRepository<InsuranceClaim,Long> {
    @Query(value = "Select * from insuranceDB.insurance_claim where claimed_status = :status",nativeQuery = true)
    InsuranceClaim findByStatus(String status);
}
