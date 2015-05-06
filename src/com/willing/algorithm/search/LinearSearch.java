package com.willing.algorithm.search;

public class LinearSearch {
	
	
	/**
	 * 在数组arr中搜索k
	 * @param arr
	 * @param k 要搜索的对象
	 * @return 成功返回数组索引，失败返回-1
	 */
	public static <T> int search(T[] arr, T k)
	{
		for (int i = 0; i < arr.length; ++i)
		{
			if (k.equals(arr[i]))
			{
				return i;
			}
		}
		return -1;
	}
	
}
