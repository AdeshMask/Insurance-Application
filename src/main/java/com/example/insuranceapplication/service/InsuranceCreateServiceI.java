package com.example.insuranceapplication.service;

import com.example.insuranceapplication.dto.InsuranceCreateDTO;
import com.example.insuranceapplication.exceptionHandling.InsuranceExceptionHandler;
import com.example.insuranceapplication.model.InsuranceCategory;
import com.example.insuranceapplication.model.InsuranceCreate;
import com.example.insuranceapplication.model.User;
import com.example.insuranceapplication.repository.InsuranceCategoryRepo;
import com.example.insuranceapplication.repository.InsuranceCreateRepo;
import com.example.insuranceapplication.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsuranceCreateServiceI implements IInsuranceCreateService{
    @Autowired
    InsuranceCreateRepo insuranceCreateServiceRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    IUserService iUserService;
    @Autowired
    InsuranceCategoryRepo insuranceCategoryRepo;
    @Override
    public Object createInsurance(InsuranceCreateDTO insuranceCreateDTO) {
        Optional<User> user = userRepo.findById(insuranceCreateDTO.userToken);
        Optional<InsuranceCategory> insuranceCategory = insuranceCategoryRepo.findById(insuranceCreateDTO.insuranceID);
        if (insuranceCategory.isPresent() && user.isPresent()) {
            InsuranceCreate insuranceCreateService = new InsuranceCreate(user.get(), insuranceCategory.get(), insuranceCreateDTO.status
                    , insuranceCreateDTO.monthPeriod, insuranceCreateDTO.registerdDate, insuranceCreateDTO.updatedDate);
            return insuranceCreateServiceRepo.save(insuranceCreateService);
        }
        throw new InsuranceExceptionHandler("User Or Insurance Id not found");
    }

    @Override
    public Object showAll() {
        return insuranceCreateServiceRepo.findAll();
    }

    @Override
    public Object update(Long id, InsuranceCreateDTO insuranceCreateDTO) {
        Optional<InsuranceCreate> insuranceCreate = insuranceCreateServiceRepo.findById(id);
        Optional<User> user = userRepo.findById(insuranceCreateDTO.userToken);
        Optional<InsuranceCategory> insurance = insuranceCategoryRepo.findById(insuranceCreateDTO.getInsuranceID());
        if (insuranceCreate.isPresent()) {
            InsuranceCreate insuranceCreateService = new InsuranceCreate(id,user.get(),insurance.get(),insuranceCreateDTO);
            return insuranceCreateServiceRepo.save(insuranceCreateService);
        }
        throw new InsuranceExceptionHandler("User Or Insurance Id not found");
    }

    @Override
    public Object delete(Long id) {
        Optional<InsuranceCreate> insuranceCreate = insuranceCreateServiceRepo.findById(id);
        if (insuranceCreate.isPresent()){
            insuranceCreateServiceRepo.deleteById(id);
            return "Record Delted Successful";
        }
        return "Record not found with id " +id+" ";

    }

    @Override
    public Object getStatus(boolean status) {
        List<InsuranceCreate> insuranceCreate = insuranceCreateServiceRepo.getStatus(status);
        return insuranceCreate;
    }

    @Override
    public Object findById(Long id) {
        return insuranceCreateServiceRepo.findById(id).orElseThrow(()-> new InsuranceExceptionHandler("record Not Found"));
    }
}
