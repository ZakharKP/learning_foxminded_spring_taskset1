package ua.foxminded.foxstudent104788.javaspring.task1.task1_4.models;


import java.util.Map;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * Cache - class with fields for use by different classes
 * of the program to store and transfer data between them
 * 
 */
@Getter
@Setter
public class Cache {
	
	private String userName;
	private String argumentLine;
	private String[] words;
	private Map<String, Map<Character, Integer>> wordsWithCountedChars;
	
	private String answerString;
	private Map<Character, Integer> answerCountedChars;
	private Integer spaseAmount;
	

}
