package com.willing.algorithm.sort;

/**
 * 思路：

	1. 对每一个元素，确定小于它的元素个数
	2. 然后直接把该元素放到相应的位置上

特点：

	* 稳定
	* 不是原址排序


可优化点：

	* 

运行时间：   θ(n + k) k表示数值的范围

 * @author Willing
 *
 */
public class CountingSort {

	public static int[] sort(int[] arr, int max)
	{
		int[] c = new int[max];
		int[] b = new int[arr.length];
		
		
		for (int i = 0; i < c.length; ++i)
		{
			c[i] = 0;
		}
		
		for (int i = 0; i < arr.length; ++i)
		{
			c[arr[i]]++;
		}
		for (int i = 1; i < c.length; ++i)
		{
			c[i] += c[i - 1];
		}
		for (int i = arr.length - 1; i >= 0; --i)
		{
			b[c[arr[i]] - 1] = arr[i];
			--c[arr[i]];
		}
		
		return b;
	}
}
