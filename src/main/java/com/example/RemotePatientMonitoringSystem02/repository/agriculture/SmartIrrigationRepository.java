package com.example.RemotePatientMonitoringSystem02.repository.agriculture;

import com.example.RemotePatientMonitoringSystem02.entity.agriculture.SmartIrrigationDevices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartIrrigationRepository extends JpaRepository<SmartIrrigationDevices, Long> {
}
