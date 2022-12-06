package com.ledger.payment;

import com.ledger.model.Payment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PaymentProcessorTest {
    PaymentProcessor paymentProcessor = new PaymentProcessor("IDIDI", "Dale", 0d, 0);

    @Test
    void testUpdatePayments() {
        List<Payment> result = paymentProcessor.updatePayments(List.of(new Payment(0d, 0)), 0d, 0, 0, 0d);
        Assertions.assertEquals(List.of(new Payment(0d, 0)), result);
    }

    @Test
    void testProcessFirstPayment() {
        List<Payment> result = paymentProcessor.processFirstPayment(List.of(new Payment(0d, 0)), 0d, 0d, 0);
        Assertions.assertEquals(List.of(new Payment(0d, 0)), result);
    }

    @Test
    void testProcessFinalPayment() {
        Payment result = paymentProcessor.processFinalPayment(new Payment(0d, 0), 0, 0d, 0d);
        Assertions.assertEquals(new Payment(0d, 0), result);
    }

    @Test
    void testProcessPayment() {
        Payment result = paymentProcessor.processPayment(new Payment(0d, 0), 0, 0d);
        Assertions.assertEquals(new Payment(0d, 0), result);
    }
}