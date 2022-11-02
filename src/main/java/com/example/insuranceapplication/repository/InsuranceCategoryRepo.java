package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.model.InsuranceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceCategoryRepo extends JpaRepository<InsuranceCategory,Long> {
//    @Query(value = "select * from insuranceDB.insurance_category where insurance_name = insuranceName:")
//    InsuranceCategory findByName(String insuranceName);
}
