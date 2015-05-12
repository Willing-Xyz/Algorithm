package test.com.willing.algorithm.other;

import org.junit.Assert;
import org.junit.Test;

import com.willing.algorithm.other.MaxSubArrayLinear;
import com.willing.algorithm.other.MaxSubArrayRescursive;
import com.willing.algorithm.other.Result;

public class TestMaxSubArrayLinear {

	@Test
	public void test()
	{
		int[] ints = new int[]{13, -3, -25, 20 , -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
		
		 
		Result result = MaxSubArrayLinear.maxSubArray(ints);
		
	
		Assert.assertEquals(7, result.getBegin());
		Assert.assertEquals(10, result.getEnd());
		Assert.assertEquals(43, result.getSum());
		 
	}
	
	/**
	 * 所有值为负时，应返回0.
	 */
	@Test
	public void testAllNeg()
	{
		int[] ints = new int[]{-1, -3, -2};
		
		Result result = MaxSubArrayLinear.maxSubArray(ints);
		
		Assert.assertEquals(0, result.getSum());
	}
}
