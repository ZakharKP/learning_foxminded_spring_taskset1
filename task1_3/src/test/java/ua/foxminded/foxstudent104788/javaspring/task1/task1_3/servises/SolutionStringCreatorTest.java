package ua.foxminded.foxstudent104788.javaspring.task1.task1_3.servises;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import ua.foxminded.foxstudent104788.javaspring.task1.task1_3.models.DivisionResult;

class SolutionStringCreatorTest {

	@Test
	void testCreateResultString_withoutRemainded() {
		
		DivisionResult divisionResult = new DivisionResult("1050","2");
		ResultCalculation resultCalculation = new ResultCalculation(divisionResult);

		divisionResult.setQuotientInt(resultCalculation.getQuotientInt());
		divisionResult.setQuotient(resultCalculation.getQuotient());
		divisionResult.setSubtractors(resultCalculation.getSubtractors());
		divisionResult.setReduceds(resultCalculation.getReduceds());
		
		SolutionStringCreator solutionString = new SolutionStringCreator(divisionResult);
		
		String actual = solutionString.getResultString();
		String expected =
				"\n" + "_1050|2" + "\n"+
						 " 10  |---" + "\n" + 
						 " --  |525" + "\n" + 
						 " _05" + "\n" +
						 "   4" + "\n" +
						 "   -" + "\n" +
						 "  _10" + "\n" +
						 "   10" + "\n" +
						 "   --" + "\n" +
						 "    0" + "\n";		
		assertEquals(expected, actual );
		
	}
	
	@Test
	void testCreateResultString_withRemainded() {
		
		DivisionResult divisionResult = new DivisionResult("1123","56");
		ResultCalculation resultCalculation = new ResultCalculation(divisionResult);

		divisionResult.setQuotientInt(resultCalculation.getQuotientInt());
		divisionResult.setQuotient(resultCalculation.getQuotient());
		divisionResult.setSubtractors(resultCalculation.getSubtractors());
		divisionResult.setReduceds(resultCalculation.getReduceds());
		SolutionStringCreator solutionString = new SolutionStringCreator(divisionResult);
		
		String actual = solutionString.getResultString();
		String expected =
				"\n" + "_1123|56" + "\n"+
					   " 112 |--" + "\n" + 
					   " --- |20" + "\n" + 
					   "   03" + "\n";		
		assertEquals(expected, actual );
		
	}
	
	@Test
	void testCreateResultString_DivisorBiggest() {
		
		DivisionResult divisionResult = new DivisionResult("1123","11025");
		ResultCalculation resultCalculation = new ResultCalculation(divisionResult);

		divisionResult.setQuotientInt(resultCalculation.getQuotientInt());
		divisionResult.setQuotient(resultCalculation.getQuotient());
		divisionResult.setSubtractors(resultCalculation.getSubtractors());
		divisionResult.setReduceds(resultCalculation.getReduceds());
		SolutionStringCreator solutionString = new SolutionStringCreator(divisionResult);
		
		String actual = solutionString.getResultString();
		String expected =
				   "\n" + "_1123|11025" + "\n"+
						  " 0   |-----" + "\n" + 
						  " -   |0" + "\n" + 
						  " 0" + "\n";		
		assertEquals(expected, actual );
		
	}
	
	@Test
	void testCreateResultString_sameNumber() {
		
		DivisionResult divisionResult = new DivisionResult("123456","123456");
		ResultCalculation resultCalculation = new ResultCalculation(divisionResult);

		divisionResult.setQuotientInt(resultCalculation.getQuotientInt());
		divisionResult.setQuotient(resultCalculation.getQuotient());
		divisionResult.setSubtractors(resultCalculation.getSubtractors());
		divisionResult.setReduceds(resultCalculation.getReduceds());
		SolutionStringCreator solutionString = new SolutionStringCreator(divisionResult);
		
		String actual = solutionString.getResultString();
		String expected =
				"\n" + "_123456|123456\n"+
						 " 123456|------\n" + 
						 " ------|1\n" + 
						 "      0" + "\n";			
		assertEquals(expected, actual );
		
	}
	

