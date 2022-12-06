package com.ledger.payment;

import com.ledger.command.LoanCommandExecution;

public class PaymentManager implements LoanCommandExecution {
    String[] inputSplit;
    PaymentProcessor paymentProcessor;

    public PaymentManager(String[] inputSplit) {
        this.inputSplit = inputSplit;
    }
    @Override
    public void execute() {

    }
}
