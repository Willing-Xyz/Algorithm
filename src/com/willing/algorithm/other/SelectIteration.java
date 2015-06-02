package com.willing.algorithm.other;

/**
 * 迭代实现
 * @author Willing
 *
 */
public class SelectIteration {

	public static <T extends Comparable<T>> T select(T[] arr, int i) throws Exception
	{
		if (i < 1 || i > arr.length)
		{
			throw new Exception("必须为1到数组长度之间的值");
		}
		
		int p = 0;
		int r = arr.length - 1;
		
		while (p <= r)
		{
			int q = paration(arr, p, r);
			
			int k = q - p + 1;
			
			if (k == i)
			{
				return arr[k - 1];
			}
			else if (k < i)
			{
				p = q + 1;
				i = i - k;
			}
			else
			{
				r = q - 1;
			}
			
		}
		
		return null;
	}
	
	/**
	 * 不交换，只定位
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
					
//					T tmp = arr[i];
//					arr[i] = arr[j];
//					arr[j] = tmp;	
				}
		}	
		
//		T tmp = arr[i + 1];
//		arr[i + 1] = arr[right];
//		arr[right] = tmp;
		
	 
		
		return i + 1;
	}
}
