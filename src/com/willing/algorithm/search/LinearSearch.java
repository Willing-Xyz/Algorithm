package com.willing.algorithm.search;

public class LinearSearch {
	
	
	/**
	 * ������arr������k
	 * @param arr
	 * @param k Ҫ�����Ķ���
	 * @return �ɹ���������������ʧ�ܷ���-1
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
