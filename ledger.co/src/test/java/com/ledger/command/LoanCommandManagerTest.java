package com.ledger.command;

import com.ledger.loan.LoanManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class LoanCommandManagerTest {
    @Mock
    LoanCommandFactory loanCommandFactory;
    @Mock
    LoanCommandExecution loanCommandExecution;
    @InjectMocks
    LoanCommandManager loanCommandManager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testExecuteCommand() {
        String input = "LOAN IDIDI Dale 10000 5 4";
        String[] inputCommand = input.split(" ");
        String command = inputCommand[0];
        when(loanCommandFactory.getInstance("LOAN", inputCommand)).thenReturn(new LoanManager(inputCommand));
        loanCommandManager.executeCommand(input);
     }
}
