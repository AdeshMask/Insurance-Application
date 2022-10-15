package com.example.insuranceapplication.service;


import com.example.insuranceapplication.dto.InsuranceCreateDTO;

public interface IInsuranceCreateService {

    Object createInsurance(InsuranceCreateDTO insuranceCreateServiceDTO);

    Object showAll();

    Object update(Long id, InsuranceCreateDTO insuranceCreateDTO);

    Object delete(Long id);

    Object getStatus(boolean status);

    Object findById(Long id);
}
