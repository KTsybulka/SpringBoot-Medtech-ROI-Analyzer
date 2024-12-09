package com.example.RemotePatientMonitoringSystem02.service.retail;

import com.example.RemotePatientMonitoringSystem02.entity.healthcare.MedicalAssetTrackingDevices;
import com.example.RemotePatientMonitoringSystem02.entity.retail.SmartCustomerAnalyticsDevices;
import com.example.RemotePatientMonitoringSystem02.repository.retail.SmartCustomerAnalyticsRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class SmartCustomerAnalyticsService {

    private final SmartCustomerAnalyticsRepository smartCustomerAnalyticsRepository;

    public SmartCustomerAnalyticsService(SmartCustomerAnalyticsRepository smartCustomerAnalyticsRepository) {
        this.smartCustomerAnalyticsRepository = smartCustomerAnalyticsRepository;
    }

    public List<SmartCustomerAnalyticsDevices> getAllDevices(){
        return smartCustomerAnalyticsRepository.findAll();
    }

    public BigDecimal calculateTotalInvestment(List<SmartCustomerAnalyticsDevices> devices, List<Integer> quantities, int investmentPeriod) {
        BigDecimal totalInvestment = BigDecimal.ZERO;
        for (int i = 0; i < devices.size(); i++) {
            SmartCustomerAnalyticsDevices device = devices.get(i);
            int quantity = quantities.get(i) != null ? quantities.get(i) : device.getDefaultQuantity();

            // Initial investment per device type
            BigDecimal initialInvestment = BigDecimal.valueOf(quantity).multiply(device.getInitialCostPerUnit());

            // Maintenance cost over the investment period
            BigDecimal maintenanceCost = BigDecimal.valueOf(quantity).multiply(device.getAnnualMaintenanceCostPerUnit()).multiply(BigDecimal.valueOf(investmentPeriod));

            totalInvestment = totalInvestment.add(initialInvestment).add(maintenanceCost);
        }
        return totalInvestment;
    }

    public BigDecimal calculateTotalNetBenefit(List<SmartCustomerAnalyticsDevices> devices, List<Integer> quantities, int investmentPeriod) {
        BigDecimal totalBenefit = BigDecimal.ZERO;
        for (int i = 0; i < devices.size(); i++) {
            SmartCustomerAnalyticsDevices device = devices.get(i);
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

