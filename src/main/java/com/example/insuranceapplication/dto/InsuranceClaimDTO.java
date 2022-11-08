package com.example.insuranceapplication.dto;

import com.example.insuranceapplication.model.InsuranceCategory;
import com.example.insuranceapplication.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceClaimDTO {

    Long userId;
    Long insuranceId;
    String claimedDocuments;
    String claimedStatus;
}
