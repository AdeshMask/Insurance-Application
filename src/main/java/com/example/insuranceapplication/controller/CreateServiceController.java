package com.example.insuranceapplication.controller;

import com.example.insuranceapplication.dto.CreateServiceDTO;
import com.example.insuranceapplication.dto.ResponseDTO;
import com.example.insuranceapplication.service.ICreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
public class CreateServiceController {

    @Autowired
    ICreateService iCreateService;
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> create(@RequestBody CreateServiceDTO createServiceDTO){
        ResponseDTO responseDTO = new ResponseDTO("Data Created",iCreateService.create(createServiceDTO));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
    }
}
