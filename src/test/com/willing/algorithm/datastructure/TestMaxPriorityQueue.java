package test.com.willing.algorithm.datastructure;

 

import org.junit.Assert;
import org.junit.Test;

import com.willing.algorithm.datastructure.MaxPriorityQueue;

public class TestMaxPriorityQueue {

	@Test
	public void test()
	{
		MaxPriorityQueue<Integer> queue = new MaxPriorityQueue<>(Integer.class, 20);
		
		queue.insert(3);
		Assert.assertEquals(Integer.valueOf(3), queue.max());
		Assert.assertEquals(Integer.valueOf(3), queue.extractMax());
		
		queue.insert(5);
		Assert.assertEquals(Integer.valueOf(5), queue.max());
		Assert.assertEquals(Integer.valueOf(5), queue.extractMax());
	}
}
