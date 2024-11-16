package com.example.RemotePatientMonitoringSystem02.repository.healthcare;

import com.example.RemotePatientMonitoringSystem02.entity.healthcare.SmartPharmacyDevices;
import com.example.RemotePatientMonitoringSystem02.entity.healthcare.TelemedicineSystemDevices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelemedicineSystemRepository extends JpaRepository<TelemedicineSystemDevices, Long> {
}


