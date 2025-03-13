package com.trimblecars.demo.controller;

import com.trimblecars.demo.entity.Lease;
import com.trimblecars.demo.service.LeaseService;
import com.trimblecars.demo.util.PdfExportUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


import java.util.List;

@Controller
@RequestMapping("/lease")
public class LeaseController {

    @Autowired
    private LeaseService leaseService;

    // Other methods for handling lease operations like GET, POST, etc.

    @GetMapping("/export-pdf")
    public void exportLeaseHistory(HttpServletResponse response) throws Exception {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=lease_history.pdf");

        List<Lease> leases = leaseService.getAllLeases(); // Get all leases from your service
        PdfExportUtil.exportLeaseHistory(leases, response.getOutputStream()); // Export to PDF
    }
}
