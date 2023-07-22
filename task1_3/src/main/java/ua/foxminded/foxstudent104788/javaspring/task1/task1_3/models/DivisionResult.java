package ua.foxminded.foxstudent104788.javaspring.task1.task1_3.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;



public class DivisionResult {

	private @Getter String dividend;
	private @Getter String divisor;
	private @Getter @Setter String quotient;

	private @Getter @Setter List<String> reduceds;
	private @Getter @Setter List<String> subtractors;
	
	private @Getter int dividendInt;
	private @Getter int divisorInt;
	private @Getter @Setter int quotientInt;

	public DivisionResult(String dividend, String divisor) {
		this.dividend = dividend;
		this.divisor = divisor;
		
		this.dividendInt = Integer.parseInt(dividend);
		this.divisorInt = Integer.parseInt(divisor);
	}


	
}
