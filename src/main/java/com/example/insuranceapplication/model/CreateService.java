package com.example.insuranceapplication.model;

import com.example.insuranceapplication.dto.CreateServiceDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CreateService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "full_name_id")
    User fullName;
    @ManyToOne
    @JoinColumn(name = "insurance_name_id")
    InsuranceCategory insuranceName;
    String status;


    public CreateService(User fullName, InsuranceCategory insuranceName, CreateServiceDTO createServiceDTO) {
        this.fullName = fullName;
        this.insuranceName = insuranceName;
        this.status = createServiceDTO.getStatus();
    }
}
