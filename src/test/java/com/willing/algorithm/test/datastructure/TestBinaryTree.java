package com.willing.algorithm.test.datastructure;


import org.junit.Assert;
import org.junit.Test;

import com.willing.algorithm.datastructure.BinaryTree;

public class TestBinaryTree
{

	@Test
	public void test()
	{
		BinaryTree<Integer> bt = new BinaryTree<Integer>();
		
		bt.insert(10);
		bt.insert(11);
		bt.insert(9);
		bt.insert(8);
		bt.insert(12);
		bt.insert(7);
		
		Assert.assertEquals(bt.min().getObj(), Integer.valueOf(7));
		Assert.assertEquals(bt.max().getObj(), Integer.valueOf(12));
		
		bt.inorder();
		
		bt.delete(bt.min());
		bt.delete(bt.max());
		
		bt.inorder();
		
		Assert.assertEquals(bt.min().getObj(), Integer.valueOf(8));
		Assert.assertEquals(bt.max().getObj(), Integer.valueOf(11));
		
	}

}
