package com.example.RemotePatientMonitoringSystem02.repository.retail;

import com.example.RemotePatientMonitoringSystem02.entity.retail.SmartCustomerAnalyticsDevices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartCustomerAnalyticsRepository extends JpaRepository<SmartCustomerAnalyticsDevices, Long> {
}
