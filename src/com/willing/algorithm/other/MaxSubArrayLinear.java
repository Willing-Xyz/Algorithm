package com.willing.algorithm.other;

/**
 * ��������������ʱ���ʵ��
 * 
 * ˼·��
 * 	1. ���ȣ���ʼ���ͷ��ʼ
 * 	2. ����һֱ��ͷ������ͣ�ֱ���󵽵ĺ�С��0���Ż������ʼ�㡣��Ϊ�����С��0��������ֵ����ȻҪ������
 * 	3. һ���󵽵ĺ�С����0������һ��λ����Ϊ��ʼ��
 * 	4. ������󵽵ĺʹ���֮ǰ�ĺͣ���˵���Ϊ��ֹ��
 * 	5. �ص��ڶ������ظ���
 * 
 * @author Willing
 *
 */
public class MaxSubArrayLinear {

	public static Result maxSubArray(int[] arr)
	{
		int sum = 0;
		int finalSum = 0;
		int begin = 0;
		int end = 0;
		for (int i = 0; i < arr.length; ++i)
		{
			sum += arr[i];
			if (sum < 0)
			{
				sum = 0;
				begin = i + 1;
			}
			else if (sum > finalSum)
			{
				finalSum = sum;
				end = i;
			}
		}
		
		return new Result(finalSum, begin, end);
	}
}
