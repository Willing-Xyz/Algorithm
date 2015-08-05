package com.willing.algorithm.sort;

/**
 *  思路：

	1. 划分为两部分（每次划分排定了一个元素）
	2. 对这两部分递归调用

特点：

	* 稳定
	* 常数因子比较小


可优化点：

	* 当所有元素相同时，使用三分快速排序，以防止较差的性能
	* 小数组使用插入排序

运行时间：

	* 最坏情况：θ(n²)
	* 平均情況：θ(nlgn)
	* 最好情況：θ(nlgn) 

 * @author Willing
 *
 */
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
	
	/**
	 * 
	 * @param arr 数组长度必然大于等于2 
	 * @param left
	 * @param right
	 * @return
	 */
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