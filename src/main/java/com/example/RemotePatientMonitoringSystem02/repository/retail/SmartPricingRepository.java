package com.example.RemotePatientMonitoringSystem02.repository.retail;

import com.example.RemotePatientMonitoringSystem02.entity.retail.SmartPricingDevices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartPricingRepository extends JpaRepository<SmartPricingDevices, Long> {
}
