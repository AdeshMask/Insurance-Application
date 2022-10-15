package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.model.InsuranceCreate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsuranceCreateRepo extends JpaRepository<InsuranceCreate, Long> {
    @Query(value = "Select * from insuranceDB.insurance_create where claimed = :status",nativeQuery = true)
    List<InsuranceCreate> getStatus(boolean status);
}
