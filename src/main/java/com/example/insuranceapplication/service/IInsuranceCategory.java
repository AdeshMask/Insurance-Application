package com.example.insuranceapplication.service;

import com.example.insuranceapplication.dto.InsuranceCategoryDTO;

public interface IInsuranceCategory {

    Object create(InsuranceCategoryDTO insuranceCategoryDTO);

    Object showAll();

    Object findById(Long id);

    Object update(Long id, InsuranceCategoryDTO insuranceCategoryDTO);

    Object remove(Long id);
}
