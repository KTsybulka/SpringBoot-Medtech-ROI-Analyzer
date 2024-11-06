package com.example.RemotePatientMonitoringSystem02.service.healthcare;

import org.springframework.stereotype.Service;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;
@Service
public class PdfReportService {

    public byte[] generateReport(String title, String content) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(byteArrayOutputStream);
        Document document = new Document(new com.itextpdf.kernel.pdf.PdfDocument(writer));

        document.add(new Paragraph(title));
        document.add(new Paragraph(content));

        document.close();
        return byteArrayOutputStream.toByteArray();
    }
}
