package com.willing.algorithm.test.sort;

import org.junit.Assert;
import org.junit.Test;

import com.willing.algorithm.sort.QuickSort;

 

public class TestQuickSort {

	@Test
	public void testInsertSort()
	{
		Integer[] ints = new Integer[]{2,1,3}; 
		QuickSort.sort(ints);
		Assert.assertArrayEquals(new Integer[]{1, 2, 3}, ints);
	}
	
 
}
