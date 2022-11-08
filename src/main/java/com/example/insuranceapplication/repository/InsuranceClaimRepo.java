package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.model.InsuranceClaim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsuranceClaimRepo extends JpaRepository<InsuranceClaim,Long> {
    @Query(value = "Select * from insuranceDB.insurance_claim where claimed_status = :status",nativeQuery = true)
    InsuranceClaim findByStatus(String status);

    @Query(value = "Select * from insuranceDB.insurance_claim where user_id = :id",nativeQuery = true)
    List<InsuranceClaim> findByUserId(Long id);
}
