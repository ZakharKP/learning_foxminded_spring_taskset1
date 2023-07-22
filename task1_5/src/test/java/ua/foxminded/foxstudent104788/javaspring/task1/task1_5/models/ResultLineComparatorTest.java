package ua.foxminded.foxstudent104788.javaspring.task1.task1_5.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ua.foxminded.foxstudent104788.javaspring.task1.task1_5.servises.ResultLineComparator;

class ResultLineComparatorTest {

	@Test
	void testCompare() {
		String[] o1 = new String[] {"","","1:13.179"};
		String[] o2 = new String[] {"","","1:12.415"};
		int actual = 1;
		int expected = new ResultLineComparator().compare(o1, o2);
		assertEquals(expected, actual);
	}

}
