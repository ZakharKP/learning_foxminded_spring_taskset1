package ua.foxminded.foxstudent104788.javaspring.task1.task1_4.servises;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import ua.foxminded.foxstudent104788.javaspring.task1.task1_4.models.Cache;

class AnswerCreatorTest {

	@Test
	void testCountChars_CheckAnswerCountedChars() {

		Map<Character, Integer> actual = new LinkedHashMap<>();
		actual.put('!', 2);
		actual.put('a', 3);
		actual.put('b', 1);
		actual.put('c', 3);
		actual.put('d', 2);
		actual.put(' ', 2);
		actual.put('?', 1);

		Cache cache = new Cache();
		cache.setArgumentLine("!abcd acd ac!?");

		AnswerCreator creation = new AnswerCreator(cache);
		creation.countChars();

		Map<Character, Integer> expected = cache.getAnswerCountedChars();

		assertEquals(actual, expected);
	}

	@Test
	void testCountChars_CheckWordsWithCountedChars() {

		Map<String, Map<Character, Integer>> actual = new HashMap<>();
		Map<Character, Integer> test = new LinkedHashMap<>();
		Map<Character, Integer> hello = new LinkedHashMap<>();
		Map<Character, Integer> word = new LinkedHashMap<>();

		test.put('t', 2);
		test.put('e', 1);
		test.put('s', 1);

		hello.put('h', 1);
		hello.put('e', 1);
		hello.put('l', 2);
		hello.put('o', 1);

		word.put('w', 1);
		word.put('o', 1);
		word.put('r', 1);
		word.put('d', 1);

		actual.put("test", test);
		actual.put("hello", hello);
		actual.put("word", word);

		Cache cache = new Cache();
		cache.setArgumentLine("test test hello test word");

		AnswerCreator creation = new AnswerCreator(cache);
		creation.countChars();

		Map<String, Map<Character, Integer>> expected = cache.getWordsWithCountedChars();

		assertEquals(actual, expected);
	}

	@Test
	void testGetAnswerString_WithoutRepeat() {
		String actual = "!abcd acd ac!?" + "\n" + "\"!\" - 2" + "\n" + "\"a\" - 3" + "\n" + "\"b\" - 1" + "\n"
				+ "\"c\" - 3" + "\n" + "\"d\" - 2" + "\n" + "\" \" - 2" + "\n" + "\"?\" - 1";

		Cache cache = new Cache();
		cache.setArgumentLine("!abcd acd ac!?");

		AnswerCreator creation = new AnswerCreator(cache);
		creation.countChars();

		String expected = creation.getAnswerString();

		assertEquals(actual, expected);
	}

	@Test
	void testGetAnswerString_WithRepeat() {
		String actual = "test test hello test word" + "\n" + "\"t\" - 6" + "\n" + "\"e\" - 4" + "\n" + "\"s\" - 3"
				+ "\n" + "\" \" - 4" + "\n" + "\"h\" - 1" + "\n" + "\"l\" - 2" + "\n" + "\"o\" - 2" + "\n" + "\"w\" - 1"
				+ "\n" + "\"r\" - 1" + "\n" + "\"d\" - 1";

		Cache cache = new Cache();
		cache.setArgumentLine("test test hello test word");

		AnswerCreator creation = new AnswerCreator(cache);
		creation.countChars();

		String expected = creation.getAnswerString();

		assertEquals(actual, expected);
	}

}
