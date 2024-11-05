package com.example.RemotePatientMonitoringSystem02.repository.healthcare;

import com.example.RemotePatientMonitoringSystem02.entity.healthcare.SmartHospitalDevices;
import com.example.RemotePatientMonitoringSystem02.entity.healthcare.SmartPharmacyDevices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartPharmacyRepository extends JpaRepository<SmartPharmacyDevices, Long> {
    // You can define custom query methods here if needed
}


