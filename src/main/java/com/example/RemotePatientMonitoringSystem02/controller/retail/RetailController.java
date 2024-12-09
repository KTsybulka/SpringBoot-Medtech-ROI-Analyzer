package com.example.RemotePatientMonitoringSystem02.controller.retail;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RetailController {
    @GetMapping("/retail/retail-list")
    public String healthcareList() {
        return "retail/retail-list"; // Ensure the Thymeleaf template is named "healthcare-list.html"
    }
}
