package ua.foxminded.foxstudent104788.javaspring.task1.task1_3.servises;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import ua.foxminded.foxstudent104788.javaspring.task1.task1_3.models.DivisionResult;

@AllArgsConstructor
public class ResultCalculation {

	private DivisionResult divisionResult;

	public int getQuotientInt() {
		return divisionResult.getDividendInt() / divisionResult.getDivisorInt();
	}

	public String getQuotient() {
		return String.valueOf(divisionResult.getQuotientInt());
	}

	

	public List<String> getSubtractors() {
		List<String> subtractors = new ArrayList<>();

		if (isDivisorMoreThanDividend()) {
			subtractors.add("0");
			return subtractors;
		}

		int quotientIndex = 0;

		addNextSubtractor(quotientIndex, subtractors);

		return subtractors;
	}

	private void addNextSubtractor(int quotientIndex, List<String> subtractors) {

		String subtractor = findSubtractor(quotientIndex);
		subtractors.add(subtractor);
		int nextQuotientIndex = findNextQuotientIndex(quotientIndex);

		if (nextQuotientIndex > quotientIndex) {
			addNextSubtractor(nextQuotientIndex, subtractors);
		}
	}

	private int findNextQuotientIndex(int quotientIndex) {

		String quotient = divisionResult.getQuotient();

		int quotientNextIndex = quotientIndex;
		int quotientMaxIndex = quotient.length() - 1;
		if (quotientNextIndex < quotientMaxIndex) {
			quotientNextIndex++;
		}

		while (isZero(String.valueOf(quotient.charAt(quotientNextIndex))) && quotientNextIndex < quotientMaxIndex) {
			quotientNextIndex++;
		}

		return quotientNextIndex;
	}

	
	public List<String> getReduceds(){
		List<String> reduceds = new ArrayList<>();
		
		if (isDivisorMoreThanDividend()) {
			reduceds.add("0");
			reduceds.add("0");
			return reduceds;
		}
		
		int dividendIndex = 0;
		int subtractorIndex = 0;
		String remainder = "";
		
		addNextReduced(dividendIndex, subtractorIndex, remainder, reduceds);
		
		return reduceds;
	}
	
	private void addNextReduced(int dividendIndex, int subtractorIndex, String remainder, List<String> reduceds) {
		String reduced = findNextReduced(dividendIndex, remainder);

		reduceds.add(reduced);
		
		if (haveNextRows(reduced)) {
				
			String subtractor = divisionResult.getSubtractors().get(subtractorIndex);
			String nextRemainder = findRemainded(reduced, subtractor);
			
			int nextDididentIndex = findNextDividendIndex(dividendIndex, reduced, nextRemainder);
			int nexSubtractorIndex = subtractorIndex + 1;

			addNextReduced(nextDididentIndex, nexSubtractorIndex, nextRemainder, reduceds);
		} 
	}
	
	private boolean isDivisorMoreThanDividend() {
		int dividendInt = divisionResult.getDividendInt();
		int divisorInt = divisionResult.getDivisorInt();
		
		return divisorInt > dividendInt;
	}

	
	
	

	private String findRemainded(String reduced, String subtractor) {
		int remainder = Integer.parseInt(reduced) - Integer.parseInt(subtractor);
		return String.valueOf(remainder);
	}

	private String findNextReduced(int dividendIndex, String lastRemainder) {

		StringBuilder nextReduced = new StringBuilder(lastRemainder);
		int divisorInt = divisionResult.getDivisorInt();
		String dividend = divisionResult.getDividend();

		int reducedInt = nextReduced.length() > 0 ? Integer.parseInt(nextReduced.toString()) : 0;
		int dividendNextIndex;

		while (reducedInt < divisorInt) {
			dividendNextIndex = nextReduced.length() + dividendIndex;

			if (dividendNextIndex >= dividend.length()) {
				if (isZero(nextReduced.toString()))
					return "0";
				return nextReduced.toString();
			}

			nextReduced.append(dividend.charAt(dividendNextIndex));
			reducedInt = Integer.parseInt(nextReduced.toString());
		}

		return nextReduced.toString();
	}

	private String findSubtractor(int quotientIndex) {

		int divisorInt = divisionResult.getDivisorInt();
		String quotient = divisionResult.getQuotient();

		return String.valueOf(divisorInt * Integer.parseInt(String.valueOf(quotient.charAt(quotientIndex))));
	}

	private int findNextDividendIndex(int dividendIndex, String reduced, String remainder) {

		return dividendIndex + reduced.length() - remainder.length();
	}

	private boolean haveNextRows(String reduced) {

		return Integer.parseInt(reduced) >= divisionResult.getDivisorInt();
	}

	private boolean isZero(String number) {

		return Integer.parseInt(number) == 0;
	}

}
