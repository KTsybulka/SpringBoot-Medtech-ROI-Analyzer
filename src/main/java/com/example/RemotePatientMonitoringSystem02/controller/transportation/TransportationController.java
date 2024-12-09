package com.example.RemotePatientMonitoringSystem02.controller.transportation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TransportationController {
    @GetMapping("/transportation/transportation-list")
    public String healthcareList() {
        return "transportation/transportation-list"; // Ensure the Thymeleaf template is named "healthcare-list.html"
    }
}
