package com.example.insuranceapplication.model;

import com.example.insuranceapplication.dto.InsuranceCreateDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceCreate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "userId")
    public User userToken;
    @ManyToOne
    @JoinColumn(name = "insurance_ID")
    public InsuranceCategory insuranceID;
    public String status;
    public String monthPeriod;
//    public String registerdDate;
//    public String updatedDate;
    public boolean claimed = false;

    public InsuranceCreate(User user, InsuranceCategory insuranceCategory, String status, String monthPeriod) {
        this.userToken = user;
        this.insuranceID = insuranceCategory;
//        this.updatedDate = updatedDate;
        this.monthPeriod = monthPeriod;
        this.status = status;
//        this.registerdDate =registerdDate;
    }
    public InsuranceCreate(Long id, User user, InsuranceCategory insuranceCategory, InsuranceCreateDTO insuranceCreateDTO) {
        this.id = id;
        this.userToken = user;
        this.insuranceID = insuranceCategory;
//        this.updatedDate = insuranceCreateDTO.getUpdatedDate();
        this.monthPeriod = insuranceCreateDTO.getMonthPeriod();
        this.status = insuranceCreateDTO.getStatus();
//        this.registerdDate =insuranceCreateDTO.getRegisterdDate();
        this.claimed = insuranceCreateDTO.isClaimed();
    }
}
