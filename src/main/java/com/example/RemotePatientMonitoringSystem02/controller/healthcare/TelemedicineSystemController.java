package com.example.RemotePatientMonitoringSystem02.controller.healthcare;

import com.example.RemotePatientMonitoringSystem02.entity.healthcare.SmartPharmacyDevices;
import com.example.RemotePatientMonitoringSystem02.entity.healthcare.TelemedicineSystemDevices;
import com.example.RemotePatientMonitoringSystem02.service.healthcare.TelemedicineSystemService;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class TelemedicineSystemController {

    private final TelemedicineSystemService telemedicineSystemService;

    public TelemedicineSystemController(TelemedicineSystemService telemedicineSystemService) {
        this.telemedicineSystemService = telemedicineSystemService;
    }

    @GetMapping("/healthcare/telemedicine-system-form")
    public String showForm(Model model) {
        List<TelemedicineSystemDevices> devices =  telemedicineSystemService.getAllDevices();
        model.addAttribute("devices", devices);
        model.addAttribute("dynamicUrl", "/telemedicine-system/calculate-roi");
        model.addAttribute("pageFormTitle", "Telemedicine System ROI Calculation");
        return "healthcare/healthcare-list-form";
    }

    @PostMapping("/telemedicine-system/calculate-roi")
    public String calculateROI(@RequestParam("quantities") String[] quantities,
                               @RequestParam("investmentPeriod") int investmentPeriod,
                               Model model) {

        Logger logger = LoggerFactory.getLogger(TelemedicineSystemController.class);

        List<TelemedicineSystemDevices> devices = telemedicineSystemService.getAllDevices();
        List<Integer> finalQuantities = new ArrayList<>();

        logger.info("Received quantities: {}", Arrays.toString(quantities));
        logger.info("Received investmentPeriod: {}", investmentPeriod);

        // Process each input quantity, using default quantity if input is blank or invalid
        for (int i = 0; i < devices.size(); i++) {
            String quantityStr = (i < quantities.length) ? quantities[i] : "";
            int quantity;
            try {
                quantity = (quantityStr == null || quantityStr.isEmpty()) ? devices.get(i).getDefaultQuantity() : Integer.parseInt(quantityStr);
            } catch (NumberFormatException e) {
                logger.error("Invalid quantity format for device {}: {}", quantityStr, e);
                quantity = devices.get(i).getDefaultQuantity();
            }
            finalQuantities.add(quantity);
        }

        // Perform ROI calculation
        BigDecimal totalInvestmentCosts = telemedicineSystemService.calculateTotalInvestment(devices, finalQuantities, investmentPeriod);
        BigDecimal totalNetBenefit = telemedicineSystemService.calculateTotalNetBenefit(devices, finalQuantities, investmentPeriod);
        BigDecimal roi = telemedicineSystemService.calculateROI(totalInvestmentCosts, totalNetBenefit);

        // Add calculated values to the model for display on the results page
        model.addAttribute("totalInvestmentCosts", totalInvestmentCosts);
        model.addAttribute("totalNetBenefit", totalNetBenefit);
        model.addAttribute("investmentPeriod", investmentPeriod);
        model.addAttribute("roi", roi);

        // Add cache-busting version (timestamp)
        model.addAttribute("imageVersion", System.currentTimeMillis());
        model.addAttribute("pageResultTitle", "Telemedicine System ROI Calculation Results");

        String chartPath = "/telemedicine-system/chart?imageName=telemedicine_system_chart.png";
        model.addAttribute("chartPath", chartPath);

        //link to back to form
        String backToFormPath= "/healthcare/telemedicine-system-form";
        model.addAttribute("backToFormPath", backToFormPath);

        // Generate the bar chart
        generateBarChart(totalInvestmentCosts, totalNetBenefit);

        // Return the view name
        return "healthcare/healthcare-ROI-result";
    }

    // New method to serve the image
    @GetMapping("/telemedicine-system/chart")
    public ResponseEntity<FileSystemResource> getChart(@RequestParam("imageName") String imageName) {
        File imageFile = new File("src/main/resources/static/images/" + imageName);

        // Add headers to prevent caching
        HttpHeaders headers = new HttpHeaders();
        headers.setCacheControl("no-store, no-cache, must-revalidate, proxy-revalidate");
        headers.setPragma("no-cache");
        headers.setExpires(0L);

        FileSystemResource resource = new FileSystemResource(imageFile);

        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }

    // Method to generate the bar chart
    private void generateBarChart(BigDecimal totalInvestmentCosts, BigDecimal totalNetBenefit) {
        CategoryDataset dataset = createDataset(totalInvestmentCosts,totalNetBenefit);

        JFreeChart barChart = ChartFactory.createBarChart(
                "ROI Analysis",
                "Category",
                "Amount ($)",
                dataset
        );

        try {
            // Save the chart as an image file
            ChartUtils.saveChartAsPNG(new File("src/main/resources/static/images/telemedicine_system_chart.png"), barChart, 500, 300);
        } catch (IOException e) {
            e.printStackTrace(); // Handle exceptions appropriately in production
        }
    }

    // Method to create the dataset for the bar chart_two valueas
    private CategoryDataset createDataset(BigDecimal totalInvestmentCosts, BigDecimal totalNetBenefiti) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(totalInvestmentCosts, "Costs", "Total Investment Costs");
        dataset.addValue(totalNetBenefiti, "Benefits", "Total Net Benefit");
        return dataset;
    }
}
