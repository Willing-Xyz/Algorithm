package test.com.willing.algorithm.datastructure;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import com.willing.algorithm.datastructure.RedBlackTree;

public class TestRedBlackTree
{
	@Test
	public void test()
	{
		RedBlackTree<Integer> bt = new RedBlackTree<Integer>();
		
		bt.insert(10);
		bt.insert(11);
		bt.insert(9);
		bt.insert(8);
		bt.insert(12);
		bt.insert(7);
		
		Assert.assertEquals(bt.min().getObj(), Integer.valueOf(7));
		Assert.assertEquals(bt.max().getObj(), Integer.valueOf(12));
		
		bt.inorder();
		System.out.println();
		
		bt.delete(bt.min());
		bt.delete(bt.max());
		
		bt.inorder();
		
		Assert.assertEquals(bt.min().getObj(), Integer.valueOf(8));
		Assert.assertEquals(bt.max().getObj(), Integer.valueOf(11));
		
	}

	@Test 
	public void testIsEmpty()
	{
		RedBlackTree<Integer> bt = new RedBlackTree<Integer>();
		
		Assert.assertEquals(true, bt.isEmpty());
		
		for (int i = 0; i < 1000; ++i)
		{
			bt.insert(i);
		}
		Assert.assertEquals(false, bt.isEmpty());
		
		for (int i = 999; i >=0; --i)
		{
			bt.delete(bt.search(i));
		}
		Assert.assertEquals(true, bt.isEmpty());
		
	}
	
 

	@Test
	public void testInsertDelete()
	{
		RedBlackTree<Integer> bt = new RedBlackTree<Integer>();
		Random random = new Random();
		
		for (int i = 0; i < 10000; ++i)
		{
			int val = random.nextInt(10000);
		 
			bt.insert(val);
		}
		while (!bt.isEmpty())
		{
			bt.delete(bt.max());
		}
	}
}
