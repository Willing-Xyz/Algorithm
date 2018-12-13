package com.willing.algorithm.datastructure;

import java.util.Iterator;
import java.util.LinkedList;

public class RedBlackTree<T extends Comparable<? super T>>
{
	public static final int RED = 1;
	public static final int BLACK = 2;
	
	private Node mHead;
	
	// 表示公共叶节点
	private Node nil = new Node(null, BLACK, null, null, null);
	
	public class Node
	{
		private LinkedList<T> obj;
		private int color;
		private Node left;
		private Node right;
		private Node p;
		
		public Node(T obj, int color, RedBlackTree<T>.Node left,
				RedBlackTree<T>.Node right, RedBlackTree<T>.Node p)
		{
			super();
			this.obj = new LinkedList<T>();
			this.obj.add(obj);
			this.color = color;
			this.left = left;
			this.right = right;
			this.p = p;
		}
		
		public T getObj()
		{
			return obj.getFirst();
		}
		
	}

	/**
	 * 初始化mHead
	 * 首先，mHead需要被赋值为nil
	 * 然后它的父节点、两个子节点也需要被赋值为nil
	 * 否则，会出现空指针异常
	 * 
	 * 之后赋值给mHead的节点一定是新建的Node节点，而新建的Node节点在insert方法中，该方法已经给父节点、子节点赋好了值。
	 */
	public RedBlackTree()
	{
		mHead = nil;
		mHead.p = nil;
		mHead.left = nil;
		mHead.right = nil;
	}
	
	public boolean isEmpty()
	{
		return mHead == nil;
	}
	
	/**
	 *  思路： 根据旋转前后的图形，画表格，其中表示的是旋转后腰修改的节点，和节点要修改的属性
	 *       这样就可以验证算法是否正确（注意赋值的顺序）
	 *    x
	 *       y y为x的右孩子
	 * 需要修改的节点  -- 见算法导论p176 图13-2
	 * 			 left   right   p
	 * x		  
	 * y
	 * x的右孩子
	 * x的父节点
	 * 
	 * @param x
	 */
	private void leftRotate(Node x)
	{
		Node y = x.right;
		
		y.p = x.p;
		if (x.p == nil)
		{
			mHead = y;
		}
		else if (x.p.left == x)
		{
			x.p.left = y;
		}
		else
		{
			x.p.right = y;
		}
		
		x.right = y.left;
		
		if (y.left != nil)
		{
			y.left.p = x;
		}
		
		y.left = x;
		
		x.p = y;	
	}
	
	/**
	 *       y
	 *     x 为y的左孩子
	 * 	 * 需要修改的节点  -- 见算法导论p176 图13-2
	 * 			  left   right   p
	 * x		   
	 * y
	 * x的右孩子
	 * x的父节点
	 * 
	 * @param y
	 */
	private void rightRotate(Node y)
	{
		Node x = y.left;
		
		x.p = y.p;
		if (y.p == nil)
		{
			mHead = x;
		}
		else if (y.p.left == y)
		{
			y.p.left = x;
		}
		else
		{
			y.p.right = x;
		}
		
		y.left = x.right;
		if (x.right != nil)
		{
			x.right.p = y;
		}
		
		x.right = y;
		
		y.p = x;
	
	}

	/**
	 * 对于相同的值，加入到链表中
	 * @param val
	 */
	public void insert(T val)
	{
		Node added = new Node(val, RED, nil, nil, nil);
 
		Node y = nil;
		Node x = mHead;
		int result = 0;
		while (x != nil)
		{
			y = x;
			
			result = val.compareTo(x.getObj());
			if (result == 0)
			{
				x.obj.add(val);
				
				return;
			}
			else if (result > 0)
			{
				x = x.right;
			}
			else
			{
				x = x.left;
			}
		}
		added.p = y;
		if (y == nil)
		{
			mHead = added;
		}
		else if (result > 0)
		{
			y.right = added;
		}
		else
		{
			y.left = added;
		}
		
		insertFixup(added);
	}

