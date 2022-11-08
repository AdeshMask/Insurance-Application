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
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User userId;
    @ManyToOne
    @JoinColumn(name = "insurance_id")
    InsuranceCategory insuranceId;
    String claimedDocuments;
    String claimedStatus;

    public InsuranceClaim(User user, InsuranceCategory insuranceCategory, String claimedDocuments, String claimedStatus) {
        this.userId = user;
        this.insuranceId = insuranceCategory;
        this.claimedDocuments = claimedDocuments;
        this.claimedStatus = claimedStatus;
    }
}
