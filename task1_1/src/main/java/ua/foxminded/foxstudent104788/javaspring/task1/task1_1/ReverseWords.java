package ua.foxminded.foxstudent104788.javaspring.task1.task1_1;

import java.util.Scanner;

public class ReverseWords {

	public static void main(String[] args) {

		System.out.println("\tHi Dear, this magic application will help you reverse your String \n"
				+ "\tif you want stop magic please just type \"exit\" in any moment\n");

		System.out.println("\tPlease, type your words now");

		try (Scanner consoleReader = new Scanner(System.in)) {

			String usersInput;

			while (!(usersInput = consoleReader.nextLine()).equalsIgnoreCase("exit")) {
				System.out.println("\tand we get that:");
				System.out.println(reverseAllWords(usersInput));
				System.out.println("\tplease, give me the next one");
			}
		}

		System.out.println("\tbye bye Dear, have a nise day!");

	}

	public static String reverseAllWords(String words) {

		StringBuilder reversedWords = new StringBuilder();

		for (String word : words.split(" ")) {
			reversedWords.append(reverseWord(word) + " ");
		}

		return reversedWords.toString().trim();
	}

	public static String reverseWord(String word) {

		char[] reversed = getCharArrayWithoutLetters(word);
		int newIndex = word.length() - 1;

		for (int i = 0; i < word.length(); i++) {

			char characterAtEachIndex = word.charAt(i);

			if (Character.isLetter(characterAtEachIndex)) {

				while (reversed[newIndex] != 0) {
					newIndex--;
				}

				reversed[newIndex] = characterAtEachIndex;
				newIndex--;
			}

		}

		return new String(reversed);
	}

	private static char[] getCharArrayWithoutLetters(String word) {

		char[] charArrayWithoutLetters = new char[word.length()];

		for (int i = 0; i < word.length(); i++) {

			if (!Character.isLetter(word.charAt(i))) {
				charArrayWithoutLetters[i] = word.charAt(i);
			}
		}

		return charArrayWithoutLetters;
	}

}
