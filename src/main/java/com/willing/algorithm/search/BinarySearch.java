package com.willing.algorithm.search;

/**
 * 二分查找
 * 思路：

	1. 首先，和序列的中点进行比较
	2. 根据比较的结果，就可以过滤掉一半的元素

特点：

	* 待查找序列，是已排序的

可优化点：

	* 


运行时间：

	* 最坏情况：θ(lgn)
	* 平均情況：θ(lgn)
	* 最好情況：θ(lgn) 


 * @author Willing
 *
 */
public class BinarySearch {

	public static <T extends Comparable<T>> int search(T[] arr, T k)
	{
		return searchSub(arr, k, 0, arr.length - 1);
	}
	
	private static <T extends Comparable<T>> int searchSub(T[] arr, T k, int start, int end)
	{
		if (start >= end)
		{
			if (k.compareTo(arr[start]) == 0)
			{
				return start;
			}
			else
			{
				return -1;
			}
		}
		else
		{
			int mid = (start + end) / 2;
			
			int result = k.compareTo(arr[mid]);
			
			if (result == 0)
			{
				return mid;
			}
			else if (result < 0)
			{
				return searchSub(arr, k, start, mid - 1);
			}
			else
			{
				return searchSub(arr, k, mid + 1, end);
			}

		}
	
		
	}
}
