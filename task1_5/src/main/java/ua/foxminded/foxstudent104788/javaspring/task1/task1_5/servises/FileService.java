package ua.foxminded.foxstudent104788.javaspring.task1.task1_5.servises;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;
import lombok.Getter;
import ua.foxminded.foxstudent104788.javaspring.task1.task1_5.models.FilesResourses;

/**
 *FileService class - for working with the files of this program
 */
@Getter
public class FileService {

	private FilesResourses resourses;
	private LineConverter lineConverter;
	
	public FileService(FilesResourses filesResourses) {
		this.resourses = filesResourses;
		this.lineConverter = new LineConverter(this);
	}

	public void fillInResultList(List<String[]> resultList) {

		try (Stream<String> startLines = Files.lines(resourses.getStartFile())) {
			startLines.forEach(startLine -> {

				String keyLine = lineConverter.getKey(startLine);
				String endLine = getEndLine(keyLine);
				String startTime = lineConverter.getTime(startLine);
				String endTime = lineConverter.getTime(endLine);
				String resultTime = lineConverter.getResultTime(startTime, endTime);

				resultList.add(lineConverter.getResultLine(keyLine, resultTime));
				
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String getEndLine(String keyLine) {
		try (Stream<String> endLines = Files.lines(resourses.getEndFile())) {
			Optional<String> endLine = endLines.filter(x -> x.startsWith(keyLine)).findFirst();			
			
			if (!endLine.isPresent()) {
				throw new NoSuchElementException(keyLine);
			}
			
			return endLine.get();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;
	}

	public String[] getAbbreviationsValue(String keyLine) {

		try (Stream<String> abbreviations = Files.lines(resourses.getAbbreviations())) {

			Optional<String> value = abbreviations.filter(x -> x.startsWith(keyLine)).findFirst();
			if (!value.isPresent()) {
				throw new NoSuchElementException(keyLine);
			}

			String[] abbreviationsValue = value.get().split("_");

			return new String[] { abbreviationsValue[1], abbreviationsValue[2] };

		} catch (IOException | NoSuchElementException e) {
			e.printStackTrace();
		} 

		return new String[0];
	}

	

	

}
