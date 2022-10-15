package com.example.insuranceapplication.service;

import com.example.insuranceapplication.dto.LoginDto;
import com.example.insuranceapplication.dto.UserDTO;

public interface IUserService {
    Object registerUser(UserDTO userDTO);

    Object showAll();

    Object findById(Long id);

    Object update(Long id, UserDTO userDTO);

    String remove(Long id);

    Object login(LoginDto loginDto);

    Object getUserByDate(String date1, String date2);

    Object getuserByHealthCondition(String healthcondition);

    Object getuserByVehicleData(String vehicledata);
}
