package com.example.demo.service;

import com.example.demo.model.Invoice;
import com.example.demo.repository.InvoiceRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public Map<Long, String> getInvoicesByCustomerId(Long customerId) {
        List<Invoice> invoices = invoiceRepository.findByCustomerId(customerId);
        Map<Long, String> resultMap = new HashMap<>();

        for (Invoice invoice : invoices) {
            String tenderType = getTenderTypeFromData(invoice.getInvoiceData());
            resultMap.put(invoice.getInvoiceId(), tenderType);
        }

        return resultMap;
    }

    private String getTenderTypeFromData(String data) {
        // Assuming invoiceData is a JSON String
        JSONObject jsonData = new JSONObject(data);
        if (jsonData.has("tenderDetails")) {
            JSONObject tenderDetails = jsonData.getJSONObject("tenderDetails");
            if (tenderDetails.has("type")) {
                return tenderDetails.getString("type");
            }
        }
        return "Unknown";
    }
}
