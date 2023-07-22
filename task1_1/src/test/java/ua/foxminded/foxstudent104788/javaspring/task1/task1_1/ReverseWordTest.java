package ua.foxminded.foxstudent104788.javaspring.task1.task1_1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReverseWordTest {

	@Test
	void testReverseAllWords_OneOnlyLettersWord() {
		String actualString = ReverseWords.reverseAllWords("asdf");
		String expectedString = "fdsa";
		assertEquals(actualString, expectedString);
	}
	@Test
	void testReverseAllWords_MoreOnlyLettersWords() {
		String actualString = ReverseWords.reverseAllWords("asdf ghjk QweR");
		String expectedString = "fdsa kjhg RewQ";
		assertEquals(actualString, expectedString);
	}
	@Test
	void testReverseAllWords_OneWordWithNotOnlyLetters() {
		String actualString = ReverseWords.reverseAllWords("a1sd!f");
		String expectedString = "f1ds!a";
		assertEquals(actualString, expectedString);
	}
	@Test
	void testReverseAllWords_MoreWordWithNotOnlyLetters() {
		String actualString = ReverseWords.reverseAllWords("a1sd!f ??ghj3k Qw4eR@@");
		String expectedString = "f1ds!a ??kjh3g Re4wQ@@";
		assertEquals(actualString, expectedString);
	}
	@Test
	void testReverseAllWords_OneWordWithoutLetters() {
		String actualString = ReverseWords.reverseAllWords("12345");
		String expectedString = "12345";
		assertEquals(actualString, expectedString);
	}
	@Test
	void testReverseAllWords_MoreWordWithoutLetters() {
		String actualString = ReverseWords.reverseAllWords("12345 ?1@#!! 258?<>");
		String expectedString = "12345 ?1@#!! 258?<>";
		assertEquals(actualString, expectedString);
	}
	@Test
	void testReverseWord_OnlyLettersWord() {
		String actualString = ReverseWords.reverseWord("asdf");
		String expectedString = "fdsa";
		assertEquals(actualString, expectedString);
	}
	@Test
	void testReverseWord_WordWithNotOnlyLetters() {
		String actualString = ReverseWords.reverseWord("a1sd!f");
		String expectedString = "f1ds!a";
		assertEquals(actualString, expectedString);
	}
	@Test
	void testReverseWord_WordWithoutLetters() {
		String actualString = ReverseWords.reverseWord("12345");
		String expectedString = "12345";
		assertEquals(actualString, expectedString);
	}

	
}
