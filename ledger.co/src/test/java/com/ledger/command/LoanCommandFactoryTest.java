package com.ledger.command;

import com.ledger.loan.LoanManager;
import com.ledger.payment.PaymentManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LoanCommandFactoryTest {
    LoanCommandFactory loanCommandFactory = new LoanCommandFactory();

    @Test
    void testGetInstance() {
        String input = "LOAN IDIDI Dale 10000 5 4";
        String[] inputCommand = input.split(" ");
        String command = inputCommand[0];
        LoanCommandExecution result = loanCommandFactory.getInstance(command,inputCommand);
        Assertions.assertNotNull(result);
    }
}

