package com.willing.algorithm.test.sort;

import org.junit.Assert;
import org.junit.Test;

import com.willing.algorithm.sort.CountingSort;

public class TestCountingSort {

	@Test
	public void test()
	{
		int[] ints = new int[]{5, 2, 1, 4, 3};
		
		ints = CountingSort.sort(ints, 10);
		
		Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, ints);
	}
}
