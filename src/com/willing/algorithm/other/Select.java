package com.willing.algorithm.other;

import java.lang.reflect.Array;
import java.util.Arrays;

/** 
 * 最坏情况下，时间复杂度为线性时间
 * @author Willing
 *
 */
public class Select {
	
	 
	
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
		
		T tmp = mid(arr, p, r);
		for (int x = 0; x < arr.length; ++x)
		{
			if (tmp.equals(arr[x]))
			{
				T t = arr[x];
				arr[x] = arr[r];
				arr[r] = t;
				
				break;
			}
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
	
	@SuppressWarnings("unchecked")
	private static <T extends Comparable<T>> T mid(T[] arr, int p, int r)
	{
		if (r == p)
		{
			return arr[p];
		}
		int len = r - p + 1;
		int n = len / 5 + (len % 5 == 0 ? 0 : 1);
		
		arr = Arrays.copyOf(arr, arr.length);
		
		// 应该只定义一个
		T[] tmp = (T[])Array.newInstance(arr[0].getClass(), n);
		int i = 0;
		for (i = 0; i < n - 1; ++i)
		{
			sort(arr, i * 5, 5 * i + 4);
			tmp[i] = arr[i * 5 + 2];
		}
		sort(arr, i * 5, len - 1);
		tmp[i] = arr[(len - 1 + i * 5 + 1) / 2];
		
		return mid(tmp, 0, tmp.length - 1);
		
 
		
		
	}
	
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
	
	private static <T extends Comparable<T>> void sort(T[] arr, int p, int r)
	{
		for (int i = p + 1; i <= r; ++i)
		{
			T key = arr[i];
			int j;
			for (j = i - 1; j >= p; --j)
			{
				arr[j + 1] = arr[j];
				if (key.compareTo(arr[j]) >= 0)
				{
					break;
				}
			}
			arr[j + 1] = key;
		}
		 
	}
}
