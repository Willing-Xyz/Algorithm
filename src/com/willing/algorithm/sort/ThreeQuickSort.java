package com.willing.algorithm.sort;

/**
 * 三分快速排序
 * 
 * @author Willing
 *
 */
public class ThreeQuickSort {

	public static <T extends Comparable<T>> void sort(T[] arr)
	{
		subSort(arr, 0, arr.length - 1);		
	}
	
	public static <T extends Comparable<T>> void subSort(T[] arr, int left, int right)
	{
		if (left < right)
		{
			int[] mid = paration(arr, left, right);
			
			subSort(arr, left, mid[0] - 1);
			subSort(arr, mid[1] + 1, right);	
		}
	}
	
 
	/**
	 * left <= pos <= i  ->  该区域小于分割元素 
	 * i < pos <= j      ->  该区域等于分割元素
	 * j < pos < k 		 ->  该区域大于分割元素
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 */
	public static <T extends Comparable<T>> int[] paration(T[] arr, int left, int right)
	{
		int i = left - 1;
		int j = left - 1;
		
		T x = arr[right];
		
		for (int k = left; k <= right - 1; ++k)
		{
			if (arr[k].compareTo(x) == 0)
			{
				 
				++j;
  				
				T tmp = arr[k];
				arr[k] = arr[j];
				arr[j] = tmp;
			}
			else if (arr[k].compareTo(x) < 0)
			{
				
				
				++j;
				T tmp = arr[j];
				arr[j] = arr[i + 1];
				arr[i + 1] = tmp;
				
				++i;
				if (k != j)
				{
					tmp = arr[i];
					arr[i] = arr[k];
					arr[k] = tmp;
				}
			}
		}
		
		++j;
		T tmp = arr[right];
		arr[right] = arr[j];
		arr[j] = tmp;
		
	 
		
		return new int[]{i + 1, j};
	}
	

}
