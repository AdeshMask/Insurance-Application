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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

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
    private LocalDate registerddate = LocalDate.now();
    private LocalDate updateddate = LocalDate.now();
    private String userRole;
    private String email;

    public User(UserDTO userDto) {
        this.fullName = userDto.getFullName();
        this.password = userDto.getPassword();
        this.userRole = userDto.getUserRole();
        this.email = userDto.getEmail();
        this.updateddate = LocalDate.now();
        this.registerddate = LocalDate.now();
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
        this.id = id;
        this.fullName = userDto.getFullName();
        this.password = userDto.getPassword();
        this.userRole = userDto.getUserRole();
        this.email = userDto.getEmail();
        this.updateddate = LocalDate.now();
        this.registerddate = LocalDate.now();
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
