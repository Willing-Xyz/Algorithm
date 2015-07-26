package test.com.willing.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

import com.willing.algorithm.sort.HeapSort;

public class TestHeapSort {

	@Test
	public void test()
	{
		Integer[] ints = new Integer[]{2,1,3, 5, 4}; 
		HeapSort.sort(ints);
		Assert.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, ints);
	}
	
//	/**
//	 * ≤‚ ‘ «∑ÒŒ»∂®
//	 */
//	@Test
//	public void testInsertSortStable()
//	{
//		Integer i1 = new Integer(3);
//		Integer i2 = new Integer(3);
//		Integer[] ints = new Integer[]{2, i1, i2, 1};
//		HeapSort.sort(ints);
//		Assert.assertArrayEquals(new Integer[]{1,  2, 3, 3}, ints);
//		Assert.assertSame(ints[2], i1);
//		Assert.assertSame(ints[3], i2);
//	}
}
