package com.example.RemotePatientMonitoringSystem02.service.agriculture;

import com.example.RemotePatientMonitoringSystem02.entity.agriculture.CropDiseaseDetectionDevices;
import com.example.RemotePatientMonitoringSystem02.entity.agriculture.SmartIrrigationDevices;
import com.example.RemotePatientMonitoringSystem02.repository.agriculture.SmartIrrigationRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class SmartIrrigationService {

    private final SmartIrrigationRepository smartIrrigationRepository;

    public SmartIrrigationService(SmartIrrigationRepository smartIrrigationRepository) {
        this.smartIrrigationRepository = smartIrrigationRepository;
    }

    public List<SmartIrrigationDevices> getAllDevices(){
        return smartIrrigationRepository.findAll();
    }

    public BigDecimal calculateTotalInvestment(List<SmartIrrigationDevices> devices, List<Integer> quantities, int investmentPeriod) {
        BigDecimal totalInvestment = BigDecimal.ZERO;
        for (int i = 0; i < devices.size(); i++) {
            SmartIrrigationDevices device = devices.get(i);
            int quantity = quantities.get(i) != null ? quantities.get(i) : device.getDefaultQuantity();

            // Initial investment per device type
            BigDecimal initialInvestment = BigDecimal.valueOf(quantity).multiply(device.getInitialCostPerUnit());

            // Maintenance cost over the investment period
            BigDecimal maintenanceCost = BigDecimal.valueOf(quantity).multiply(device.getAnnualMaintenanceCostPerUnit()).multiply(BigDecimal.valueOf(investmentPeriod));

            totalInvestment = totalInvestment.add(initialInvestment).add(maintenanceCost);
        }
        return totalInvestment;
    }

    public BigDecimal calculateTotalNetBenefit(List<SmartIrrigationDevices> devices, List<Integer> quantities, int investmentPeriod) {
        BigDecimal totalBenefit = BigDecimal.ZERO;
        for (int i = 0; i < devices.size(); i++) {
            SmartIrrigationDevices device = devices.get(i);
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
