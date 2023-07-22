package ua.foxminded.foxstudent104788.javaspring.task1.task1_4.servises;

import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import ua.foxminded.foxstudent104788.javaspring.task1.task1_4.models.Cache;

/**
 * This class represents a display service for printing messages and interacting
 * with the user.
 */
@AllArgsConstructor
public class DisplayServise {
	private Scanner reader;
	private Cache cache;
	private MessageTemplates messageTemplate;

	private String getMessage() {
		return reader.nextLine();
	}

	public void print(String outputMessage) {
		for (String line : outputMessage.split("\n")) {
			System.out.println("\t" + line);
		}
	}

	public String getUserName() {
		print(messageTemplate.getAskNameMessage());
		String userName = getMessage();
		if (StringUtils.isBlank(userName)) {
			userName = messageTemplate.getDefaultUserName();
		}
		return userName;
	}

	public String getArgumentLine() {
		print(messageTemplate.getAskArgumentMessage());

		String argument;
		while (StringUtils.isBlank(argument = getMessage())) {

			print(messageTemplate.getTryAgainMessage());

		}

		return argument;
	}

	public void createAnswer() {
		AnswerCreator answerCreator = new AnswerCreator(cache);

		answerCreator.countChars();

		cache.setAnswerString(answerCreator.getAnswerString());

	}

	public void printAnswer() {
		print(messageTemplate.getAnswerMessage(cache.getAnswerString()));

	}

	public boolean isExit() {
		print(messageTemplate.getIsExitMessage());

		return getMessage().equalsIgnoreCase("Y");

	}

	public void printExitMessage() {
		print(messageTemplate.getExitMessage());

	}

}
