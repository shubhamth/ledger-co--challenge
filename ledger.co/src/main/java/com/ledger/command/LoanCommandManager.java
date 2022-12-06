package com.ledger.command;

public class LoanCommandManager {
    LoanCommandFactory loanCommandFactory = new LoanCommandFactory();
    LoanCommandExecution loanCommandExecution;

    public void executeCommand(String input) {
        String[] inputCommand = input.split(" ");
        String command = inputCommand[0];
        loanCommandExecution = loanCommandFactory.getInstance(command,inputCommand);
        loanCommandExecution.execute();
    }

}
