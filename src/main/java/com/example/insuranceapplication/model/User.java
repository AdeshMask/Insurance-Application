package com.example.insuranceapplication.model;

import com.example.insuranceapplication.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long userId;

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
    private String registerddate;
    private String updateddate;
    private String userRole;
    private String email;

    public User(UserDTO userDto) {
        this.fullName = userDto.getFullName();
        this.password = userDto.getPassword();
        this.userRole = userDto.getUserRole();
        this.email = userDto.getEmail();
        this.updateddate = userDto.getUpdateddate();
        this.registerddate = userDto.getRegisterddate();
        this.vehicledata = userDto.getVehicledata();
        this.healthCondition = userDto.getHealthCondition();
        this.KYC_File = userDto.getKYC_File();
        this.familyBackground = userDto.getFamilyBackground();
        this.occupation = userDto.getOccupation();
        this.occupation = userDto.getOccupation();
        this.age = userDto.getAge();
        this.mobileNumber = userDto.getMobileNumber();
        this.temporaryAddress = userDto.getTemporaryAddress();
        this.permanentAddress = userDto.getPermanentAddress();
    }

    public User(Long id, UserDTO userDto) {
        this.userId = id;
        this.fullName = userDto.getFullName();
        this.password = userDto.getPassword();
        this.userRole = userDto.getUserRole();
        this.email = userDto.getEmail();
        this.updateddate = userDto.getUpdateddate();
        this.registerddate = userDto.getRegisterddate();
        this.vehicledata = userDto.getVehicledata();
        this.healthCondition = userDto.getHealthCondition();
        this.KYC_File = userDto.getKYC_File();
        this.familyBackground = userDto.getFamilyBackground();
        this.occupation = userDto.getOccupation();
        this.occupation = userDto.getOccupation();
        this.age = userDto.getAge();
        this.mobileNumber = userDto.getMobileNumber();
        this.temporaryAddress = userDto.getTemporaryAddress();
        this.permanentAddress = userDto.getPermanentAddress();
    }
}
