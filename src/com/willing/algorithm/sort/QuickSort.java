package com.willing.algorithm.sort;


public class QuickSort
{
	public static <T extends Comparable<T>> void sort(T[] arr)
	{
		subSort(arr, 0, arr.length - 1);		
	}
	
	public static <T extends Comparable<T>> void subSort(T[] arr, int left, int right)
	{
		if (left < right)
		{
			int mid = paration(arr, left, right);
			
			subSort(arr, left, mid - 1);
			subSort(arr, mid + 1, right);	
		}
	}
	
	public static <T extends Comparable<T>> int paration(T[] arr, int left, int right)
	{
		T x = arr[right];
		int i = left - 1;
		
		for (int j = left; j <= right - 1; ++j)
		{
				if (arr[j].compareTo(x) < 0)
				{
					++i;
					
					T tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;	
				}
		}	
		
		T tmp = arr[i + 1];
		arr[i + 1] = arr[right];
		arr[right] = tmp;
		
	 
		
		return i + 1;
	}
	
 
}