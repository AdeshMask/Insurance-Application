package com.example.insuranceapplication.service;

import com.example.insuranceapplication.dto.InsuranceClaimDTO;
import com.example.insuranceapplication.exceptionHandling.InsuranceExceptionHandler;
import com.example.insuranceapplication.model.InsuranceCategory;
import com.example.insuranceapplication.model.InsuranceClaim;
import com.example.insuranceapplication.model.User;
import com.example.insuranceapplication.repository.InsuranceCategoryRepo;
import com.example.insuranceapplication.repository.InsuranceClaimRepo;
import com.example.insuranceapplication.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class InsuranceClaimService implements IInsuranceClaim{

    @Autowired
    UserRepo userRepo;
    @Autowired
    InsuranceCategoryRepo insuranceCategoryRepo;
    @Autowired
    InsuranceClaimRepo insuranceClaimRepo;
    @Override
    public Object createClaim(InsuranceClaimDTO insuranceClaimDTO) {
        Optional<User> user = userRepo.findById(insuranceClaimDTO.getUserID());
        if (user.isPresent()) {
            Optional<InsuranceCategory> insuranceCategory = insuranceCategoryRepo.findById(insuranceClaimDTO.getInsurance());
            if (insuranceCategory.isPresent()) {
                InsuranceClaim insuranceClaim = new InsuranceClaim(user.get(),insuranceCategory.get(),insuranceClaimDTO);
                return insuranceClaimRepo.save(insuranceClaim);
            }
            throw (new InsuranceExceptionHandler("Insurance not found"));
        }
        throw (new InsuranceExceptionHandler("User Not Found"));
    }

    @Override
    public Object getAll() {
        return insuranceClaimRepo.findAll();
    }

    @Override
    public Object getById(Long id) {
        return insuranceClaimRepo.findById(id).orElseThrow(() -> new InsuranceExceptionHandler("Record Not Found"));
    }

    @Override
    public Object deleteById(Long id) {
        Optional<InsuranceClaim> insuranceClaim = insuranceClaimRepo.findById(id);
        if (insuranceClaim.isPresent()) {
            insuranceClaimRepo.deleteById(id);
            return "Record Deleted Successfully";
        }
        throw (new InsuranceExceptionHandler("Record Not Found"));
    }

    @Override
    public Object getByStatus(String status) {
        InsuranceClaim insuranceClaim = insuranceClaimRepo.findByStatus(status);
        return insuranceClaim;
    }
}
