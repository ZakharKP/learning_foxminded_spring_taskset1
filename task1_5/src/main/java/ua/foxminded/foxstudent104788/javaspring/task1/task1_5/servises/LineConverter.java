package ua.foxminded.foxstudent104788.javaspring.task1.task1_5.servises;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.AllArgsConstructor;

/**
 * LineConverter - for work with lines.
 * 
 */


@AllArgsConstructor
public class LineConverter {
	
	FileService fileService;

	public String getKey(String line) {
		
		return line.substring(0, 3);
	}

	public String getTime(String line) {
		
		return line.substring(3);
	}

	public String getResultTime(String startTime, String endTime) {
		
		try {
			SimpleDateFormat formatResourses = new SimpleDateFormat("yyyy-mm-dd_HH:mm:ss.SSS");
			
			Date start = formatResourses.parse(startTime);
			Date finish = formatResourses.parse(endTime);
			
			long duration =  finish.getTime() - start.getTime();
			Date resultTime = new Date(duration);
			SimpleDateFormat formatResult = new SimpleDateFormat("m:ss.SSS");
			
			return formatResult.format(resultTime);
			
		} catch (ParseException e) {

			e.printStackTrace();
		}
		return null;
	}

	public String[] getResultLine(String keyLine, String resultTime) {
		
		String[] resultLine = new String[3];
		String[] abbreviationsValue = fileService.getAbbreviationsValue(keyLine);
		
		resultLine[0] = abbreviationsValue[0];
		resultLine[1] = abbreviationsValue[1];
		resultLine[2] = resultTime;		
		
		return resultLine;
	}

	

}
