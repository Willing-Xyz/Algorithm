package com.willing.algorithm.sort;


/**
 * 思路：

	1. 首先，把序列分为已排序和未排序两部分
	2. 在未排序序列中，取一个元素，插入到已排序序列
	3. 直到未排序序列中为空

特点：

	* 小数据排序快
	* 受已排序程度的影响
	* 稳定

可优化点：

	* 在把一个元素插入到已排序序列中时，可以选择不同的插入方法

运行时间：

	* 最坏情况：θ(n²)
	* 平均情況：θ(n²)
	* 最好情況：θ(n) （已排好序）


 * 
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
	public static <T extends Comparable<? super T>> void sort(T[] arr)
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
