package com.example.RemotePatientMonitoringSystem02.service.realEstate;

import com.example.RemotePatientMonitoringSystem02.entity.agriculture.CropDiseaseDetectionDevices;
import com.example.RemotePatientMonitoringSystem02.entity.realEstate.SmartBuildingDevices;
import com.example.RemotePatientMonitoringSystem02.repository.realEstate.SmartBuildingRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class SmartBuildingService {

    private final SmartBuildingRepository smartBuildingRepository;

    public SmartBuildingService(SmartBuildingRepository smartBuildingRepository) {
        this.smartBuildingRepository = smartBuildingRepository;
    }

    public List<SmartBuildingDevices> getAllDevices(){
        return smartBuildingRepository.findAll();
    }

    public BigDecimal calculateTotalInvestment(List<SmartBuildingDevices> devices, List<Integer> quantities, int investmentPeriod) {
        BigDecimal totalInvestment = BigDecimal.ZERO;
        for (int i = 0; i < devices.size(); i++) {
            SmartBuildingDevices device = devices.get(i);
            int quantity = quantities.get(i) != null ? quantities.get(i) : device.getDefaultQuantity();

            // Initial investment per device type
            BigDecimal initialInvestment = BigDecimal.valueOf(quantity).multiply(device.getInitialCostPerUnit());

            // Maintenance cost over the investment period
            BigDecimal maintenanceCost = BigDecimal.valueOf(quantity).multiply(device.getAnnualMaintenanceCostPerUnit()).multiply(BigDecimal.valueOf(investmentPeriod));

            totalInvestment = totalInvestment.add(initialInvestment).add(maintenanceCost);
        }
        return totalInvestment;
    }

    public BigDecimal calculateTotalNetBenefit(List<SmartBuildingDevices> devices, List<Integer> quantities, int investmentPeriod) {
        BigDecimal totalBenefit = BigDecimal.ZERO;
        for (int i = 0; i < devices.size(); i++) {
            SmartBuildingDevices device = devices.get(i);
            int quantity = quantities.get(i) != null ? quantities.get(i) : device.getDefaultQuantity();

            // Annual benefit from sales, efficiency, and customer engagement
            BigDecimal annualBenefit = BigDecimal.valueOf(quantity).multiply(
                    device.getIncreasedSalesBenefitPerUnit()
                            .add(device.getCostSavingsFromEfficiencyPerUnit())
                            .add(device.getIncreasedCustomerEngagementBenefitPerUnit())
            );

            totalBenefit = totalBenefit.add(annualBenefit.multiply(BigDecimal.valueOf(investmentPeriod)));
        }
        return totalBenefit;
    }

    public BigDecimal calculateROI(BigDecimal totalInvestmentCosts, BigDecimal totalNetBenefit) {
        return totalNetBenefit.subtract(totalInvestmentCosts)
                .divide(totalInvestmentCosts, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100));
    }
}