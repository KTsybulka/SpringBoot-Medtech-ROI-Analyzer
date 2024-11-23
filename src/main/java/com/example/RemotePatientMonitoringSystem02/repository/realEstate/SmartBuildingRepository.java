package com.example.RemotePatientMonitoringSystem02.repository.realEstate;

import com.example.RemotePatientMonitoringSystem02.entity.realEstate.SmartBuildingDevices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartBuildingRepository extends JpaRepository<SmartBuildingDevices, Long> {
}