	@Test
	void testCreateResultRows_withoutRemainded() {
		
		DivisionResult divisionResult = new DivisionResult("1050","2");
		ResultCalculation resultCalculation = new ResultCalculation(divisionResult);

		divisionResult.setQuotientInt(resultCalculation.getQuotientInt());
		divisionResult.setQuotient(resultCalculation.getQuotient());
		divisionResult.setSubtractors(resultCalculation.getSubtractors());
		divisionResult.setReduceds(resultCalculation.getReduceds());
		SolutionStringCreator solutionString = new SolutionStringCreator(divisionResult);
		
		List<String> actual = solutionString.createResultRows();
		List<String> expectedList = new ArrayList<>();
		expectedList.add("_1050|2");
		expectedList.add(" 10  |---");
		expectedList.add(" --  |525");
		expectedList.add(" _05");
		expectedList.add("   4");
		expectedList.add("   -");
		expectedList.add("  _10");
		expectedList.add("   10");
		expectedList.add("   --");
		expectedList.add("    0");
		
		
		assertEquals(expectedList, actual);
	}

	@Test
	void testCreateResultRows_withRemainded() {
		
		DivisionResult divisionResult = new DivisionResult("1123","56");
		ResultCalculation resultCalculation = new ResultCalculation(divisionResult);

		divisionResult.setQuotientInt(resultCalculation.getQuotientInt());
		divisionResult.setQuotient(resultCalculation.getQuotient());
		divisionResult.setSubtractors(resultCalculation.getSubtractors());
		divisionResult.setReduceds(resultCalculation.getReduceds());
		SolutionStringCreator solutionString = new SolutionStringCreator(divisionResult);
		
		List<String> actual = solutionString.createResultRows();
		List<String> expectedList = new ArrayList<>();
		expectedList.add("_1123|56");
		expectedList.add(" 112 |--");
		expectedList.add(" --- |20");
		expectedList.add("   03");
		
		
		assertEquals(expectedList, actual);
	}

	@Test
	void testCreateResultRows_DivisorBiggest() {
		
		DivisionResult divisionResult = new DivisionResult("1123","11025");
		ResultCalculation resultCalculation = new ResultCalculation(divisionResult);

		divisionResult.setQuotientInt(resultCalculation.getQuotientInt());
		divisionResult.setQuotient(resultCalculation.getQuotient());
		divisionResult.setSubtractors(resultCalculation.getSubtractors());
		divisionResult.setReduceds(resultCalculation.getReduceds());
		SolutionStringCreator solutionString = new SolutionStringCreator(divisionResult);
		
		List<String> actual = solutionString.createResultRows();
		List<String> expectedList = new ArrayList<>();
		expectedList.add("_1123|11025");
		expectedList.add(" 0   |-----");
		expectedList.add(" -   |0");
		expectedList.add(" 0");
		
		
		assertEquals(expectedList, actual);
	}

	@Test
	void testCreateResultRows_sameNumber() {
		
		DivisionResult divisionResult = new DivisionResult("123456","123456");
		ResultCalculation resultCalculation = new ResultCalculation(divisionResult);

		divisionResult.setQuotientInt(resultCalculation.getQuotientInt());
		divisionResult.setQuotient(resultCalculation.getQuotient());
		divisionResult.setSubtractors(resultCalculation.getSubtractors());
		divisionResult.setReduceds(resultCalculation.getReduceds());
		SolutionStringCreator solutionString = new SolutionStringCreator(divisionResult);
		
		List<String> actual = solutionString.createResultRows();
		List<String> expectedList = new ArrayList<>();
		expectedList.add("_123456|123456");
		expectedList.add(" 123456|------");
		expectedList.add(" ------|1");
		expectedList.add("      0");
		
		
		assertEquals(expectedList, actual);
	}

	

}
