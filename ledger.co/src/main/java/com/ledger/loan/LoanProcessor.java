package com.ledger.loan;

import com.ledger.model.Loan;
import com.ledger.model.Payment;
import com.ledger.util.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Shubham
 */
public class LoanProcessor {

    private String bankName;
    private String customerName;
    private double principalAmount;
    private int years;
    private double interestRate;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(double principalAmount) {
        this.principalAmount = principalAmount;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * default constructor
     */
    public LoanProcessor() {
    }

    /**
     * will be used to init LoanProcessor
     * @param bankName
     * @param customerName
     * @param principalAmount
     * @param years
     * @param interestRate
     */
    LoanProcessor(String bankName, String customerName, double principalAmount, int years, double interestRate) {
        this.bankName = bankName;
        this.customerName = customerName;
        this.principalAmount = principalAmount;
        this.years = years;
        this.interestRate = interestRate;
    }


    /**
     * This method will be  used to process loan ,calculate interest amount,emi amount
     */
    public void processLoan() {
        List<Payment> paymentList = initPayment();
        int totalMonths = Util.getMonthsFromYears(years);
        double interestAmount = Util.calculateInterestAmount(principalAmount, years, interestRate);
        double totalAmount = principalAmount + interestAmount;
        int emiAmount = Util.calculateEMIAmount(totalAmount, totalMonths);
        Loan loan = new Loan(principalAmount, interestAmount, totalAmount,totalMonths, emiAmount, paymentList);
        updateLoanData(loan);
    }

    /**
     * This  method will be used to  initialize  payment and to update payment list
     * @return
     */
    private List<Payment> initPayment() {
        List<Payment> paymentList = new ArrayList<>();
        Payment payment = new Payment(0, Util.getMonthsFromYears(years));
        paymentList.add(payment);
        return paymentList;
    }

    /**
     * this method  will be used to update loan data
     * @param loan
     */
    private void updateLoanData(Loan loan) {
        if(Util.getUserLoanMapping().containsKey(customerName)) {
            Map<String, Loan> existingMap = Util.getUserLoanMapping().get(customerName);
            existingMap.put(bankName, loan);
            Util.getUserLoanMapping().put(customerName, existingMap);
        } else {
            Map<String,Loan> map = new HashMap<>();
            map.put(bankName,loan);
            Util.getUserLoanMapping().put(customerName,map);
        }
    }

}
