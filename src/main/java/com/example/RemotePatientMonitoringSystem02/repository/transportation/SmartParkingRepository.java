package com.example.RemotePatientMonitoringSystem02.repository.transportation;

import com.example.RemotePatientMonitoringSystem02.entity.transportation.SmartParkingDevices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartParkingRepository extends JpaRepository<SmartParkingDevices, Long> {
}
