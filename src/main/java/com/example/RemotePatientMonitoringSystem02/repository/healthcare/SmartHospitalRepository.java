package com.example.RemotePatientMonitoringSystem02.repository.healthcare;

import com.example.RemotePatientMonitoringSystem02.entity.healthcare.SmartHospitalDevices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartHospitalRepository extends JpaRepository<SmartHospitalDevices, Long> {
}


