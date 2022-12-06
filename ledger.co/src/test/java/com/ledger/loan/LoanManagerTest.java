package com.ledger.loan;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class LoanManagerTest {
    @Mock
    LoanProcessor loanProcessor;
    @InjectMocks
    LoanManager loanManager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        String input = "LOAN IDIDI Dale 10000 5 4";
        String[] inputCommand = input.split(" ");
        this.loanManager.inputData = inputCommand;
    }

    @Test
    void testExecute() {
        loanManager.execute();
    }
}