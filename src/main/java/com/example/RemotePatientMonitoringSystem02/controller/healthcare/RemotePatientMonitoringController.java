package com.example.RemotePatientMonitoringSystem02.controller.healthcare;

import com.example.RemotePatientMonitoringSystem02.entity.healthcare.RemotePatientMonitoringDevices;
import com.example.RemotePatientMonitoringSystem02.service.healthcare.PdfReportService;
import com.example.RemotePatientMonitoringSystem02.service.healthcare.RemotePatientMonitoringService;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class RemotePatientMonitoringController {

    @Autowired
    private RemotePatientMonitoringService rpmService;
    private PdfReportService pdfReportService;

    public RemotePatientMonitoringController(RemotePatientMonitoringService rpmService, PdfReportService pdfReportService) {
        this.rpmService = rpmService;
        this.pdfReportService = pdfReportService;
    }

    @GetMapping("/")
    public String showIndustriesList() {
        return "industries-list";
    }

    @GetMapping("/healthcare/healthcare-list")
    public String showHealthcareList(Model model) {
        return "healthcare/healthcare-list"; // Name of the HTML file without extension
    }

    @GetMapping("/healthcare/remote-patient-monitoring-form")
    public String showForm(Model model) {
        List<RemotePatientMonitoringDevices> devices = rpmService.getAllDevices();
        model.addAttribute("devices", devices);
        model.addAttribute("dynamicUrl", "/rpm/calculate-roi");
        model.addAttribute("pageFormTitle", "Remote Patient Monitoring ROI Calculator");
        return "healthcare/remote-patient-monitoring-form";
    }


    @PostMapping("/rpm/calculate-roi")
    public String calculateROI(@RequestParam("quantities") String[] quantities,
                               @RequestParam("investmentPeriod") int investmentPeriod,
                               Model model) {

        Logger logger = LoggerFactory.getLogger(RemotePatientMonitoringController.class);

        List<RemotePatientMonitoringDevices> devices = rpmService.getAllDevices();
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
        BigDecimal totalInvestmentCosts = rpmService.calculateTotalInvestment(devices, finalQuantities, investmentPeriod);
        BigDecimal totalNetBenefit = rpmService.calculateTotalNetBenefit(devices, finalQuantities, investmentPeriod);
        BigDecimal roi = rpmService.calculateROI(totalInvestmentCosts, totalNetBenefit);

        // Add calculated values to the model for display on the results page
        model.addAttribute("totalInvestmentCosts", totalInvestmentCosts);
        model.addAttribute("totalNetBenefit", totalNetBenefit);
        model.addAttribute("investmentPeriod", investmentPeriod);
        model.addAttribute("roi", roi);

        // Add cache-busting version (timestamp)
        model.addAttribute("imageVersion", System.currentTimeMillis());
        model.addAttribute("pageResultTitle", "Remote Patient Monitoring ROI Calculation Results");

        String chartPath = "/rpm/chart?imageName=rpm_chart.png"; // Use query parameter for the image name
        model.addAttribute("chartPath", chartPath);


        //link to back to form
        String backToFormPath= "/healthcare/remote-patient-monitoring-form";
        model.addAttribute("backToFormPath", backToFormPath);
//        model.addAttribute("chartPath", "/rpm/chart(imageName='rpm_chart.png')");
        // Generate the bar chart
        generateBarChart(totalInvestmentCosts, totalNetBenefit);

        // Return the view name
        return "healthcare/remote-patient-monitoring-ROI";
    }


    // New method to serve the image
    @GetMapping("/rpm/chart")
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
            ChartUtils.saveChartAsPNG(new File("src/main/resources/static/images/rpm_chart.png"), barChart, 500, 300);
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



    @GetMapping("/rpm/generate-pdf")
    public ResponseEntity<byte[]> generatePdfReport(@RequestParam("quantities") String[] quantities,
                                                    @RequestParam("investmentPeriod") int investmentPeriod) {
        List<RemotePatientMonitoringDevices> devices = rpmService.getAllDevices();
        List<Integer> finalQuantities = new ArrayList<>();

        for (int i = 0; i < devices.size(); i++) {
            String quantityStr = (i < quantities.length) ? quantities[i] : "";
            int quantity;
            try {
                quantity = (quantityStr == null || quantityStr.isEmpty()) ? devices.get(i).getDefaultQuantity() : Integer.parseInt(quantityStr);
            } catch (NumberFormatException e) {
                quantity = devices.get(i).getDefaultQuantity();
            }
            finalQuantities.add(quantity);
        }

        BigDecimal totalInvestmentCosts = rpmService.calculateTotalInvestment(devices, finalQuantities, investmentPeriod);
        BigDecimal totalNetBenefit = rpmService.calculateTotalNetBenefit(devices, finalQuantities, investmentPeriod);
        BigDecimal roi = rpmService.calculateROI(totalInvestmentCosts, totalNetBenefit);

        String title = "Remote Patient Monitoring ROI Report";
        String content = "Total Investment Costs: " + totalInvestmentCosts + "\n" +
                "Total Net Benefit: " + totalNetBenefit + "\n" +
                "ROI: " + roi;

        byte[] pdfBytes = pdfReportService.generateReport(title, content);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=roi_report.pdf");
        headers.add(HttpHeaders.CONTENT_TYPE, "application/pdf");

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }
}