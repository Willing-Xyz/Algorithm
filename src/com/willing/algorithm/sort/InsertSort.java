package com.willing.algorithm.sort;


/**
 * 插入排序   稳定
 * @author Willing
 *
 */

public class InsertSort {
	
	/**
	 * 插入排序的一个实现：对除第一个元素之外的所有元素迭代，每个元素插入它之前已排序的序列中。
	 * 插入方法：把当前元素和之前的元素依次比较，并把每个比较的元素向后移动，最后插入到合适的位置，
	 * @param arr 对传递的参数进行原址排序
	 * @return 返回排序后的参数
	 */
	public static <T extends Comparable<T>> void sort(T[] arr)
	{
		for (int i = 1; i < arr.length; ++i)
		{
			T key = arr[i];
			int j;
			for (j = i - 1; j >= 0; --j)
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
