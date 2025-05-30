package com.drivehub.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Payment {
    private String paymentID;
    private double amount;
    private String paymentDate;
    private String method;
    private String status; // "success", "failed", "refunded"

    public Payment(String paymentID, double amount, String method) {
        this.paymentID = paymentID;
        this.amount = amount;
        this.method = method;
        this.paymentDate = generateCurrentDate();
        this.status = "pending"; // default αρχική κατάσταση
    }

    private String generateCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.format(new Date());
    }

    public boolean process() {
        // mock επιτυχία πληρωμής
        this.status = "success";
        return true;
    }

    public boolean fail() {
        this.status = "failed";
        return false;
    }

    public boolean refund() {
        if ("success".equals(status)) {
            this.status = "refunded";
            return true;
        }
        return false;
    }

    // Getters
    public String getPaymentID() {
        return paymentID;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public String getMethod() {
        return method;
    }

    public String getStatus() {
        return status;
    }

    // Optional setter αν χρειαστεί
    public void setStatus(String status) {
        this.status = status;
    }
}
