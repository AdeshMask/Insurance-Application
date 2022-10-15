package com.example.insuranceapplication.controller;

import com.example.insuranceapplication.dto.InsuranceCategoryDTO;
import com.example.insuranceapplication.dto.InsuranceCreateDTO;
import com.example.insuranceapplication.dto.ResponseDTO;
import com.example.insuranceapplication.model.InsuranceCreate;
import com.example.insuranceapplication.service.IInsuranceCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/create")
public class InsuranceCreateController {
    @Autowired
    IInsuranceCreateService iInsuranceCreateService;
        @PostMapping("/add")
    public ResponseEntity<ResponseDTO> createInsurance(@RequestBody InsuranceCreateDTO insuranceCreateDTO){
        ResponseDTO responseDTO = new ResponseDTO("Insurance Created Successfully",iInsuranceCreateService.createInsurance(insuranceCreateDTO));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<ResponseDTO> showAll(){
        ResponseDTO responseDTO = new ResponseDTO("All records",iInsuranceCreateService.showAll());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseDTO> getById(@PathVariable Long id){
            ResponseDTO responseDTO = new ResponseDTO("Found Record By Id",iInsuranceCreateService.findById(id));
            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> update(@PathVariable Long id,@RequestBody InsuranceCreateDTO insuranceCreateDTO){
        ResponseDTO responseDTO = new ResponseDTO("Found User By Id "+id , iInsuranceCreateService.update(id, insuranceCreateDTO));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable Long id){
        ResponseDTO responseDTO = new ResponseDTO("Record Deleted",iInsuranceCreateService.delete(id));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/getByStatus/{status}")
    public ResponseEntity<ResponseDTO> getByStatus(@PathVariable boolean status){
            ResponseDTO responseDTO = new ResponseDTO("Record By Status",iInsuranceCreateService.getStatus(status));
            return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
}
