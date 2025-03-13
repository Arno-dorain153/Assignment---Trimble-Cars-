package com.trimblecars.demo.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.trimblecars.demo.entity.Lease;

import java.io.OutputStream;
import java.util.List;

public class PdfExportUtil {

    public static void exportLeaseHistory(List<Lease> leases, OutputStream outputStream) throws Exception {
        Document document = new Document();
        PdfWriter.getInstance(document, outputStream);
        document.open();

        // Title
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        document.add(new Paragraph("Lease History", font));

        PdfPTable table = new PdfPTable(4);
        table.addCell("Lease ID");
        table.addCell("Car Model");
        table.addCell("Customer Name");
        table.addCell("Lease Start");

        for (Lease lease : leases) {
            table.addCell(String.valueOf(lease.getId()));
            table.addCell(lease.getCar().getModel());
            table.addCell(lease.getCustomer().getUsername());
            table.addCell(lease.getLeaseStart().toString());
        }

        document.add(table);
        document.close();
    }
}
