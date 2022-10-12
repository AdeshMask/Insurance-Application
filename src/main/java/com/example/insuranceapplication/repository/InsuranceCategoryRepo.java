package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.model.InsuranceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceCategoryRepo extends JpaRepository<InsuranceCategory,Long> {
}
