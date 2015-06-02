package test.com.willing.algorithm.other;

import org.junit.Assert;
import org.junit.Test;

import com.willing.algorithm.other.Select;

public class TestSelect {

	@Test
	public void test() throws Exception
	{
		Integer[] ints = new Integer[]{3, 9, 2, 5, 8, 3, 6, 2};
		
		Assert.assertEquals(Integer.valueOf(9), Select.select(ints, 2));
		Assert.assertEquals(Integer.valueOf(3), Select.select(ints, 6));
	}
}
