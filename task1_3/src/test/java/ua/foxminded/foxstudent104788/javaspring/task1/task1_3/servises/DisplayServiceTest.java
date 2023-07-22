package ua.foxminded.foxstudent104788.javaspring.task1.task1_3.servises;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class DisplayServiceTest {


	

	@Test
	void testIsExit_true() {
		
		assertTrue(new DisplayService(null).isExit("Exit"));
	}
	@Test
	void testIsExit_false() {
		
		assertFalse(new DisplayService(null).isExit("Elxit"));
	}

	@Test
	void testGetExitValue() {
		List<String> actual = DisplayService.getExitValue();
		List<String> expected = new ArrayList<>();
		expected.add("\"exit\"");
		expected.add("\"finish\"");
		expected.add("\"stop\"");
		assertEquals(expected, actual);
	}
}