	/**
	 * 思路：枚举每个有影响的点
	 * @param added
	 */
	private void insertFixup(RedBlackTree<T>.Node added)
	{
		while (added.p.color == RED)
		{
			if (added.p == added.p.p.left)
			{
				Node y = added.p.p.right;
				if (y.color == RED) 
				{
					added.p.color = BLACK;
					y.color = BLACK;
					added.p.p.color = RED;
					added = added.p.p;
					
					continue;
				}
				else if (added == added.p.right)
				{
					added = added.p;
					leftRotate(added);
				}
				
				added.p.color = BLACK;
				added.p.p.color = RED;
				rightRotate(added.p.p);
			}
			else
			{
				
			
				Node y = added.p.p.left;
				if (y.color == RED)
				{
					added.p.color = BLACK;
					y.color = BLACK;
					added.p.p.color = RED;
					added = added.p.p;
					
					continue;
				}
				else if (added == added.p.left)
				{
					added = added.p;
					rightRotate(added);
				}
				
				added.p.color = BLACK;
				added.p.p.color = RED;
				leftRotate(added.p.p);
				
			}
			
		}
		mHead.color = BLACK;
	}
	
	public void delete(Node del)
	{
		// y表示被删除的节点，或者表示替换被删除节点的那个节点
		Node y = del;
		// 表示y初始颜色
		int yOriginalColor = y.color;
		
		Node x;
		
		if (del.left == nil)
		{
			x = del.right;
			transplant(del, del.right);
		}
		else if (del.right == nil)
		{
			x = del.left;
			transplant(del, del.left);
		}
		else
		{
			y = min(del.right);
			yOriginalColor = y.color;
			
			x = y.right;
			if (y.p == del)
			{
				x.p = y;
			}
			else
			{
				transplant(y, y.right);
				y.right = del.right;
				y.right.p = y;
			}
			
			transplant(del, y);
			y.left = del.left;
			y.left.p = y;
			y.color = del.color;
		}
		
		if (yOriginalColor == BLACK)
		{
			deleteFixup(x);
		}
	}
	
	private void deleteFixup(RedBlackTree<T>.Node x)
	{
		while (x != mHead && x.color == BLACK)
		{
			if (x == x.p.left)
			{
				Node w = x.p.right;
				if (w.color == RED)
				{
					w.color = BLACK;
					x.p.color = RED;
					leftRotate(x.p);
					w = x.p.right;
				}
				if (w.left.color == BLACK && w.right.color == BLACK)
				{
					w.color = RED;
					x = x.p;
					
					continue;
				}
				else if (w.right.color == BLACK)
				{
					w.left.color = BLACK;
					w.color = RED;
					rightRotate(w);
					w = x.p.right;
				}
				w.color = x.p.color;
				x.p.color = BLACK;
				w.right.color = BLACK;
				leftRotate(x.p);
				x = mHead;
			}
			else
			{
				Node w = x.p.left;
				if (w.color == RED)
				{
					w.color = BLACK;
					x.p.color = RED;
					rightRotate(x.p);
					w = x.p.left;
				}
				if (w.right.color == BLACK && w.left.color == BLACK)
				{
					w.color = RED;
					x = x.p;
					
					continue;
				}
				else if (w.left.color == BLACK)
				{
					w.right.color = BLACK;
					w.color = RED;
					leftRotate(w);
					w = x.p.left;
				}
				w.color = x.p.color;
				x.p.color = BLACK;
				w.left.color = BLACK;
				rightRotate(x.p);
				x = mHead;	
			}
		}
		x.color = BLACK;
	}

	private void transplant(Node u, Node v)
	{
		if (u.p == nil)
		{
			mHead = v;
		}
		else if (u == u.p.left)
		{
			u.p.left = v;
		}
		else
		{
			u.p.right = v;
		}
		v.p = u.p;
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
		if (x !=  nil)
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
	
	public Node search(T val)
	{
		Node node = mHead;
		while (node != nil)
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
		
		if (node != nil)
		{
			while (node.left != nil)
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
		
		if (node != nil)
		{
			while (node.right != nil)
			{
				node = node.right;
			}
		}
		return node;
	}
	
	public Node pre(Node val)
	{
		if (val.left != nil)
		{
			return max(val.left);
		}
		else
		{
			Node node = val.p;
			
			while (node != nil && val.left == val)
			{
				val = node;
				node = node.p;
			}
			return node;
		}
	}
	
	public Node next(Node val)
	{
		if (val.right != nil)
		{
			return max(val.right);
		}
		else
		{
			Node node = val.p;
			
			while (node != nil && val.right== val)
			{
				val = node;
				node = node.p;
			}
			return node;
		}
	}
	
}
