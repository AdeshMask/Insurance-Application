package com.example.insuranceapplication.model;

import com.example.insuranceapplication.dto.InsuranceClaimDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceClaim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User userID;

    @ManyToOne
    @JoinColumn(name = "insurance_id")
    InsuranceCategory insurance;

    String claimedDocuments;
    String claimedStatus;


    public InsuranceClaim(User user, InsuranceCategory insuranceCategory, InsuranceClaimDTO insuranceClaimDTO) {
        this.userID = user;
        this.insurance = insuranceCategory;
        this.claimedDocuments = insuranceClaimDTO.getClaimedDocuments();
        this.claimedStatus = insuranceClaimDTO.getClaimedStatus();
    }
}
