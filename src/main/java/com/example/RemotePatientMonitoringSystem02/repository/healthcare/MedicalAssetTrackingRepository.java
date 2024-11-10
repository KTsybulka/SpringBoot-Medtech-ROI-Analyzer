package com.example.RemotePatientMonitoringSystem02.repository.healthcare;

import com.example.RemotePatientMonitoringSystem02.entity.healthcare.MedicalAssetTrackingDevices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalAssetTrackingRepository extends JpaRepository<MedicalAssetTrackingDevices, Long> {
}
