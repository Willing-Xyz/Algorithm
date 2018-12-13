package com.willing.algorithm.test.sort;

import org.junit.Assert;
import org.junit.Test;

import com.willing.algorithm.sort.SelectSort;

public class TestSelectSort {

	@Test
	public void test()
	{
		Integer[] ints = new Integer[]{3, 2, 5, 4};
		
		SelectSort.sort(ints);
		
		Assert.assertArrayEquals(new Integer[]{2, 3, 4, 5}, ints);
	}
	
	@Test
	public void testStable()
	{
		Integer a = new Integer(3);
		Integer b = new Integer(3);
		Integer[] ints = new Integer[]{4, a, b, 2};
		
		SelectSort.sort(ints);
		
		Assert.assertArrayEquals(new Integer[]{2, a, b, 4}, ints);
	 
		Assert.assertSame(a, ints[1]);
	}
}
