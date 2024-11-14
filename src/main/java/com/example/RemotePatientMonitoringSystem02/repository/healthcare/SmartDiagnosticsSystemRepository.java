package com.example.RemotePatientMonitoringSystem02.repository.healthcare;

import com.example.RemotePatientMonitoringSystem02.entity.healthcare.SmartDiagnosticsSystemDevices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartDiagnosticsSystemRepository extends JpaRepository<SmartDiagnosticsSystemDevices, Long> {
}
