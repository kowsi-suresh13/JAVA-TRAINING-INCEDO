package com.Certificates;



import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;

@Service
public class CertificateGeneratorService {

    public byte[] generateCertificate(String recipientName, String courseName,
                                      String issueDate, String expiryDate,
                                      String certificateId, String courseId, String userId) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            PdfWriter writer = new PdfWriter(baos);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Title
            document.add(new Paragraph("EvolveU")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFont(com.itextpdf.kernel.font.PdfFontFactory.createFont(com.itextpdf.io.font.constants.StandardFonts.HELVETICA_BOLD))

                    .setFontSize(20));

            document.add(new Paragraph("Cultivating Knowledge, Creating Change")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(12));

            document.add(new Paragraph("\nCertificate of Completion\n")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFont(com.itextpdf.kernel.font.PdfFontFactory.createFont(com.itextpdf.io.font.constants.StandardFonts.HELVETICA_BOLD))

                    .setFontSize(18));

            document.add(new Paragraph("Awarded to")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(14));

            document.add(new Paragraph(recipientName)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFont(com.itextpdf.kernel.font.PdfFontFactory.createFont(com.itextpdf.io.font.constants.StandardFonts.HELVETICA_BOLD))

                    .setFontSize(16));

            document.add(new Paragraph("For successfully completing the course")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(14));

            document.add(new Paragraph(courseName)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFont(com.itextpdf.kernel.font.PdfFontFactory.createFont(com.itextpdf.io.font.constants.StandardFonts.HELVETICA_BOLD))

                    .setFontSize(16));

            document.add(new Paragraph("\nIssued on: " + issueDate + "    Expires: " + expiryDate)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(12));

            document.add(new Paragraph("\nCertificate ID: #EV-CERT-" + certificateId +
                    "    Course ID: #EV-COURSE-" + courseId +
                    "    User ID: #EV-USER-" + userId)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(10));

            document.add(new Paragraph("\n\nAuthorized Signature:")
                    .setTextAlignment(TextAlignment.LEFT)
                    .setFontSize(12));

            document.add(new Paragraph("\n\n___________________________\nEvolveU")
                    .setTextAlignment(TextAlignment.LEFT)
                    .setFontSize(12));

            document.add(new Paragraph("\n\nSecurity Note: Tampering invalidates this certificate.")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(10));

            document.close();
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
