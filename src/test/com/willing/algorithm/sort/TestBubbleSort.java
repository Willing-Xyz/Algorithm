package test.com.willing.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

import com.willing.algorithm.sort.InsertSort;

public class TestBubbleSort {

	@Test
	public void testInsertSort()
	{
		Integer[] ints = new Integer[]{2,1,3}; 
		InsertSort.sort(ints);
		Assert.assertArrayEquals(new Integer[]{1, 2, 3}, ints);
	}
	
	/**
	 * ≤‚ ‘ «∑ÒŒ»∂®
	 */
	@Test
	public void testInsertSortStable()
	{
		Integer i1 = new Integer(3);
		Integer i2 = new Integer(3);
		Integer[] ints = new Integer[]{2, i1, i2, 1};
		InsertSort.sort(ints);
		Assert.assertArrayEquals(new Integer[]{1,  2, 3, 3}, ints);
		Assert.assertSame(ints[2], i1);
		Assert.assertSame(ints[3], i2);
	}
}
