package com.ledger.payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class PaymentManagerTest {
    @Mock
    PaymentProcessor paymentProcessor;
    @InjectMocks
    PaymentManager paymentManager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testExecute() {
        paymentManager.execute();
    }
}
