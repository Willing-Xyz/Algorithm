package com.willing.algorithm.test.other;

import org.junit.Assert;
import org.junit.Test;

import com.willing.algorithm.other.Select;

public class TestSelect {

	@Test
	public void test() throws Exception
	{
		Integer[] ints = new Integer[]{3, 9, 2, 5, 8, 3};
		
//		Assert.assertEquals(Integer.valueOf(2), Select.select(ints, 1));
		Assert.assertEquals(Integer.valueOf(3), Select.select(ints, 2));
		Assert.assertEquals(Integer.valueOf(3), Select.select(ints, 3));
		Assert.assertEquals(Integer.valueOf(5), Select.select(ints, 4));
		Assert.assertEquals(Integer.valueOf(8), Select.select(ints, 5));
		Assert.assertEquals(Integer.valueOf(9), Select.select(ints, 6));
	}
}
