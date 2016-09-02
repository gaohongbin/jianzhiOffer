package hehaitao;

import java.util.Stack;

/**
 * 题目：输入一个链表的头结点，从尾到头反过来输出每个结点的值。
 * @author hongbin.gao
 *
 */

public class PrintListReversely {
	public static void main(String[] args){
		Node head = new Node(1);
		Node p2 = new Node(2);
		Node p3 = new Node(3);
		Node p4 = new Node(4);
		Node p5 = new Node(5);
		Node p6 = new Node(6);
		
		head.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		p5.next = p6;
		p6.next = null;
		
		printListReversely_3(head);
	}
	/**
	 * 方法一：用递归实现
	 * @param head
	 */
	public static void printListReversely_1(Node head){
		if(head == null)  //链表为空直接返回
			return ;
		
		if(head.next == null){ //链表只有一个节点，则直接打印
			System.out.println(head.val);
		}
		else{
			printListReversely_1(head.next);
			System.out.println(head.val);
		}
	}
	
	/**
	 * 方法二：通过维护一个栈来实现。
	 * @param head
	 */
	public static void printListReversely_2(Node head){
		if(head == null)
			return ;
		if(head.next == null){
			System.out.println(head.val);
		}
		
		Stack<Node> stack = new Stack<Node>();
		while(head != null){
			stack.push(head);
			head = head.next;
		}
		
		while(!stack.isEmpty()){
			Node p = stack.pop();
			System.out.println(p.val);
		}
	}
	
	/**
	 * 方法三：先将链表反转，再顺序输出。
	 * @param head
	 */
	public static void printListReversely_3(Node head){
		if(head == null)  //链表为空，直接返回
			return ;
		 
		if(head.next == null){  //链表只包含一个节点， 直接数据即可
			System.out.println(head.val);
		}
		else{   //链表反转
			Node temp = null;
			Node pHead = head;
			head = head.next;
			pHead.next = null;
			
			while(head != null){
				temp = head;
				head = head.next;
				temp.next = pHead;
				pHead = temp;
			}
			
			while(pHead != null){ //反转完成后输出
				System.out.println(pHead.val);
				pHead = pHead.next;
			}
		}
	}
}
