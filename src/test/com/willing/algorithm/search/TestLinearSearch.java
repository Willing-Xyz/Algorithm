package test.com.willing.algorithm.search;

 

import org.junit.Assert;
import org.junit.Test;

import com.willing.algorithm.search.LinearSearch;

public class TestLinearSearch {

	@Test
	public void test() {
		
		Integer[] ints = new Integer[]{2, 1, 5, 3};
		
		int index = LinearSearch.search(ints, 5);
		
		Assert.assertEquals(2, index);
		
	}

	@Test
	public void testDup()
	{
		Integer[] ints = new Integer[]{5, 3, 3, 2};
		
		int index = LinearSearch.search(ints, 3);
		
		Assert.assertEquals(1, index);
	}
}
