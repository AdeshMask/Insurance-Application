package com.example.insuranceapplication.controller;

import com.example.insuranceapplication.dto.InsuranceClaimDTO;
import com.example.insuranceapplication.dto.ResponseDTO;
import com.example.insuranceapplication.service.IInsuranceClaim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
@RequestMapping("/claim")
public class InsuranceClaimController {

    @Autowired
    IInsuranceClaim insuranceClaim;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> create(@RequestBody InsuranceClaimDTO insuranceClaimDTO){
        ResponseDTO responseDTO = new ResponseDTO("Claim Created" ,insuranceClaim.createClaim(insuranceClaimDTO));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
    }
    @GetMapping("/getall")
    public ResponseEntity<ResponseDTO> getAll(){
        ResponseDTO responseDTO = new ResponseDTO("Displaying all records", insuranceClaim.getAll());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseDTO> getById(@PathVariable Long id){
        ResponseDTO responseDTO = new ResponseDTO("Record By Id",insuranceClaim.getById(id));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable Long id){
        ResponseDTO responseDTO = new ResponseDTO("Deleted Record by Id",insuranceClaim.deleteById(id));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/getbystatus/{status}")
    public ResponseEntity<ResponseDTO> getByStatus(@PathVariable String status){
        ResponseDTO responseDTO = new ResponseDTO("Record Found By Status",insuranceClaim.getByStatus(status));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
