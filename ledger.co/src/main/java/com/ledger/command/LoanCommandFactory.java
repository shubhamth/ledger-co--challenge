package com.ledger.command;

import com.ledger.balance.BalanceManager;
import com.ledger.loan.LoanManager;
import com.ledger.payment.PaymentManager;

import static com.ledger.constant.Constant.*;

public class LoanCommandFactory {

    public LoanCommandExecution getInstance(String command, String[] inputCommand) {
         LoanCommandExecution loanCommandExecution;
        switch (command) {
            case LOAN:
                loanCommandExecution = new LoanManager(inputCommand);
                break;
            case PAYMENT :
                loanCommandExecution = new PaymentManager(inputCommand);
                break;
            case BALANCE :
                loanCommandExecution= new BalanceManager(inputCommand);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
        return loanCommandExecution;
    }
}
