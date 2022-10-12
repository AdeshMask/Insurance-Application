package com.example.insuranceapplication.model;

import com.example.insuranceapplication.dto.InsuranceCategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String insuranceName;
    private String insuranceStatus;
    private String insurance_Scheme;
    private LocalDate registered_date = LocalDate.now();
    private LocalDate updated_date = LocalDate.now();
    private String insurance_code;

    public InsuranceCategory(InsuranceCategoryDTO insuranceCategoryDTO) {
        this.insuranceName = insuranceCategoryDTO.getInsuranceName();
        this.insuranceStatus = insuranceCategoryDTO.getInsuranceStatus();
        this.insurance_Scheme = insuranceCategoryDTO.getInsurance_Scheme();
        this.registered_date = LocalDate.now();
        this.updated_date = LocalDate.now();
        this.insurance_code = insuranceCategoryDTO.getInsurance_code();
    }

    public InsuranceCategory(Long id, InsuranceCategoryDTO insuranceCategoryDTO) {
        this.id = id;
        this.insuranceName = insuranceCategoryDTO.getInsuranceName();
        this.insuranceStatus = insuranceCategoryDTO.getInsuranceStatus();
        this.insurance_Scheme = insuranceCategoryDTO.getInsurance_Scheme();
        this.registered_date = LocalDate.now();
        this.updated_date = LocalDate.now();
        this.insurance_code = insuranceCategoryDTO.getInsurance_code();
    }
}
