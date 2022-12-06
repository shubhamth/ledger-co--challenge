package com.ledger.loan;

import com.ledger.command.LoanCommandExecution;

public class LoanManager implements LoanCommandExecution {
    String[] inputData;
    LoanProcessor loanProcessor;

    public LoanManager(String[] inputSplit) {
        this.inputData = inputSplit;
    }

    public void execute() {
        String bankName = inputData[1];
        String customerName = inputData[2];
        double amount = Double.valueOf(inputData[3]);
        int years = Integer.valueOf(inputData[4]);
        double interestRate = Double.valueOf(inputData[5]);
        executeLoan(bankName, customerName, amount, years, interestRate);
    }


    /**
     * This method used to process loan
     * @param bankName
     * @param customerName
     * @param amount
     * @param years
     * @param interestRate
     */
    private void executeLoan(String bankName, String customerName, double amount, int years, double interestRate) {
        loanProcessor = new LoanProcessor(bankName, customerName, amount, years, interestRate);
        loanProcessor.processLoan();
    }
}
