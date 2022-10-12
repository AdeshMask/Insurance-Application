package com.example.insuranceapplication.service;

import com.example.insuranceapplication.dto.InsuranceCategoryDTO;
import com.example.insuranceapplication.exceptionHandling.InsuranceExceptionHandler;
import com.example.insuranceapplication.model.InsuranceCategory;
import com.example.insuranceapplication.repository.InsuranceCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InsuranceCategoryService implements IInsuranceCategory{
    @Autowired
    InsuranceCategoryRepo insuranceCategoryRepo;


    @Override
    public Object create(InsuranceCategoryDTO insuranceCategoryDTO) {
        InsuranceCategory insuranceCategory = new InsuranceCategory(insuranceCategoryDTO);
        return insuranceCategoryRepo.save(insuranceCategory);
    }

    @Override
    public Object showAll() {
        return insuranceCategoryRepo.findAll();
    }

    @Override
    public Object findById(Long id) {
        return insuranceCategoryRepo.findById(id).orElseThrow(() -> new InsuranceExceptionHandler("Insurance Id " + id + "not found in the databse"));
    }

    @Override
    public Object update(Long id, InsuranceCategoryDTO insuranceCategoryDTO) {
        Optional<InsuranceCategory> insuranceCategory = insuranceCategoryRepo.findById(id);
        if (insuranceCategory.isPresent()){
            InsuranceCategory insuranceCategory1 = new InsuranceCategory(id,insuranceCategoryDTO);
            InsuranceCategory newInsuranceCategory = insuranceCategoryRepo.save(insuranceCategory1);
            return newInsuranceCategory;
        }
        return "Record not found with id " +id+" ";
    }

    @Override
    public Object remove(Long id) {
        Optional<InsuranceCategory> insuranceCategory = insuranceCategoryRepo.findById(id);
        if (insuranceCategory.isPresent()){
            insuranceCategoryRepo.deleteById(id);
            return "Record Delted Successful";
        }
        return "Record not found with id " +id+" ";
    }
}
