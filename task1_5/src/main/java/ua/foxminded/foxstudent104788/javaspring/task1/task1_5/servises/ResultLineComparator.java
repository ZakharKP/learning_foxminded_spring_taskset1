package ua.foxminded.foxstudent104788.javaspring.task1.task1_5.servises;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;

/**
 * comparator to sort result by time
 */

public class ResultLineComparator implements Comparator<String[]>{

	@Override
	public int compare(String[] o1, String[] o2) {
		
		SimpleDateFormat format = new SimpleDateFormat("m:ss.SSS"); 
		
		long diference = 0;
		try {
			diference = format.parse(o1[2]).getTime() - format.parse(o2[2]).getTime();
		} catch (ParseException e) {

			e.printStackTrace();
		}
		return diference > 0 ? 1 : -1;
	}
}
