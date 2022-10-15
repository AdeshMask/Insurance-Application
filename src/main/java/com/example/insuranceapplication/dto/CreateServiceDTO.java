package com.example.insuranceapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateServiceDTO {
    String userName;
    String insuranceName;
    String status;
}
