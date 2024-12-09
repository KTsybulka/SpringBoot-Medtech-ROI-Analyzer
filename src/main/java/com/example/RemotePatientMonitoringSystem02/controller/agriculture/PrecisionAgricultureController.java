package com.example.RemotePatientMonitoringSystem02.controller.agriculture;

import com.example.RemotePatientMonitoringSystem02.controller.healthcare.MedicalAssetTrackingController;
import com.example.RemotePatientMonitoringSystem02.entity.agriculture.LivestockMonitoringDevices;
import com.example.RemotePatientMonitoringSystem02.entity.agriculture.PrecisionAgricultureDevices;
import com.example.RemotePatientMonitoringSystem02.service.agriculture.PrecisionAgricultureService;
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
public class PrecisionAgricultureController {
    private final PrecisionAgricultureService precisionAgricultureService;

    public PrecisionAgricultureController(PrecisionAgricultureService precisionAgricultureService) {
        this.precisionAgricultureService = precisionAgricultureService;
    }

    @GetMapping("/agriculture/precision-agriculture-form")
    public String showForm(Model model) {
        List<PrecisionAgricultureDevices> devices = precisionAgricultureService.getAllDevices();
        model.addAttribute("devices", devices);
        model.addAttribute("dynamicUrl", "/precision-agriculture/calculate-roi");
        model.addAttribute("pageFormTitle", "Precision Aagriculture ROI Calculation");
        return "healthcare/healthcare-list-form";
    }

    @PostMapping("/precision-agriculture/calculate-roi")
    public String calculateROI(@RequestParam("quantities") String[] quantities,
                               @RequestParam("investmentPeriod") int investmentPeriod,
                               Model model) {

        Logger logger = LoggerFactory.getLogger(PrecisionAgricultureController.class);

        List<PrecisionAgricultureDevices> devices = precisionAgricultureService.getAllDevices();
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
        BigDecimal totalInvestmentCosts = precisionAgricultureService.calculateTotalInvestment(devices, finalQuantities, investmentPeriod);
        BigDecimal totalNetBenefit = precisionAgricultureService.calculateTotalNetBenefit(devices, finalQuantities, investmentPeriod);
        BigDecimal roi = precisionAgricultureService.calculateROI(totalInvestmentCosts, totalNetBenefit);

        // Add calculated values to the model for display on the results page
        model.addAttribute("totalInvestmentCosts", totalInvestmentCosts);
        model.addAttribute("totalNetBenefit", totalNetBenefit);
        model.addAttribute("investmentPeriod", investmentPeriod);
        model.addAttribute("roi", roi);

        // Add cache-busting version (timestamp)
        model.addAttribute("imageVersion", System.currentTimeMillis());
        model.addAttribute("pageResultTitle", "Precision Agriculture ROI Calculation Results");


        String chartPath = "/precision-agriculture/chart?imageName=precision-agriculture_chart.png";
        model.addAttribute("chartPath", chartPath);

        //link to back to form
        String backToFormPath= "/agriculture/precision-agriculture-form";
        model.addAttribute("backToFormPath", backToFormPath);

        // Generate the bar chart
        generateBarChart(totalInvestmentCosts, totalNetBenefit);

        // Return the view name
        return "healthcare/healthcare-ROI-result";
    }

    // New method to serve the image
    @GetMapping("/precision-agriculture/chart")
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
        CategoryDataset dataset = createDataset(totalInvestmentCosts, totalNetBenefit);

        JFreeChart barChart = ChartFactory.createBarChart(
                "ROI Analysis",
                "Category",
                "Amount ($)",
                dataset
        );

        try {
            // Ensure the directory exists
            File directory = new File("src/main/resources/static/images/");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Save the chart as an image file
            File chartFile = new File(directory, "precision-agriculture_chart.png");
            ChartUtils.saveChartAsPNG(chartFile, barChart, 500, 300);

            // Log the file path
            Logger logger = LoggerFactory.getLogger(MedicalAssetTrackingController.class);
            logger.info("Chart saved at: " + chartFile.getAbsolutePath());
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
