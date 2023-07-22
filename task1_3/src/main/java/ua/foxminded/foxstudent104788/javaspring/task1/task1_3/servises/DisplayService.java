package ua.foxminded.foxstudent104788.javaspring.task1.task1_3.servises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ua.foxminded.foxstudent104788.javaspring.task1.task1_3.exception.ExitException;
import ua.foxminded.foxstudent104788.javaspring.task1.task1_3.models.DivisionResult;

public class DisplayService {

	private OutputMessageStorage outputMessageStorage;
	private Scanner consoleReader;
	private static List<String> exitValue;

	static {
		exitValue = new ArrayList<>();
		exitValue.add("\"exit\"");
		exitValue.add("\"finish\"");
		exitValue.add("\"stop\"");
	}

	public DisplayService(OutputMessageStorage outputMessageStorage) {
		this.outputMessageStorage = outputMessageStorage;

		this.consoleReader = new Scanner(System.in);
	}

	
	public String getMessage() {
		String newMessage = consoleReader.nextLine();
		if (isExit(newMessage)) {
			throw new ExitException(outputMessageStorage.getExitMessage());
		}
		return newMessage;
	}

	public void print(String outputMessage) {
		for (String line : outputMessage.split("\n")) {
			System.out.println("\t" + line);
		}
	}

	public String getUserName() {
		String userName = getMessage();
		if (userName == null || userName.length() == 0) {
			userName = "Dear";
		}

		return userName;
	}

	/**
	 * ending on exception that's why infinity loop
	 **/
	public void conversate() {
		while (true) {

			String divident;
			String divisor;
			DivisionResult divisionResult;
			SolutionStringCreator solutionStringCreator;
			ResultCalculation resultCalculation;
			
			print(outputMessageStorage.getAskNumberMessage("divident"));
			divident = getNumber();
			print(outputMessageStorage.getAskNumberMessage("divisor"));
			divisor = getNumber();

			divisionResult = new DivisionResult(divident, divisor);
			resultCalculation = new ResultCalculation(divisionResult);
			
			divisionResult.setQuotientInt(resultCalculation.getQuotientInt());
			divisionResult.setQuotient(resultCalculation.getQuotient());
			divisionResult.setSubtractors(resultCalculation.getSubtractors());
			divisionResult.setReduceds(resultCalculation.getReduceds());

			solutionStringCreator = new SolutionStringCreator(divisionResult);

			print(outputMessageStorage.getResultMessage(solutionStringCreator.getResultString()));
			print(outputMessageStorage.getContinueMessage());

		}
	}

	/*
	 * will ask correct number again and again before we got it. 
	 * or exit on type "exit"
	 */

	private String getNumber() {
		String number;

		while (true) {
			number = getMessage();

			if (isCorrectNumber(number)) {
				return number;
			} else {
				print(outputMessageStorage.getTryAgainMessage());
			}

		}
	}

	private boolean isCorrectNumber(String number) {

		int intNumber;
		try {
			intNumber = Integer.parseInt(number);
			if (intNumber < 0) {
				print(outputMessageStorage.getExceptionMessage("NEGATIVE"));
				return false;
			}
			if (intNumber == 0) {
				print(outputMessageStorage.getExceptionMessage("ZERO"));
				return false;
			}

		} catch (NumberFormatException e) {
			print(outputMessageStorage.getExceptionMessage("NOTDIGIT"));
			return false;
		}

		return true;
	}

	public boolean isExit(String inputedData) {
		return exitValue.contains("\"" + inputedData.toLowerCase() + "\"");
	}

	public void close() {
		consoleReader.close();

	}

	public static List<String> getExitValue() {
		return exitValue;
	}
}
