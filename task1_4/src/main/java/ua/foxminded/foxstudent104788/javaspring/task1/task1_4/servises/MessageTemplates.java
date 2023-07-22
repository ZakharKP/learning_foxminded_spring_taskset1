package ua.foxminded.foxstudent104788.javaspring.task1.task1_4.servises;

import lombok.AllArgsConstructor;
import ua.foxminded.foxstudent104788.javaspring.task1.task1_4.models.Cache;

/**
 * 
 * Storage of message templates which it use to create and return output
 * messages
 *
 */
@AllArgsConstructor
public class MessageTemplates {
	private Cache cache;

	public String getInitialMessage() {

		return "Hi, \"Collection Framework\" is an application that help you to know\n"
				+ "how many each symbol are in your line\n";
	}

	public String getAskNameMessage() {

		return "Before we start. let me ask you what is your name?";
	}

	public String getDefaultUserName() {

		return "Dear";
	}

	public String getAskArgumentMessage() {

		return String.format("Okey %s, please give me your text line", cache.getUserName());
	}

	public String getTryAgainMessage() {

		return "Ooops something went wrong, try again please";
	}

	public String getAnswerMessage(Object answerString) {

		return String.format("Ok %s, here is result of my hard thankless work:\n%s\n", cache.getUserName(),
				answerString);
	}

	public String getIsExitMessage() {

		return String.format("%s, do you really want stop this magik application right now? \n Y/N?",
				cache.getUserName());
	}

	public String getExitMessage() {

		return String.format("Bye bye %s, have a nice day", cache.getUserName());
	}

}
