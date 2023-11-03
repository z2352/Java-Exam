package com.example.demo.model;


import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceId;

    @Column
    private Long customerId;

    @Column(columnDefinition = "TEXT")
    private String invoiceData;

    public Invoice() {}

    public Invoice(Long customerId, String invoiceData) {
        this.customerId = customerId;
        this.invoiceData = invoiceData;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getInvoiceData() {
        return invoiceData;
    }

    public void setInvoiceData(String invoiceData) {
        this.invoiceData = invoiceData;
    }
}
