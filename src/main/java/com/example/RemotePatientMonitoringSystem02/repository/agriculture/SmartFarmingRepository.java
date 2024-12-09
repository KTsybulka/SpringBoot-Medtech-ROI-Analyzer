package com.example.RemotePatientMonitoringSystem02.repository.agriculture;

import com.example.RemotePatientMonitoringSystem02.entity.agriculture.SmartFarmingDevices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartFarmingRepository extends JpaRepository<SmartFarmingDevices, Long> {
}
