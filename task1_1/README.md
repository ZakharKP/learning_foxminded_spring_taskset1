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

<br>

# Task 1.2 Unit tests
<br>

## Assignment:

Pick-up your previous task and write JUnit tests for it.

Use Junit5 dependency

Tests should run with project build

 Maven surefire plugin

Use appropriate test methods naming convention (ask Mentor for preferred one)

Add Sonar lint plugin support to your IDE.

Add Editorconfig support to your project.

## Important:

In the future, all tasks are:

covered with the Unit tests

created as maven projects

Before submitting a Merge Request for code review, you SHOULD:

ensure that your code is properly formatted with IDE or Maven plugin

check your code with Sonar Lint. It won’t show all the problems, but it can check a lot.

## Hint:

In order to make tests more useful, name them in the way you read the documentation.
For example: reverseOnlyLetters_shouldReturnSameAmountOfSpaces_whenInputStringContainsOnlySpaces.
Yes, it is too long, and you shouldn't name the src methods in this way. This approach will help you(or somebody)
in the future during refactoring or logic change. 
The pattern is the next: methodName_shouldDoSmth_whenConditions

Test case examples:

Check null (should throw IllegalArgumentException with meaningful message)
Check empty string
Check single space input
Check several spaces input
Check single character input
Check multiple same letter input
Check the same character in lower and upper cases mixed in the input
Check a word with different letters
Check only symbols
check several words.
...
