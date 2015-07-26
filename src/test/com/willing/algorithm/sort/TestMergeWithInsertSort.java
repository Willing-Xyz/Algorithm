package test.com.willing.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

import com.willing.algorithm.sort.MergeWithInsertSort;

public class TestMergeWithInsertSort {


	
	@Test
	public void test() {
		
		Integer[] ints = new Integer[]{2, 5, 3, 9, 8, 8, 4, 9};
		MergeWithInsertSort.sort(ints);
		
		Assert.assertArrayEquals(new Integer[]{2, 3, 4, 5, 8, 8, 9, 9}, ints);
		
	}

	@Test
	public void testStable()
	{
		Integer i1 = new Integer(8);
		Integer i2 = new Integer(8);
		
		Integer[] ints = new Integer[]{2, 5, 3, 9, i1, i2, 4, 9};
		MergeWithInsertSort.sort(ints);
		
		Assert.assertArrayEquals(new Integer[]{2, 3, 4, 5, i1, i2, 9, 9}, ints);
		
		Assert.assertSame(i1, ints[4]);
	}

}
