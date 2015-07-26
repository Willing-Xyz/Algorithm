package test.com.willing.algorithm.search;
 

import org.junit.Assert;
import org.junit.Test;

import com.willing.algorithm.search.BinarySearch;

public class TestBinarySearch {

	@Test
	public void test() {
		
		Integer[] ints = new Integer[]{4, 2, 3, 5};
		
		int index = BinarySearch.search(ints, 3);
		
		Assert.assertEquals(2, index);
		
		 
	}
	
	@Test
	public void testDup()
	{
		Integer a = new Integer(3);
		Integer b = new Integer(3);
		Integer[] ints = new Integer[]{4, a, b, 2};
		
		int index = BinarySearch.search(ints, 3);
		
		Assert.assertEquals(1, index);
		
	}

}
