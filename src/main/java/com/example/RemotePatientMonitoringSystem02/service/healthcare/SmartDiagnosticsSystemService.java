package com.example.RemotePatientMonitoringSystem02.service.healthcare;

import com.example.RemotePatientMonitoringSystem02.entity.healthcare.RemotePatientMonitoringDevices;
import com.example.RemotePatientMonitoringSystem02.entity.healthcare.SmartDiagnosticsSystemDevices;
import com.example.RemotePatientMonitoringSystem02.entity.healthcare.SmartHospitalDevices;
import com.example.RemotePatientMonitoringSystem02.repository.healthcare.SmartDiagnosticsSystemRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class SmartDiagnosticsSystemService {

    private final SmartDiagnosticsSystemRepository smartDiagnosticsSystemRepository;

    public SmartDiagnosticsSystemService(SmartDiagnosticsSystemRepository smartDiagnosticsSystemRepository) {
        this.smartDiagnosticsSystemRepository = smartDiagnosticsSystemRepository;
    }

    public List<SmartDiagnosticsSystemDevices> getAllDevices() {
        return smartDiagnosticsSystemRepository.findAll();
    }

    public BigDecimal calculateTotalInvestment(List<SmartDiagnosticsSystemDevices> devices, List<Integer> quantities, int investmentPeriod) {
        BigDecimal totalInvestment = BigDecimal.ZERO;
        for (int i = 0; i < devices.size(); i++) {
            SmartDiagnosticsSystemDevices device = devices.get(i);
            int quantity = quantities.get(i) != null ? quantities.get(i) : device.getDefaultQuantity();

            // Initial investment per device type
            BigDecimal initialInvestment = BigDecimal.valueOf(quantity).multiply(device.getInitialCostPerUnit());

            // Maintenance cost over the investment period
            BigDecimal maintenanceCost = BigDecimal.valueOf(quantity).multiply(device.getAnnualMaintenanceCostPerUnit()).multiply(BigDecimal.valueOf(investmentPeriod));

            totalInvestment = totalInvestment.add(initialInvestment).add(maintenanceCost);
        }
        return totalInvestment;
    }

    public BigDecimal calculateTotalNetBenefit(List<SmartDiagnosticsSystemDevices> devices, List<Integer> quantities, int investmentPeriod) {
        BigDecimal totalBenefit = BigDecimal.ZERO;
        for (int i = 0; i < devices.size(); i++) {
            SmartDiagnosticsSystemDevices device = devices.get(i);
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
