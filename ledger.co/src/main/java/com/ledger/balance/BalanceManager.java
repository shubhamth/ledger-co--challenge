package com.ledger.balance;

import com.ledger.command.LoanCommandExecution;
import com.ledger.model.Loan;
import com.ledger.model.Payment;
import com.ledger.util.Util;

import java.util.List;
import java.util.Map;

/**
 * @author Shubham
 */
public class BalanceManager implements LoanCommandExecution {
    String[] inputData;
    BalanceProcessor balanceProcessor;

    /**
     * used to init BalanceManager
     * @param inputSplit
     */
    public BalanceManager(String[] inputSplit) {
        this.inputData = inputSplit;
    }

    /**
     * this method used to  init calculate balance amount
     */
    @Override
    public void execute() {
        String bankName = inputData[1];
        String customerName = inputData[2];
        int emiMonthCount = Integer.valueOf(inputData[3]);
        balanceProcessor = new BalanceProcessor(bankName, customerName, emiMonthCount);
        calculateBalance(bankName, customerName, emiMonthCount);
    }

    /**
     * this method will be used to  calculate balance amount
     * @param bankName
     * @param customerName
     * @param emiMonthCount
     */
    private void calculateBalance(String bankName, String customerName, int emiMonthCount) {
        Map<String, Loan> bankLoanMap = Util.getUserLoanMapping().get(customerName);
        Loan customerLoan = bankLoanMap.get(bankName);
        List<Payment> paymentList = customerLoan.getPaymentList();
        paymentList = balanceProcessor.updatePayments(paymentList, emiMonthCount, customerLoan.getEmiAmount(), customerLoan.getAmount());
        customerLoan.setPaymentList(paymentList);
        bankLoanMap.put(bankName, customerLoan);
        Util.getUserLoanMapping().get(customerName).put(bankName, customerLoan);
        balanceProcessor.displayBalance(paymentList, emiMonthCount, bankName, customerName);
    }

}
