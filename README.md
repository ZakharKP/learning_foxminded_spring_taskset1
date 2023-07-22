<details>
<summary>
Task 1.1 Anagrams
</summary>
<br>  

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
</details>
<br>
<details>
<summary>
Task 1.2 Unit tests
</summary>
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
</details>
<br>
<details>
<summary>
Task 1.3 Integer division
</summary>
<br>

## Assignment:

Write an integer-division application that divides numbers and prints results into the console. Use maven, and don't forget to cover your code with unit tests.

## Example of output:

```
_78945|4
 4    |-----
 -    |19736
_38
 36
 --
 _29
  28
  --
  _14
   12
   --
   _25
    24
    --
     1 

```

</details>
<br>
<details>
<summary>
Task 1.4 Collection Framework
</summary>
<br>

## Assignment:

Write a char-counter application  that takes a string and returns the number of unique characters in the string.

It is expected that a string with the same character sequence may be passed several times to the method.

Since the counting operation can be time-consuming, the method should cache the results, so that when the method is given a string previously encountered, it should return the result from the cache.

Use collections and maps where appropriate.

## Example of output:

```
hello world!
"h" - 1
"e" - 1
"l" - 3
"o" - 2
" " - 1
"w" - 1
"r" - 1
"d" - 1
"!" - 1
```

</details>
<br>
<details>
<summary>
Task 1.5 Java Streams API
</summary>
<br>

## Assignment:

Write a Formula 1 application. 

There are 2 log files ‘start.log’ and ‘end.log’ that contain start and end data of the best lap for each racer of Formula 1 - Monaco 2018 Racing. (Start and end times are fictional, but the best lap times are true). Data contains only the first 20 minutes that refers to the first stage of the qualification

Q1: For the first 20 minutes (Q1), all cars together on the track try to set the fastest time. The slowest seven cars are eliminated, getting the bottom grid positions. Drivers are allowed to complete as many laps as they want during this short period of time.

Top 15 cars go to the Q2 stage. If you are so curious, you can read the rules here  https://www.thoughtco.com/developing-saga-of-formula1-qualifying-1347189

The third file abbreviations '.txt ' contains abbreviation explanations.

Parse the hint:
SVF2018-05-24_12:02:58.917

SVF - racer abbreviation 
2018-05-24 - date
12:02:58.917 - time

## Example of output:

Your task is to read the data from 2 files, order racers by time and print report that shows the top 15 racers and the rest ones after the underline, for example:

1. Daniel Ricciardo      | RED BULL RACING TAG HEUER     | 1:12.013
2. Sebastian Vettel      | FERRARI                                         | 1:12.415
3. ...
------------------------------------------------------------------------
16. Brendon Hartley   | SCUDERIA TORO ROSSO HONDA | 1:13.179
17. Marcus Ericsson    | SAUBER FERRARI                           | 1:13.265

</details>
