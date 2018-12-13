package com.willing.algorithm.sort;

/**
 * 堆排序
 * 
 *  思路：

	1. 构造堆
	2. 取出堆中的最大元素，并重新构造堆
	3. 重复第二步，直到完成

特点：

	* 稳定


可优化点：

	* 在计算Parent、Left、Right孩子时，可以使用位运算，提高速度
运行时间：

	* 最坏情况：θ(nlgn)
	* 平均情況：θ(nlgn)
	* 最好情況：θ(nlgn) 

 * 
 * @author Willing
 *
 */
public class HeapSort {
	
	public static <T extends Comparable<T>> void sort(T[] arr)
	{
		buildMaxHeap(arr);
		
		int heapSize = arr.length;
		for (int i = arr.length - 1; i >= 1; --i)
		{
			T t = arr[i];
			arr[i] = arr[0];
			arr[0] = t;
			
			heapSize--;
			
			maxHeapify(arr, heapSize, 0);
		}
	}
	
	private static <T extends Comparable<T>> void buildMaxHeap(T[] arr)
	{
		for (int i = arr.length / 2; i >= 0; --i)
		{
			maxHeapify(arr, arr.length, i);
		}
	}
	
	/**
	 * 包括递归和非递归
	 * @param arr
	 * @param heapSize
	 * @param i
	 */
	private static <T extends Comparable<T>> void maxHeapify(T[] arr, int heapSize, int i)
	{
		// 使用递归
//		int left = 2 * i + 1;
//		int right = 2 * i + 2;
//		int largest = i;
//		if (left < heapSize && arr[left].compareTo(arr[i]) > 0)
//		{
//			largest = left;
//		}
//		if (right < heapSize && arr[right].compareTo(arr[largest]) > 0)
//		{
//			largest = right;
//		}
//		
//		if (largest != i)
//		{
//			T t = arr[i];
//			arr[i] = arr[largest];
//			arr[largest] = t;
//			
//			maxHeapify(arr, heapSize, largest);
//		}
		
		// 不使用递归
		int left = 0;
		int right = 0;
		int largest = 0;
		while (i < heapSize)
		{
			left = 2 * i + 1;
			right = 2 * i + 2;
			largest = i;
			
			if (left < heapSize && arr[left].compareTo(arr[i]) > 0)
			{
				largest = left;
			}
			if (right < heapSize && arr[right].compareTo(arr[largest]) > 0)
			{
				largest = right;
			}
			
			if (largest != i)
			{
				T t = arr[i];
				arr[i] = arr[largest];
				arr[largest] = t;
				
				i = largest;
			}
			else
			{
				break;
			}
		}	
		
	}
	
 
 
	
}
