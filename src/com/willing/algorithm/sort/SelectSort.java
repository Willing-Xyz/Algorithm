package com.willing.algorithm.sort;

public class SelectSort {

	public static <T extends Comparable<T>> void sort(T[] arr)
	{
		for (int i = 0; i < arr.length - 1; ++i)
		{
			int index = min(arr, i, arr.length - 1);
			
			exch(arr, i, index);
		}
	}
	
	private static <T extends Comparable<T>> int min(T[] arr, int start, int end) 
	{
		int min = start;
		for (int i = start + 1; i <= end; ++i)
		{
			if (arr[i].compareTo(arr[min]) < 0)
			{
				min = i;
			}
		}
		
		return min;
	}
	
	private static <T extends Comparable<T>> void exch(T[] arr, int a, int b)
	{
		T t = arr[a];
		arr[a] = arr[b];
		arr[b] = t;
	}
}
