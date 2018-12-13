package com.willing.algorithm.datastructure;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 二叉搜索树
 * 元素相同时，放在同一个节点的链表里
 * 
 * @author Willing
 *
 * @param <T>
 */
public class BinaryTree<T extends Comparable<? super T>> {
	
	private Node mHead;

	public class Node 
	{
		private LinkedList<T> obj;
		
		private Node left;
		private Node right;
		private Node p;
 
		public Node(T o, Node l, Node r, Node p)
		{
			obj = new LinkedList<T>();
			obj.add(o);
			left = l;
			right = r;
			this.p = p;
		}
		
		public T getObj()
		{
			return obj.getFirst();
		}
	}
	
	public BinaryTree()
	{
		mHead = null;
	}
	
	public boolean isEmpty()
	{
		return mHead == null;
	}
	
	public Node search(T val)
	{
		Node node = mHead;
		while (node != null)
		{
			int result = node.obj.getFirst().compareTo(val);
			if (result == 0)
			{
				break;
			}
			else if (result < 0)
			{
				node = node.right;
			}
			else
			{
				node = node.left;
			}
		}
		return node;
	}
	
	public Node min()
	{
		return min(mHead);
	}
	
	public Node min(Node val)
	{
		Node node = mHead;
		
		if (node != null)
		{
			while (node.left != null)
			{
				node = node.left;
			}
		}
		
		return node;
	}
	
	public Node max()
	{
		return max(mHead);
	}
	
	public Node max(Node val)
	{
		Node node = val;
		
		if (node != null)
		{
			while (node.right != null)
			{
				node = node.right;
			}
		}
		return node;
	}
	
	public Node pre(Node val)
	{
		if (val.left != null)
		{
			return max(val.left);
		}
		else
		{
			Node node = val.p;
			
			while (node != null && val.left == val)
			{
				val = node;
				node = node.p;
			}
			return node;
		}
	}
	
	public Node next(Node val)
	{
		if (val.right != null)
		{
			return max(val.right);
		}
		else
		{
			Node node = val.p;
			
			while (node != null && val.right== val)
			{
				val = node;
				node = node.p;
			}
			return node;
		}
	}
	
	public void insert(T x)
	{
		if (mHead == null)
		{
			mHead = new Node(x, null, null, mHead);
			
			return;
		}
		Node node = mHead;
		Node p = node.p;
		
		
		
		int result = 0;
		while (node != null)
		{
			p = node;
			result = node.obj.getFirst().compareTo(x);
			if (result == 0)
			{
				node.obj.add(x);
				
				return;
			}
			else if (result > 0)
			{
				node = node.left;
			}
			else
			{
				node = node.right;
			}
		}
		Node tmp = new Node(x, null, null, p);
		if (result > 0)
		{
			p.left = tmp;
		}
		else
		{
			p.right = tmp;
		}
			
	}
	
	public void delete(Node val)
	{
		if (val.left == null)
		{ 
			replace(val, val.right); 
		}
		else if (val.right == null)
		{
			replace(val, val.left);
		}
		else
		{
			Node node = min(val.right);
			
			if (val.right != node)
			{
				replace(node, node.right);
				node.right = val.right;
				node.right.p = node;
			}
			replace(val, node);
			node.left = val.left;
			node.left.p = node;
		}
	}
	
	/**
	 * 替换子树
	 * @param u 被替换
	 * @param v 替换
	 */
	private void replace(Node u, Node v)
	{
		if (u.p == null)
		{
			mHead = v;
		}
		if (u.p.left == u)
		{
			u.p.left = v;
		}
		else
		{
			u.p.right = v;
		}
		if (v != null)
		{
			v.p = u.p;
		}
	}
	
	/**
	 * 中序遍历
	 */
	public void inorder()
	{
		subInorder(mHead);
	}
	
	private void subInorder(Node x)
	{
		if (x !=  null)
		{
			subInorder(x.left);
			
			LinkedList<T> list = x.obj;
			for (Iterator<T> ite = list.iterator(); ite.hasNext(); )
			{
				T t = ite.next();
				System.out.print(t.toString() + " , ");
			}
			
			subInorder(x.right);
		}
	}
}
