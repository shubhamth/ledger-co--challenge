package com.ledger.model;

import java.util.List;

public class Loan {

    private double principal;
    private double interestAmount;
    private double amount;
    private int emiMonths;
    private int emiAmount;
    private List<Payment> paymentList;

    public Loan(double principal, double interestAmount, double amount, int emiMonths, int emiAmount, List<Payment> paymentList) {
        this.principal = principal;
        this.interestAmount = interestAmount;
        this.amount = amount;
        this.emiMonths = emiMonths;
        this.emiAmount = emiAmount;
        this.paymentList = paymentList;
    }

    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public double getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(double interestAmount) {
        this.interestAmount = interestAmount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getEmiMonths() {
        return emiMonths;
    }

    public void setEmiMonths(int emiMonths) {
        this.emiMonths = emiMonths;
    }

    public int getEmiAmount() {
        return emiAmount;
    }

    public void setEmiAmount(int emiAmount) {
        this.emiAmount = emiAmount;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }
}

