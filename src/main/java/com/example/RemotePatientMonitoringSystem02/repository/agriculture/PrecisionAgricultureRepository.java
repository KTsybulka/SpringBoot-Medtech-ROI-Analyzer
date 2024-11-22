package com.example.RemotePatientMonitoringSystem02.repository.agriculture;

import com.example.RemotePatientMonitoringSystem02.entity.agriculture.PrecisionAgricultureDevices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrecisionAgricultureRepository extends JpaRepository<PrecisionAgricultureDevices, Long> {
}
