package ua.foxminded.foxstudent104788.javaspring.task1.task1_3.servises;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OutputMessageStorageTest {

	@Test
	void testGetInitializeMessage() {
		
		String actual = new OutputMessageStorage().getInitializeMessage();
		String expected = "Before we start - inform you, that you can stop me anytime - just type:\n"
				+ "\"exit\", or \"finish\", or \"stop\"\n"
				+ "So,tell me how can i contact you?";
		
		assertEquals(expected, actual);
		
	}

	@Test
	void testGetHelloMessage() {
		OutputMessageStorage messageStorage = new OutputMessageStorage();
		messageStorage.setUserName("Jonny");
		String actual = messageStorage.getHelloMessage();
		String expected = "Hi Jonny, there is an application that divides numbers\n"
				+ "and output step-by-step calculation results\n";
		
		assertEquals(expected, actual);
	}

	@Test
	void testGetAskNumberMessage() {
		OutputMessageStorage messageStorage = new OutputMessageStorage();
		messageStorage.setUserName("Jonny");
			
		String actual = messageStorage.getAskNumberMessage("divident");
		String expected = "Jonny, please give me your divident";
		
		assertEquals(expected, actual);
	}

	@Test
	void testGetResultMessage() {
		
		OutputMessageStorage messageStorage = new OutputMessageStorage();
		messageStorage.setUserName("Jonny");
		
		String actual = messageStorage.getResultMessage("RESULT");
		String expected = "Ok Jonny, here is result of my hard thankless work:\n"
				+ "RESULT\n";
		assertEquals(expected, actual);
	}

	@Test
	void testGetTryAgainMessage() {
		OutputMessageStorage messageStorage = new OutputMessageStorage();
		messageStorage.setUserName("Jonny");
		
		String actual = messageStorage.getTryAgainMessage();
		
		String expected = "Jonny, please try again";
		
		assertEquals(expected, actual);
	}

	@Test
	void testGetContinueMessage() {
		
		OutputMessageStorage messageStorage = new OutputMessageStorage();
		messageStorage.setUserName("Jonny");
		
		String actual = messageStorage.getContinueMessage();
		
		
		String expected = "Ok Jonny, let's do it again!\n";

		assertEquals(expected, actual);
	}

	@Test
	void testGetExitMessage() {
		
		OutputMessageStorage messageStorage = new OutputMessageStorage();
		messageStorage.setUserName("Jonny");
		
		String actual = messageStorage.getExitMessage();
		
		String expected = "Jonny, have a nice day!";

		assertEquals(expected, actual);
	}

	@Test
	void testGetExceptionMessage() {
		
		OutputMessageStorage messageStorage = new OutputMessageStorage();
		messageStorage.setUserName("Jonny");
		
		String actual = messageStorage.getExceptionMessage("ZERO");
		
		String expected = "Ooops something went wrong:\n"
				+ "Number can't be zero\n";

		assertEquals(expected, actual);
	}

}
