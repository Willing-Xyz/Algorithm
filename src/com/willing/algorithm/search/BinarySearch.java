package com.willing.algorithm.search;

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
