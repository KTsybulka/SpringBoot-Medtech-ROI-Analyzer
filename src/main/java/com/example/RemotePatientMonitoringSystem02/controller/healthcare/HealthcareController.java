package com.example.RemotePatientMonitoringSystem02.controller.healthcare;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HealthcareController {
    @GetMapping("/healthcare/healthcare-list")
    public String healthcareList() {
        return "healthcare/healthcare-list"; // Ensure the Thymeleaf template is named "healthcare-list.html"
    }
}
