package com.ledger;

import com.ledger.command.LoanCommandManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Application {
	public static void main(String[] args) {
		final Logger logger = LoggerFactory.getLogger(Application.class);
		LoanCommandManager loanCommandManager = new LoanCommandManager();

 		String filePath = args[0];
		try{
			Stream<String> stream = Files.lines(Paths.get(filePath));
			stream.forEach(fileData -> {
 				loanCommandManager.executeCommand(fileData);
 			});
		 }catch (IOException ioException){
			logger.error(ioException.toString(),ioException);
 		 }catch (Exception ex){
			logger.error(ex.toString(),ex.getMessage());

		}

	}

}
