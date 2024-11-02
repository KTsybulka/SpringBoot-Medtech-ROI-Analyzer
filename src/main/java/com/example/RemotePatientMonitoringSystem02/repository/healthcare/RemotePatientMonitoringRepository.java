package com.example.RemotePatientMonitoringSystem02.repository.healthcare;

import com.example.RemotePatientMonitoringSystem02.entity.healthcare.RemotePatientMonitoringDevices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemotePatientMonitoringRepository extends JpaRepository<RemotePatientMonitoringDevices, Long> {
    // You can define custom query methods here if needed
}


