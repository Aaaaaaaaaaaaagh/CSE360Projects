/*
 * Author: Armaan Dodd
 * Class ID: 115
 * Assignment Number: 1
 * Description: This is the class description of the simple list JUnit test, which is trying to make sure that our initialized
 * class goes through all the expected edge cases that we would expect to see. In this case, some functions are being
 * implicitly tested for; for example, count() is being stress-tested by checking it at multiple stages of execution, as it
 * is expected that every function change the count variable at appropriate times.
 * 
 * The JUnit test is divided into 3 sections; one to ensure the add, one to ensure the remove, and one to ensure the 
 * search function. I believe that the below cases satisfy all edge cases that may occur for this particular class.
 * 
 */

package cse360assign2;
import static org.junit.Assert.*;
import org.junit.Test;

public class SimpleListTest {

	@Test
	public void testAdd() //tests that add works, as well as edge cases.
	{
		SimpleList test = new SimpleList();
		
		test.add(1);
		assertEquals("1 0 0 0 0 0 0 0 0 0", test.toString());
		assertEquals(1, test.count());
		//confirms that add pushes a value, and that it also increments 1.
		
		test.add(3);
		test.add(4);
		assertEquals("4 3 1 0 0 0 0 0 0 0", test.toString());
		test.add(2);
		test.add(11);
		test.add(34);
		test.add(18);
		test.add(9);
		test.add(412);
		test.add(37);
		test.add(39);
		assertEquals("39 37 412 9 18 34 11 2 4 3", test.toString());
		assertEquals(10, test.count());
		//confirms that add pushes values off the edge of the list, and does not increment count past 10.
	}
	
	@Test
	public void testAdd2() //tests that add works for the new case of adding overflow, as well as edge cases.
	{
		SimpleList test = new SimpleList();
		
		test.add(1);
		assertEquals("1 0 0 0 0 0 0 0 0 0", test.toString());
		assertEquals(1, test.count());
		//confirms that add pushes a value, and that it also increments 1.
		
		test.add(3);
		test.add(4);
		test.add(2);
		test.add(11);
		test.add(34);
		test.add(18);
		test.add(9);
		test.add(412);
		test.add(37);
		test.add(39);
		assertEquals("39 37 412 9 18 34 11 2 4 3", test.toString());
		assertEquals(114, test.size());
		//confirms that add pushes values off the edge of the list, and does not increment count past 10.
	}
	
	@Test
	public void testRemove() //tests that remove works for each test case.
	{
		SimpleList test = new SimpleList();
		
		test.add(1);	
		test.add(3);
		test.add(4);
		test.add(2);
		assertEquals("2 4 3 1 0 0 0 0 0 0", test.toString());
		assertEquals(4, test.count());
		
		test.remove(4);
		assertEquals("2 3 1 0 0 0 0 0 0 0", test.toString());
		assertEquals(3, test.count());
		//confirms that remove will take out a value in the middle of a string of numbers, and fill it out.
		//and also confirms that it will decrement and fill out the remaining spaces with 0.
		
		
		test.add(11);
		test.add(34);
		test.add(18);
		test.add(9);
		test.add(412);
		test.add(37);
		test.add(39);
		assertEquals("39 37 412 9 18 34 11 2 3 1", test.toString());
		assertEquals(10, test.count());
		
		test.remove(11);
		assertEquals("39 37 412 9 18 34 2 3 1 0", test.toString());
		assertEquals(9, test.count());
		//confirms that even if removed, that it will generate a 0 at the very end, and that the count decrements
		//appropriately.
	}
	
	@Test
	public void testRemove2() //tests that remove works for each test case.
	{
		SimpleList test = new SimpleList();
		
		test.add(1);	
		test.add(3);
		test.add(4);
		test.add(2);
		assertEquals("2 4 3 1 0 0 0 0 0 0", test.toString());
		assertEquals(4, test.count());
		
		test.remove(4);
		assertEquals("2 3 1 0 0 0 0 0 0 0", test.toString());
		assertEquals(3, test.count());
		//confirms that remove will take out a value in the middle of a string of numbers, and fill it out.
		//and also confirms that it will decrement and fill out the remaining spaces with 0.
	}
	
	@Test
	public void testSearch() //checks to ensure that the search function works as intended, returning appropriate values for 
	{
		SimpleList test = new SimpleList();
		
		test.add(1);	
		test.add(9);
		test.add(6);
		test.add(32);
		assertEquals("32 6 9 1 0 0 0 0 0 0", test.toString());
		assertEquals(0, test.search(32));
		assertEquals(2, test.search(9));
		//shows that 32 is the 0th element in the search, meaning that it is the first element.
		
		
		test.add(11);
		test.add(34);
		test.add(18);
		test.add(9);
		test.add(412);
		test.add(37);
		test.add(39);
		assertEquals("39 37 412 9 18 34 11 32 6 9", test.toString());
		assertEquals(10, test.count());
		assertEquals(4, test.search(18));
		assertEquals(-1, test.search(999));
		//shows that 18 is the 5th element in the list, and that 999 is not found in the list.
		
	}
	
	public void testSearch2() //checks to ensure that the search function works as intended, returning appropriate values for 
	{
		SimpleList test = new SimpleList();
		
		test.add(1);	
		test.add(9);
		test.add(6);
		test.add(32);
		assertEquals("32 6 9 1 0 0 0 0 0 0", test.toString());
		assertEquals(0, test.search(32));
		assertEquals(2, test.search(9));
		//shows that 32 is the 0th element in the search, meaning that it is the first element.
		
	}
}
