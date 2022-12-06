package com.ledger.balance;

import com.ledger.model.Payment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.List;

class BalanceProcessorTest {
    BalanceProcessor balanceProcessor = new BalanceProcessor("bankName", "customerName", 0);

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


    }
    @Test
    void testDisplayBalance() {
        balanceProcessor.displayBalance(List.of(new Payment(0d, 0)), 0, "IDIDI", "Dale");
    }

    @Test
    void testUpdatePayments() {
        List<Payment> result = balanceProcessor.updatePayments(List.of(new Payment(0d, 0)), 0, 0, 0d);
        Assertions.assertEquals(List.of(new Payment(0d, 0)), result);
    }
}