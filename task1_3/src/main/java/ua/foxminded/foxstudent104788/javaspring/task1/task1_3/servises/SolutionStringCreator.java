package ua.foxminded.foxstudent104788.javaspring.task1.task1_3.servises;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import ua.foxminded.foxstudent104788.javaspring.task1.task1_3.models.DivisionResult;

@AllArgsConstructor
public class SolutionStringCreator{

	private DivisionResult divisionResult;
	
	
	


	public String getResultString() {
		
		StringBuilder resultString = new StringBuilder();
		for (String resultRow : createResultRows()) {
			resultString.append(resultRow + "\n");
		}
		return "\n" + resultString.toString();
	}

	
	public List<String> createResultRows() {
		
		List<String> resultRows = new ArrayList<>();	
		
		addRows(resultRows);

		return resultRows;
	}
	
	private void addRows(List<String> resultRows) {
		
		String dividend = divisionResult.getDividend();
		String divisor = divisionResult.getDivisor();
		String quotient = divisionResult.getQuotient();
		
		String firstRow = String.format("_%s|%s", dividend ,divisor);
		
		String subtractor = divisionResult.getSubtractors().get(0);
		String reducer = divisionResult.getReduceds().get(0);

		int spacesCount = reducer.length() - subtractor.length();
		
		String spacesBefore = new String(new char[spacesCount]).replace("\0", " ");
		
		spacesCount = divisionResult.getDividend().length() - reducer.length();
		
		String spacesAfter = new String(new char[spacesCount]).replace("\0", " ");
		
		int amountMinuses = divisor.length() > quotient.length() ? divisor.length() : quotient.length();

		String secondRow = String.format(" %s%s%s|%s", spacesBefore, subtractor, spacesAfter,
				new String(new char[amountMinuses]).replace("\0", "-"));
		
		amountMinuses = subtractor.length();

		String thirdRow = String.format(" %s%s%s|%s", spacesBefore,
				new String(new char[amountMinuses]).replace("\0", "-"), spacesAfter, quotient);

		resultRows.add(firstRow);
		resultRows.add(secondRow);
		resultRows.add(thirdRow);
		
		int stepCounter = 0;
		int dividendIndex = findNextDividendIndex(0, stepCounter);
		stepCounter++;
		
		addNextThreeRows(stepCounter, dividendIndex, resultRows);
		
	}

	private void addNextThreeRows(int stepCounter, int dividendIndex, List<String> resultRows) {
		
		String reduced = divisionResult.getReduceds().get(stepCounter);
		
		String spacesBefore = new String(new char[dividendIndex]).replace("\0", " ");
		

		if (stepCounter + 1 < divisionResult.getReduceds().size()) {

			String subtractor = divisionResult.getSubtractors().get(stepCounter);

			String firstRow = String.format("%s_%s", spacesBefore, reduced);

			int plusSpaces = reduced.length() - subtractor.length();
			
			spacesBefore = spacesBefore + new String(new char[plusSpaces]).replace("\0", " ");

			String secondRow = String.format(" %s%s", spacesBefore, subtractor);
			

			String thirdRow = String.format(" %s%s", spacesBefore,
					new String(new char[subtractor.length()]).replace("\0", "-"));

			
			resultRows.add(firstRow);
			resultRows.add(secondRow);
			resultRows.add(thirdRow);
		
			int nexDividendIndex = findNextDividendIndex(dividendIndex, stepCounter);

			stepCounter++;
			addNextThreeRows(stepCounter, nexDividendIndex, resultRows);

		} else {
			resultRows.add(" " + spacesBefore + reduced);
		}
		
	}

	private String findRemainder(int step) {
		
		int remainder = Integer.parseInt(divisionResult.getReduceds().get(step))
				- Integer.parseInt(divisionResult.getSubtractors().get(step));
		return String.valueOf(remainder);
	}
	
	private int findNextDividendIndex(int dividendIndex, int stepCounter) {

		return dividendIndex + divisionResult.getReduceds().get(stepCounter).length() - findRemainder(stepCounter).length();
	}

	
}
