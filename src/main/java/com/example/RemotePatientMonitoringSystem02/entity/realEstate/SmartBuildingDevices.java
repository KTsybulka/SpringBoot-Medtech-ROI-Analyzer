package com.example.RemotePatientMonitoringSystem02.entity.realEstate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SmartBuildingDevices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deviceType;

    @PositiveOrZero(message = "Quantity must be a non-negative integer. Please enter a valid quantity.")
    private int defaultQuantity;
    private BigDecimal initialCostPerUnit;
    private BigDecimal annualMaintenanceCostPerUnit;
    private BigDecimal increasedSalesBenefitPerUnit;
    private BigDecimal costSavingsFromEfficiencyPerUnit;
    private BigDecimal increasedCustomerEngagementBenefitPerUnit;
    private String deviceDescription;
}
