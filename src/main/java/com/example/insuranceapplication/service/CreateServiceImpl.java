package com.example.insuranceapplication.service;

import com.example.insuranceapplication.dto.CreateServiceDTO;
import com.example.insuranceapplication.model.CreateService;
import com.example.insuranceapplication.model.InsuranceCategory;
import com.example.insuranceapplication.model.User;
import com.example.insuranceapplication.repository.CreateServiceRepo;
import com.example.insuranceapplication.repository.InsuranceCategoryRepo;
import com.example.insuranceapplication.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateServiceImpl implements ICreateService{
    @Autowired
    CreateServiceRepo createServiceRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    InsuranceCategoryRepo insuranceCategoryRepo;
    @Override
    public Object create(CreateServiceDTO createServiceDTO) {
        User user = userRepo.findByName(createServiceDTO.getUserName());
        InsuranceCategory insuranceName = insuranceCategoryRepo.findByName(createServiceDTO.getInsuranceName());
        CreateService createService = new CreateService(user.getFullName(),insuranceName.getInsuranceName(),createServiceDTO);
        createServiceRepo.save(createService);
        return createService;
    }
}
