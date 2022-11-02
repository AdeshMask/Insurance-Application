package com.example.insuranceapplication.controller;

import com.example.insuranceapplication.dto.LoginDto;
import com.example.insuranceapplication.dto.ResponseDTO;
import com.example.insuranceapplication.dto.UserDTO;
import com.example.insuranceapplication.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService iUserService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> registerUser(@RequestBody UserDTO userDTO){
        ResponseDTO responseDTO = new ResponseDTO("User registration Successful" , iUserService.registerUser(userDTO));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<ResponseDTO> showAll(){
        ResponseDTO responseDTO = new ResponseDTO("All User Records" , iUserService.showAll());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getid/{id}")
    public ResponseEntity<ResponseDTO> findById(@PathVariable Long id){
        ResponseDTO responseDTO = new ResponseDTO("Found User By Id "+id , iUserService.findById(id));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> update(@PathVariable Long id,@RequestBody UserDTO userDTO){
        ResponseDTO responseDTO = new ResponseDTO("Found User By Id "+id , iUserService.update(id, userDTO));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<ResponseDTO> remove(@PathVariable Long id){
        ResponseDTO responseDTO = new ResponseDTO("Record Successfully"+id , iUserService.remove(id));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody LoginDto loginDto){
        ResponseDTO responseDTO = new ResponseDTO("Login Successful...", iUserService.login(loginDto));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getuserByDate")
    public ResponseEntity<ResponseDTO> getUserByDate(@RequestParam String date1, @RequestParam String date2){
        ResponseDTO responseDTO = new ResponseDTO("All User Records" , iUserService.getUserByDate(date1, date2));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getuserByHealthCondition/{healthcondition}")
    public ResponseEntity<ResponseDTO> getuserByHealthCondition(@PathVariable String healthcondition){
        ResponseDTO responseDTO = new ResponseDTO("All User Records" , iUserService.getuserByHealthCondition(healthcondition));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/getuserByVehicleData/{vehicledata}")
    public ResponseEntity<ResponseDTO> getuserByVehicleData(@PathVariable String vehicledata){
        ResponseDTO responseDTO = new ResponseDTO("All User Records" , iUserService.getuserByVehicleData(vehicledata));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
