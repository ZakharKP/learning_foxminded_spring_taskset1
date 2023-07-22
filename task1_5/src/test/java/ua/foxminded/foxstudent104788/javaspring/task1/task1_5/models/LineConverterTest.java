package ua.foxminded.foxstudent104788.javaspring.task1.task1_5.models;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

import ua.foxminded.foxstudent104788.javaspring.task1.task1_5.servises.FileService;
import ua.foxminded.foxstudent104788.javaspring.task1.task1_5.servises.LineConverter;

class LineConverterTest {

	@Test
	void testGetKey() {
		String actual = new LineConverter(null).getKey("SSW2018-05-24_12:16:11.648");
		String expected = "SSW";
		assertEquals(expected, actual);
	}

	@Test
	void testGetTime() {
		String actual = new LineConverter(null).getTime("SSW2018-05-24_12:16:11.648");
		String expected = "2018-05-24_12:16:11.648";
		assertEquals(expected, actual);
	}

	@Test
	void testGetResultTime() {
		String actual = new LineConverter(null).getResultTime("2018-05-24_12:16:11.648", "2018-05-24_12:17:24.354");
		String expected = "1:12.706";
		assertEquals(expected, actual);
	}

	@Test
	void testGetResultLine() {
		Path  resoursesDirPath = Paths.get("src", "test", "resources");
		Path startFile = Paths.get(resoursesDirPath.toString(), "start.log");
		Path endFile = Paths.get(resoursesDirPath.toString(), "end.log");
		Path abbreviations = Paths.get(resoursesDirPath.toString(), "abbreviations.txt");

		FileService fileService = new FileService(new FilesResourses(startFile, endFile, abbreviations));
		
		String[] expected = new String[] {"Sergey Sirotkin", "WILLIAMS MERCEDES", "1:12.706"};
		String[] actual = fileService.getLineConverter().getResultLine("SSW", "1:12.706");
		
		assertArrayEquals(expected, actual);
		
	}

	

}
