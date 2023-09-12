# Task 1.1 Anagrams



## Assignment:

Write an application that reverses all the words of input text:

## Examples:

Each word in the text should be reversed:
"abcd efgh" => "dcba hgfe"

All non-letter symbols should stay on the same places:
"a1bcd efg!h" => "d1cba hgf!e"

Use only the Latin alphabet to test.

## Requirements:

Create an empty Maven project

Start with the implementation of a method that reverses only 1 word at a time.

(Optional) Add Main (Application) class where you can read console input or hard code it to check yourself.

Add a method that splits the string into words and runs the previous method for each word.

Make your compiled jar executable, check with 
1) mvn clean package
2) java -jar target/<your-jar-file>.jar
