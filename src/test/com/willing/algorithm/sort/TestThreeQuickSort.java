package test.com.willing.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

import com.willing.algorithm.sort.ThreeQuickSort;

public class TestThreeQuickSort {
	@Test
	public void testInsertSort()
	{
		Integer[] ints = new Integer[]{2,1,3}; 
//		ThreeQuickSort.sort(ints);
//		Assert.assertArrayEquals(new Integer[]{1, 2, 3}, ints);
		
		ints = new Integer[]{ 5,2, 4, 5, 3, 9, 10, 5, 5, 8, 5};
		ThreeQuickSort.sort(ints);
		Assert.assertArrayEquals(new Integer[]{2, 3,4, 5, 5, 5, 5, 5, 8, 9, 10}, ints);
	}
	
}
