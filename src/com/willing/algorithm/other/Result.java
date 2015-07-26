package com.willing.algorithm.other;

public class Result
{
	private int begin;
	private int end;
	private long sum;
	
	public Result(long sum, int begin, int end)
	{
		this.sum = sum;
		this.begin = begin;
		this.end = end;
	}
	
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public long getSum() {
		return sum;
	}
	public void setSum(long sum) {
		this.sum = sum;
	}
	
	
}