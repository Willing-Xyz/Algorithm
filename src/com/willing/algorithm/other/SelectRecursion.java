package com.willing.algorithm.other;


/**
 * 返回数组中第i小的对象
 * 期望时间为线性
 * @author Willing
 *
 */
public class SelectRecursion {

	/**
	 * 递归实现
	 * @param arr
	 * @param i  从1开始
	 * @throws Exception 
	 */
	public static <T extends Comparable<T>> T select(T[] arr, int i) throws Exception
	{
		if (i < 1 || i > arr.length)
		{
			throw new Exception("必须为1到数组长度之间的值");
		}
		
		return subSelect(arr, 0, arr.length - 1, i);
	}
	
	public static <T extends Comparable<T>> T subSelect(T[] arr, int p, int r, int i)
	{
		if (p == r)
		{
			return arr[p];
		}
		
		int q = paration(arr, p, r);
		
		int k = q - p + 1;
		if (k == i)
		{
			return arr[q];
		}
		else if (k > i)
		{
			return subSelect(arr, p, q - 1, i);
		}
		else
		{
			return subSelect(arr, q + 1, r, i - k);
		}
	}
	
	/**
	 *  
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 */
	private static <T extends Comparable<T>> int paration(T[] arr, int left, int right)
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
