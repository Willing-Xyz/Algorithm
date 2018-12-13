package com.willing.algorithm.test.sort;

import org.junit.Assert;
import org.junit.Test;

import com.willing.algorithm.sort.Inversion;

public class TestInversion {

	@Test
	public void test() {
		
		Integer[] ints = new Integer[]{4, 3, 2, 1}; // 1 + 2 + 3
		long v = Inversion.inversion(ints);
		
		Assert.assertEquals(6, v);
		
	}

}
