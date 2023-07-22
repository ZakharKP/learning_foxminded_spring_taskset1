package ua.foxminded.foxstudent104788.javaspring.task1.task1_4.servises;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Map;

import lombok.AllArgsConstructor;
import ua.foxminded.foxstudent104788.javaspring.task1.task1_4.models.Cache;

/**
 * 
 * Answer creator that class counts characters in words and generates an answer
 * string.
 * 
 */
@AllArgsConstructor
public class AnswerCreator {

	private Cache cache;

	/**
	 * Counts characters in words, updates the character count map in cache
	 */
	public void countChars() {
		cache.setWords(cache.getArgumentLine().split(" "));
		cache.setSpaseAmount(cache.getWords().length - 1);

		cache.setWordsWithCountedChars(new HashMap<>());
		cache.setAnswerCountedChars(new LinkedHashMap<>());

		for (String word : cache.getWords()) {

			countCharsInWord(word);
		}

		for (int i = 0; i < cache.getWords().length; i++) {

			updateAnswerCountedChars(cache.getWords()[i]);

			if (i == 0) {
				cache.getAnswerCountedChars().put(' ', cache.getSpaseAmount());
			}
		}

	}

	private void countCharsInWord(String word) {

		if (!cache.getWordsWithCountedChars().containsKey(word)) {

			cache.getWordsWithCountedChars().put(word, new LinkedHashMap<>());

			for (Character eachchar : word.toCharArray()) {
				countThisChar(eachchar, cache.getWordsWithCountedChars().get(word));

			}
		}

	}

	private void countThisChar(Character eachChar, Map<Character, Integer> countedChars) {

		if (countedChars.containsKey(eachChar)) {

			Integer amount = countedChars.get(eachChar);
			amount++;
			countedChars.replace(eachChar, amount);

		} else {
			countedChars.put(eachChar, new Integer(1));
		}

	}

	private void updateAnswerCountedChars(String word) {

		for (Entry<Character, Integer> entry : cache.getWordsWithCountedChars().get(word).entrySet()) {

			if (cache.getAnswerCountedChars().containsKey(entry.getKey())) {

				Integer amount = cache.getAnswerCountedChars().get(entry.getKey()) + entry.getValue();

				cache.getAnswerCountedChars().replace(entry.getKey(), amount);
			} else {

				cache.getAnswerCountedChars().put(entry.getKey(), entry.getValue());
			}
		}

	}

	/**
	 * create and return Answer String
	 * 
	 * @return answer String
	 */
	public String getAnswerString() {
		StringBuilder answer = new StringBuilder(cache.getArgumentLine());
		for (Entry<Character, Integer> entry : cache.getAnswerCountedChars().entrySet()) {
			answer.append(String.format("\n\"%s\" - %s", entry.getKey(), entry.getValue()));
		}
		return answer.toString();
	}

}
