package ua.foxminded.foxstudent104788.javaspring.task1.task1_5.models;

import java.nio.file.Path;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * FileResourses - model with all Paths to files witch application use
 */
@AllArgsConstructor
@Getter
@Setter
public class FilesResourses {
	
	private Path startFile;
	private Path endFile;
	private Path abbreviations;
	

}
