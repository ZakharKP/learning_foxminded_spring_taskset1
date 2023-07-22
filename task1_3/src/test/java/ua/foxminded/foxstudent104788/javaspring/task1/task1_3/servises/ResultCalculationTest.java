package ua.foxminded.foxstudent104788.javaspring.task1.task1_3.servises;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


import ua.foxminded.foxstudent104788.javaspring.task1.task1_3.models.DivisionResult;

class ResultCalculationTest {

	@Test
	void testGetQuotientInt() {
		DivisionResult divisionResult = new DivisionResult("1050", "11");
		ResultCalculation resultCalculation = new ResultCalculation(divisionResult);

		int actual = resultCalculation.getQuotientInt();
		int expected = 95;

		assertEquals(expected, actual);
	}

	@Test
	void testGetQuotient() {
		DivisionResult divisionResult = new DivisionResult("1050", "11");
		ResultCalculation resultCalculation = new ResultCalculation(divisionResult);

		divisionResult.setQuotientInt(resultCalculation.getQuotientInt());

		String actual = resultCalculation.getQuotient();
		String expected = "95";

		assertEquals(expected, actual);
	}

	@Test
	void testGetSubractors_sameNumber() {
		DivisionResult divisionResult = new DivisionResult("123456", "123456");
		ResultCalculation resultCalculation = new ResultCalculation(divisionResult);

		divisionResult.setQuotientInt(resultCalculation.getQuotientInt());
		divisionResult.setQuotient(resultCalculation.getQuotient());

		List<String> actual = resultCalculation.getSubtractors();
		List<String> expected = new ArrayList<>();
		expected.add("123456");

		assertEquals(expected, actual);
	}

	@Test
	void testGetSubractors_DivisorBiggest() {
		DivisionResult divisionResult = new DivisionResult("1050", "11000");
		ResultCalculation resultCalculation = new ResultCalculation(divisionResult);

		divisionResult.setQuotientInt(resultCalculation.getQuotientInt());
		divisionResult.setQuotient(resultCalculation.getQuotient());

		List<String> actual = resultCalculation.getSubtractors();
		List<String> expected = new ArrayList<>();
		expected.add("0");

		assertEquals(expected, actual);
	}

	@Test
	void testGetSubractors_withRemainded() {
		DivisionResult divisionResult = new DivisionResult("1050", "11");
		ResultCalculation resultCalculation = new ResultCalculation(divisionResult);

		divisionResult.setQuotientInt(resultCalculation.getQuotientInt());
		divisionResult.setQuotient(resultCalculation.getQuotient());

		List<String> actual = resultCalculation.getSubtractors();
		List<String> expected = new ArrayList<>();
		expected.add("99");
		expected.add("55");

		assertEquals(expected, actual);
	}

	@Test
	void testGetSubractors_withoutRemainded() {
		DivisionResult divisionResult = new DivisionResult("1050", "2");
		ResultCalculation resultCalculation = new ResultCalculation(divisionResult);

		divisionResult.setQuotientInt(resultCalculation.getQuotientInt());
		divisionResult.setQuotient(resultCalculation.getQuotient());

		List<String> actual = resultCalculation.getSubtractors();
		List<String> expected = new ArrayList<>();
		expected.add("10");
		expected.add("4");
		expected.add("10");

		assertEquals(expected, actual);
	}

	@Test
	void testGetReduseds_sameNumber() {
		DivisionResult divisionResult = new DivisionResult("123456", "123456");
		ResultCalculation resultCalculation = new ResultCalculation(divisionResult);

		divisionResult.setQuotientInt(resultCalculation.getQuotientInt());
		divisionResult.setQuotient(resultCalculation.getQuotient());
		divisionResult.setSubtractors(resultCalculation.getSubtractors());

		List<String> actual = resultCalculation.getReduceds();
		List<String> expected = new ArrayList<>();
		expected.add("123456");
		expected.add("0");

		assertEquals(expected, actual);
	}

	@Test
	void testGetReduseds_DivisorBiggest() {
		DivisionResult divisionResult = new DivisionResult("1050", "11000");
		ResultCalculation resultCalculation = new ResultCalculation(divisionResult);

		divisionResult.setQuotientInt(resultCalculation.getQuotientInt());
		divisionResult.setQuotient(resultCalculation.getQuotient());
		divisionResult.setSubtractors(resultCalculation.getSubtractors());

		List<String> actual = resultCalculation.getReduceds();
		List<String> expected = new ArrayList<>();
		expected.add("0");
		expected.add("0");

		assertEquals(expected, actual);
	}

	@Test
	void testGetReduseds_withRemainded() {
		DivisionResult divisionResult = new DivisionResult("1050", "11");
		ResultCalculation resultCalculation = new ResultCalculation(divisionResult);

		divisionResult.setQuotientInt(resultCalculation.getQuotientInt());
		divisionResult.setQuotient(resultCalculation.getQuotient());
		divisionResult.setSubtractors(resultCalculation.getSubtractors());

		List<String> actual = resultCalculation.getReduceds();
		List<String> expected = new ArrayList<>();
		expected.add("105");
		expected.add("60");
		expected.add("5");

		assertEquals(expected, actual);
	}

	
}
