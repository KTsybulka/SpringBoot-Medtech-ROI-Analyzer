package com.example.RemotePatientMonitoringSystem02.controller.agriculture;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AgricultureController {
    @GetMapping("/agriculture/agriculture-list")
    public String healthcareList() {
        return "agriculture/agriculture-list"; // Ensure the Thymeleaf template is named "healthcare-list.html"
    }
}
