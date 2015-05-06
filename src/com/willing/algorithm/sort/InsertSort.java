package com.willing.algorithm.sort;


/**
 * ��������   �ȶ�
 * @author Willing
 *
 */

public class InsertSort {
	
	/**
	 * ���������һ��ʵ�֣��Գ���һ��Ԫ��֮�������Ԫ�ص�����ÿ��Ԫ�ز�����֮ǰ������������С�
	 * ���뷽�����ѵ�ǰԪ�غ�֮ǰ��Ԫ�����αȽϣ�����ÿ���Ƚϵ�Ԫ������ƶ��������뵽���ʵ�λ�ã�
	 * @param arr �Դ��ݵĲ�������ԭַ����
	 * @return ���������Ĳ���
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
