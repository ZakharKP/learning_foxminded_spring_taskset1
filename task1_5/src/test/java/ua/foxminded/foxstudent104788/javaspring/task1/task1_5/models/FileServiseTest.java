package ua.foxminded.foxstudent104788.javaspring.task1.task1_5.models;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import ua.foxminded.foxstudent104788.javaspring.task1.task1_5.servises.FileService;


class FileServiseTest {

	@Test
	void testFillInResultList() {
		
		Path  resoursesDirPath = Paths.get("src", "test", "resources");
		Path startFile = Paths.get(resoursesDirPath.toString(), "start.log");
		Path endFile = Paths.get(resoursesDirPath.toString(), "end.log");
		Path abbreviations = Paths.get(resoursesDirPath.toString(), "abbreviations.txt");

		FileService fileService = new FileService(new FilesResourses(startFile, endFile, abbreviations));
		
		List<String[]> actual = new ArrayList<>();
		fileService.fillInResultList(actual);

		List<String[]> expected = new ArrayList<>();

		expected.add(new String[] { "Sebastian Vettel", "FERRARI", "1:04.415" });
		expected.add(new String[] { "Nico Hulkenberg", "RENAULT", "1:13.065" });
		expected.add(new String[] { "Fernando Alonso", "MCLAREN RENAULT", "1:12.657" });
		expected.add(new String[] { "Kimi Raikkonen", "FERRARI", "1:12.639" });
		expected.add(new String[] { "Stoffel Vandoorne", "MCLAREN RENAULT", "1:12.463" });
		expected.add(new String[] { "Marcus Ericsson", "SAUBER FERRARI", "1:13.265" });
		expected.add(new String[] { "Lance Stroll", "WILLIAMS MERCEDES", "1:13.323" });
		expected.add(new String[] { "Brendon Hartley", "SCUDERIA TORO ROSSO HONDA", "1:13.179" });
		expected.add(new String[] { "Esteban Ocon", "FORCE INDIA MERCEDES", "1:13.028" });
		expected.add(new String[] { "Romain Grosjean", "HAAS FERRARI", "1:12.930" });
		expected.add(new String[] { "Sergey Sirotkin", "WILLIAMS MERCEDES", "1:12.706" });
		expected.add(new String[] { "Kevin Magnussen", "HAAS FERRARI", "1:13.393" });
		expected.add(new String[] { "Pierre Gasly", "SCUDERIA TORO ROSSO HONDA", "1:12.941" });
		expected.add(new String[] { "Carlos Sainz", "RENAULT", "1:12.950" });
		expected.add(new String[] { "Sergio Perez", "FORCE INDIA MERCEDES", "1:12.848" });
		expected.add(new String[] { "Daniel Ricciardo", "RED BULL RACING TAG HEUER", "1:12.013" });
		expected.add(new String[] { "Lewis Hamilton", "MERCEDES", "1:12.460" });
		expected.add(new String[] { "Charles Leclerc", "SAUBER FERRARI", "1:12.829" });
		expected.add(new String[] { "Valtteri Bottas", "MERCEDES", "1:12.434" });

		for (int i = 0; i < expected.size(); i++) {
			assertArrayEquals(expected.get(i), actual.get(i));
		}
	}

	@Test
	void testGetAbbreviationsValue() {
		
		Path  resoursesDirPath = Paths.get("src", "test", "resources");
		Path startFile = Paths.get(resoursesDirPath.toString(), "start.log");
		Path endFile = Paths.get(resoursesDirPath.toString(), "end.log");
		Path abbreviations = Paths.get(resoursesDirPath.toString(), "abbreviations.txt");

		FileService fileService = new FileService(new FilesResourses(startFile, endFile, abbreviations));
		

		String[] actual = fileService.getAbbreviationsValue("SVF");
		String[] expected = new String[] { "Sebastian Vettel", "FERRARI" };

		assertArrayEquals(expected, actual);
	}

}
