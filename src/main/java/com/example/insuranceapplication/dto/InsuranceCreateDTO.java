package com.example.insuranceapplication.dto;

import com.example.insuranceapplication.model.InsuranceCategory;
import com.example.insuranceapplication.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceCreateDTO {

    public Long userToken;
    public Long insuranceID;
    public String status;
    public String monthPeriod;
    public String registerdDate;
    public String updatedDate;

    public boolean claimed;

}
