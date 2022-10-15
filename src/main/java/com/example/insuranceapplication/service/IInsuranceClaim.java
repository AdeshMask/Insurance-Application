package com.example.insuranceapplication.service;

import com.example.insuranceapplication.dto.InsuranceClaimDTO;

public interface IInsuranceClaim {

    Object createClaim(InsuranceClaimDTO insuranceClaimDTO);

    Object getAll();

    Object getById(Long id);

    Object deleteById(Long id);

    Object getByStatus(String status);
}
