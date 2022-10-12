package com.example.insuranceapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceCategoryDTO {

    public String insuranceName;
    public String insuranceStatus;
    public String insurance_Scheme;
    public String insurance_code;
}
