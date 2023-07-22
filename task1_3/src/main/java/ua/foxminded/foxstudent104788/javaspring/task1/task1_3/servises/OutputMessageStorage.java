package ua.foxminded.foxstudent104788.javaspring.task1.task1_3.servises;

public class OutputMessageStorage {

	
	private String userName;

	public String getInitializeMessage() {
		String exitValue = String.join(", or ", DisplayService.getExitValue());

		return String.format("Before we start - inform you, that you can stop me anytime - just type:" + "\n%s\n"
				+ "So,tell me how can i contact you?", exitValue);
	}

	public String getHelloMessage() {

		return String.format("Hi %s, there is an application that divides numbers\n"
				+ "and output step-by-step calculation results\n", userName);

	}

	public String getAskNumberMessage(String argument) {

		return String.format("%s, please give me your %s", userName, argument);
	}

	public String getResultMessage(String result) {
		return String.format("Ok %s, here is result of my hard thankless work:\n%s\n", userName, result);
	}

	public String getTryAgainMessage() {
		return String.format("%s, please try again", userName);

	}

	public String getContinueMessage() {
		return String.format("Ok %s, let's do it again!\n", userName);
	}

	public String getExitMessage() {

		return String.format("%s, have a nice day!", userName);
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getExceptionMessage(String argument) {
		String exceptionMessage = "Ooops something went wrong:\n";
		switch (argument) {
		case "NEgetIVE":
			exceptionMessage = exceptionMessage + "Only a positive number\n";
			break;
		case "ZERO":
			exceptionMessage = exceptionMessage + "Number can't be zero\n";
			break;
		case "NOTDIGIT":
			exceptionMessage = exceptionMessage + "It must be Integer number - max Value 2,147,483,647.\n";
			break;
		default:
			break;
		}
		return exceptionMessage;
	}

}