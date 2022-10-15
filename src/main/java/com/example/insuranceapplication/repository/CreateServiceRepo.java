package com.example.insuranceapplication.repository;

import com.example.insuranceapplication.service.CreateServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreateServiceRepo extends JpaRepository<CreateServiceImpl,Long> {
}
