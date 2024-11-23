package com.example.RemotePatientMonitoringSystem02.controller.realEstate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RealEstateController {

    @GetMapping("/real-estate/real-estate-list")
    public String healthcareList() {
        return "real-estate/real-estate-list"; // Ensure the Thymeleaf template is named "healthcare-list.html"
    }
}
