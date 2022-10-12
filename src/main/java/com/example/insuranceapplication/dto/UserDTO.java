package com.example.insuranceapplication.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {

    private String password;
    private String fullName;
    private String permanentAddress;
    private String temporaryAddress;
    private Long mobileNumber;
    private int age;
    private String occupation;
    private String familyBackground;
    private String KYC_File;
    private String healthCondition;
    private String vehicledata;
    private String userRole;
    private String email;
    private String registerddate;
    private String updateddate;
}
