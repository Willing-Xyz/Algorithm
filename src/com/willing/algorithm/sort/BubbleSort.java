package com.willing.algorithm.sort;

/**
 * 冒泡排序(本质等价于选择排序，即每次选择一个最小值)
 * @author Willing
 *
 */
public class BubbleSort {

	public static <T extends Comparable<T>> void sort(T[] arr)
	{
		for (int i = 0; i < arr.length - 1; ++i)
		{
			for (int j = arr.length; j > i; --j)
			{
				if (arr[j].compareTo(arr[j - 1]) < 0)
				{
					exch(arr, j, j - 1);
				}
				// 在此处，arr[j]是arr[j] - arr[a.length]中的最小值
			}
		}
	}
	
	private static <T extends Comparable<T>> void exch(T[] arr, int a, int b)
	{
		T t = arr[a];
		arr[a] = arr[b];
		arr[b] = t;
	}
}
