package com.example.insuranceapplication.controller;

import com.example.insuranceapplication.dto.InsuranceCategoryDTO;
import com.example.insuranceapplication.dto.LoginDto;
import com.example.insuranceapplication.dto.ResponseDTO;
import com.example.insuranceapplication.dto.UserDTO;
import com.example.insuranceapplication.service.IInsuranceCategory;
import com.example.insuranceapplication.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/insurance")
public class InsuranceCategoryController {

    @Autowired
    IInsuranceCategory iInsuranceCategory;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> create(@RequestBody InsuranceCategoryDTO insuranceCategoryDTO){
        ResponseDTO responseDTO = new ResponseDTO("User registration Successful" , iInsuranceCategory.create(insuranceCategoryDTO));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<ResponseDTO> showAll(){
        ResponseDTO responseDTO = new ResponseDTO("All User Records" , iInsuranceCategory.showAll());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getid/{id}")
    public ResponseEntity<ResponseDTO> findById(@PathVariable Long id){
        ResponseDTO responseDTO = new ResponseDTO("Found User By Id "+id , iInsuranceCategory.findById(id));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> update(@PathVariable Long id,@RequestBody InsuranceCategoryDTO insuranceCategoryDTO){
        ResponseDTO responseDTO = new ResponseDTO("Found User By Id "+id , iInsuranceCategory.update(id, insuranceCategoryDTO));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<ResponseDTO> remove(@PathVariable Long id){
        ResponseDTO responseDTO = new ResponseDTO("Record Successfully"+id , iInsuranceCategory.remove(id));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
