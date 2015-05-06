package test.com.willing.algorithm.sort;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.willing.algorithm.sort.MergeSort;


public class TestMergeSort {

	@Test
	public void test() {
		
		Integer[] ints = new Integer[]{2, 5, 3};
		MergeSort.sort(ints);
		
		Assert.assertArrayEquals(new Integer[]{2, 3, 5}, ints);
		
	}

	@Test
	public void testStable()
	{
		Integer i1 = new Integer(3);
		Integer i2 = new Integer(3);
		
		Integer[] ints = new Integer[]{4, i1, i2, 2};
		MergeSort.sort(ints);
		
		Assert.assertArrayEquals(new Integer[]{2, i1, i2, 4}, ints);
		
		Assert.assertSame(i1, ints[1]);
	}
}
