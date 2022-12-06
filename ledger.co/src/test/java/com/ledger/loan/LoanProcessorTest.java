package com.ledger.loan;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

class LoanProcessorTest {
    @InjectMocks
    LoanProcessor loanProcessor ;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        String input = "LOAN IDIDI Dale 10000 5 4";
        String[] inputData = input.split(" ");
        String bankName = inputData[1];
        String customerName = inputData[2];
        double amount = Double.valueOf(inputData[3]);
        int years = Integer.valueOf(inputData[4]);
        double interestRate = Double.valueOf(inputData[5]);
        this.loanProcessor.setBankName(bankName);
        this.loanProcessor.setCustomerName(customerName);
        this.loanProcessor.setInterestRate(interestRate);
        this.loanProcessor.setYears(years);
        this.loanProcessor.setPrincipalAmount(amount);
    }
    @Test
    void testProcessLoan() {
        loanProcessor.processLoan();
    }
}

