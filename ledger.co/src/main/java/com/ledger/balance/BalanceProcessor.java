package com.ledger.balance;

import com.ledger.model.Payment;

import java.util.List;

/**
 * @author Shubham
 */
public class BalanceProcessor {

    String bankName;
    String customerName;
    int emiMonthCount;

    /**
     * Used to init BalanceProcessor
     * @param bankName
     * @param customerName
     * @param emiMonthCount
     */
    public BalanceProcessor(String bankName, String customerName, int emiMonthCount) {
        this.bankName = bankName;
        this.customerName = customerName;
        this.emiMonthCount = emiMonthCount;
    }

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

    public int getEmiMonthCount() {
        return emiMonthCount;
    }

    public void setEmiMonthCount(int emiMonthCount) {
        this.emiMonthCount = emiMonthCount;
    }

    /**
     * TThis method will be used to  get payment balance and will display balance amount
     * @param paymentList
     * @param afterEMICount
     * @param bankName
     * @param customerName
     */
    public void displayBalance(List<Payment> paymentList, int afterEMICount, String bankName, String customerName) {
        Payment payment = paymentList.get(afterEMICount);
        System.out.println(bankName + " " + customerName + " " + (int)(payment.getAmountPaid()) + " " + payment.getEmiCountLeft());
    }

    /**
     * This method will be used to  calculate Payment
     * @param prevPayment
     * @param emiAmount
     * @param totalAmount
     * @return payment
     */
    private Payment calculatePayment(Payment prevPayment, int emiAmount, double totalAmount) {
        double totalAmountPaid = prevPayment.getAmountPaid() + emiAmount;
        if(totalAmountPaid > totalAmount) {
            totalAmountPaid = totalAmount;
        }
        Payment payment = new Payment(totalAmountPaid,prevPayment.getEmiCountLeft()-1);
        return payment;
    }

    /**
     * This method will be used to  update payments
     * @param paymentList
     * @param afterEmiCount
     * @param emiAmount
     * @param totalAmount
     * @return paymentList
     */
    public List<Payment> updatePayments(List<Payment> paymentList, int afterEmiCount, int emiAmount, double totalAmount) {
        for(int i = paymentList.size(); i <= afterEmiCount;i++) {
            Payment prevPayment = paymentList.get(i-1);
            paymentList.add(calculatePayment(prevPayment, emiAmount, totalAmount));
        }
        return paymentList;
    }
}
