package ua.foxminded.foxstudent104788.javaspring.task1.task1_5.servises;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import ua.foxminded.foxstudent104788.javaspring.task1.task1_5.models.FilesResourses;

/**
 * Class for preparing output String
 * 
 */
public class OutputService {

	public String getResultOutput() {

		List<String[]> resultList = getResultList();

		return createResultLines(resultList);

	}

	private List<String[]> getResultList() {

		List<String[]> resultList = new ArrayList<>();
		FileService fileServise = new FileService(createFilesResourses());
		
		fileServise.fillInResultList(resultList);
		resultList.sort(new ResultLineComparator());
		
		return resultList;
	}

	private FilesResourses createFilesResourses() {
		
		Path resoursesDirPath = Paths.get("src", "main", "resources");
		Path startFile = Paths.get(resoursesDirPath.toString(), "start.log");
		Path endFile = Paths.get(resoursesDirPath.toString(), "end.log");
		Path abbreviations = Paths.get(resoursesDirPath.toString(), "abbreviations.txt");

		return new FilesResourses(startFile, endFile, abbreviations);
	}

	private String createResultLines(List<String[]> resultList) {
		StringBuilder resultOutput = new StringBuilder("The resut of the rase is:\n");

		int[] symbolsAmount = getSymbolsAmount(resultList);

		int i = 1;
		for (String[] resultLine : resultList) {

			String[] spaces = getSpaces(symbolsAmount, resultLine);
			resultOutput.append(String.format("%n%d. %s%s\t| %s%s\t| %s", i, resultLine[0], spaces[0], resultLine[1],
					spaces[1], resultLine[2]));
			if (i == 15) {

				resultOutput.append("\n" + String.valueOf(new char[symbolsAmount[3]]).replaceAll("\0", "-"));
			}
			i++;
		}

		return resultOutput.toString();
	}

	/**
	 * 
	 * @param resultList
	 * @return array with max lenght's of output parts - need it to count how much
	 *         spaces and "-" print to make output view more understandable
	 */
	private int[] getSymbolsAmount(List<String[]> resultList) {
		int[] symbolsAmount = new int[] { 0, 0, 0, 0 };
		for (String[] line : resultList) {
			symbolsAmount[0] = symbolsAmount[0] < line[0].length() ? line[0].length() : symbolsAmount[0];
			symbolsAmount[1] = symbolsAmount[1] < line[1].length() ? line[1].length() : symbolsAmount[1];
			symbolsAmount[2] = symbolsAmount[2] < line[2].length() ? line[2].length() : symbolsAmount[2];
		}
		symbolsAmount[3] = symbolsAmount[0] + symbolsAmount[1] + symbolsAmount[2] + 16;

		return symbolsAmount;
	}

	private String[] getSpaces(int[] symbolsAmount, String[] resultLine) {
		int[] spacesAmount = new int[3];
		spacesAmount[0] = symbolsAmount[0] - resultLine[0].length();
		spacesAmount[1] = symbolsAmount[1] - resultLine[1].length();
		spacesAmount[2] = symbolsAmount[2] - resultLine[2].length();

		String[] spaces = new String[3];

		spaces[0] = String.valueOf(new char[spacesAmount[0]]).replaceAll("\0", " ");
		spaces[1] = String.valueOf(new char[spacesAmount[1]]).replaceAll("\0", " ");
		spaces[2] = String.valueOf(new char[spacesAmount[2]]).replaceAll("\0", " ");

		return spaces;
	}
}
