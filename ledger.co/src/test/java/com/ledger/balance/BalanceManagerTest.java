package com.ledger.balance;

import com.ledger.model.Loan;
import com.ledger.model.Payment;
import com.ledger.util.Util;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

class BalanceManagerTest {
    @Mock
    BalanceProcessor balanceProcessor;
     Loan loan;
     @Mock
     Util util;
    @InjectMocks
    BalanceManager balanceManager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        MockitoAnnotations.openMocks(this);
        String input = "LOAN IDIDI Dale 10000 5 4";
        String[] inputCommand = input.split(" ");
        this.balanceManager.inputData = inputCommand;
        Map<String, Map<String, Loan>> customerLoanMap = new HashMap<>();

    }

    @Test
    void testExecute() {
       when(balanceProcessor.updatePayments(any(), anyInt(), anyInt(), anyDouble())).thenReturn(List.of(new Payment(0d, 0)));
        Map<String, Map<String, Loan>> customerLoanMap = new HashMap<>();
        Map<String, Loan> loanMap =  new HashMap<>();
        List<Payment> paymentList = new ArrayList<>();
        Payment payment  =  new Payment(0.0,12);
        paymentList.add(payment);

        this.loan = new Loan(5000.0d,300.0d,5300.0d,12,442,paymentList);
        loanMap.put("IDIDI",loan);
        customerLoanMap.put("Dale",loanMap);
        Util.setCustomerLoanMap(customerLoanMap);
        // Mock scope
        try (MockedStatic mocked = mockStatic(Util.class)) {
            // Mocking
            mocked.when(Util::getUserLoanMapping).thenReturn(customerLoanMap);
        }
        balanceManager.execute();
    }
}

