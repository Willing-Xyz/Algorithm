package com.willing.algorithm.datastructure;

import java.util.LinkedList;

public class BinaryTree<T extends Comparable<T>> {
	
	Node head;

	class Node 
	{
		LinkedList<T> obj;
		Node left;
		Node right;
		Node p;
 
		public Node(T o, Node l, Node r, Node p)
		{
			obj = new LinkedList<>();
			obj.add(o);
			left = l;
			right = r;
			this.p = p;
		}
	}
	
	public BinaryTree()
	{
		head = null;
	}
	
	public Node search(T val)
	{
		Node node = head;
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
		return min(head);
	}
	
	public Node min(Node val)
	{
		Node node = head;
		
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
		return max(head);
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
		if (head == null)
		{
			head = new Node(x, null, null, null);
		}
		else
		{
			Node node = head;
			Node p = node.p;
			
			Node tmp = new Node(x, null, null, p);
			
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
			if (result > 0)
			{
				p.left = tmp;
			}
			else
			{
				p.right = tmp;
			}
			
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
			
			if (val.right == node)
			{
				
			}
			node.p.right = null;
			node.right = val.right;
			node.left = val.left;
			node.p = val.p;
		}
	}
	
	private void replace(Node u, Node v)
	{
		if (u.p == null)
		{
			head = v;
		}
		if (u.p.left == v)
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
}
