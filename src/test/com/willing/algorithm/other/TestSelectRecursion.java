package test.com.willing.algorithm.other;
 

import org.junit.Assert;
import org.junit.Test;

import com.willing.algorithm.other.SelectRecursion;

public class TestSelectRecursion {

	@Test
	public void test() throws Exception
	{
		Integer[] ints = new Integer[]{3, 9, 2, 5, 8, 3};
		
		Assert.assertEquals(Integer.valueOf(9), SelectRecursion.select(ints, 2));
		Assert.assertEquals(Integer.valueOf(3), SelectRecursion.select(ints, 6));
	}
}
