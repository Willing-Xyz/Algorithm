package test.com.willing.algorithm.other;

import org.junit.Assert;
import org.junit.Test;

import com.willing.algorithm.other.SelectIteration;

public class TestSelectIteration {
	@Test
	public void test() throws Exception
	{
		Integer[] ints = new Integer[]{3, 9, 2, 5, 8, 3};
		
		Assert.assertEquals(Integer.valueOf(2), SelectIteration.select(ints, 1));
		Assert.assertEquals(Integer.valueOf(3), SelectIteration.select(ints, 2));
		Assert.assertEquals(Integer.valueOf(3), SelectIteration.select(ints, 3));
		Assert.assertEquals(Integer.valueOf(5), SelectIteration.select(ints, 4));
		Assert.assertEquals(Integer.valueOf(8), SelectIteration.select(ints, 5));
		Assert.assertEquals(Integer.valueOf(9), SelectIteration.select(ints, 6));
		
	}
}
