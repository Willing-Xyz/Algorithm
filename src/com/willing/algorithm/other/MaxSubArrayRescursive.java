package com.willing.algorithm.other;

public class MaxSubArrayRescursive {

	public static Result maxSubArray(int[] arr)
	{
		return maxSubArraySub(arr, 0, arr.length - 1);
	}
	
	private static Result maxSubArraySub(int[] arr, int begin, int end)
	{
		if (end == begin)
		{
			return new Result(arr[begin], begin, begin);
		}
		
		int mid = (begin + end) / 2;
		
		Result left = maxSubArraySub(arr, begin, mid);
		Result right = maxSubArraySub(arr, mid + 1, end);
		Result cross = maxCrossSubArray(arr, begin, mid, end);
		
		if (left.getSum() > right.getSum() && left.getSum() > cross.getSum() && left.getSum() >= 0)
		{
			return left;
		}
		else if (right.getSum() > left.getSum() && right.getSum() > cross.getSum() && right.getSum() >= 0)
		{
			return right;
		}
		else
		{
			if (cross.getSum() >= 0)
			{
				return cross;
			}
			else
			{
				return new Result(0, -1, -1);
			}
		}
		
		 
	}
	
	private static Result maxCrossSubArray(int[] arr, int begin, int mid, int end)
	{
		long leftSum = Integer.MIN_VALUE;
		
		long sum = 0;
		int left = 0;
		for (int i = mid; i >= begin; --i)
		{
			sum += arr[i];
			if (sum > leftSum) 
			{
				leftSum = sum;
				left = i;
			}
			
		}
		
		long rightSum = Integer.MIN_VALUE;
		sum = 0;
		int right = 0;
		for (int i = mid + 1; i <= end; ++i)
		{
			sum += arr[i];
			if (sum > rightSum)
			{
				rightSum = sum;
				right = i;
			}
			
		}
		
		return new Result(leftSum + rightSum, left, right);
	
	}
	
 
}


