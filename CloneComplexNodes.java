package hehaitao;
/**
 * 题目：有一个复杂链表，其结点除了有一个m_pNext指针指向下一个结点外，还有一个m_pSibling指向链表中的任一结点或者NULL。
 * @author hongbin.gao
 * 
 *
 */

class ComplexNode{  //复杂链表节点
	int val;
	ComplexNode next;
	ComplexNode sibling;
	public ComplexNode(int val){
		this.val = val;
	}
}


public class CloneComplexNodes {
	public static void main(String[] args){
		//程序中的例子和何海涛日志中的例子相同，我只是将ABCDE换成了1、2、3、4、5而已。
		ComplexNode head = new ComplexNode(1);
		ComplexNode p1 = new ComplexNode(2);
		ComplexNode p2 = new ComplexNode(3);
		ComplexNode p3 = new ComplexNode(4);
		ComplexNode p4 = new ComplexNode(5);
		
		head.next = p1;
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = null;
		
		head.sibling = p2;
		p1.sibling = p4;
		p3.sibling = p1;
		p2.sibling = null;
		p4.sibling = null;
		
		ComplexNode cloneHead = cloneComplexNodesII(head);
		while(cloneHead!= null){
			System.out.print("val="+cloneHead.val + ",");
			if(cloneHead.next == null)
				System.out.print("next=null,");
			else
			   System.out.print("next=" + cloneHead.next.val + ",");
			if(cloneHead.sibling == null)
				System.out.println("sibling=null;");
			else
			     System.out.println("sibling="+ cloneHead.sibling.val + ";");
			
			cloneHead = cloneHead.next;
		}
		
	}
	/**
	 * cloneComplexNodesI是按照常规的思路来编写的，先复制主题，再复制sibling，时间复杂度为O(n*n);
	 * @param head
	 * @return
	 */
	public static ComplexNode cloneComplexNodesI(ComplexNode head){  //复制复杂链表
		if(head == null)
			return null;
		
		ComplexNode headp = head;
		ComplexNode root = new ComplexNode(headp.val); //开始复制第一个节点
		ComplexNode rootp =root;
		
		headp = headp.next;
		while(headp != null){  //先复制复杂链表的主题部分，和next。
			ComplexNode p = new ComplexNode(headp.val);
			rootp.next = p;
			rootp = rootp.next;
			headp = headp.next;
		}
		
		ComplexNode headp2 = headp = head;
		ComplexNode rootp2 = rootp = root;
		int index = 0; //和头结点的距离
		int num1 = 0; //表示headp现在位于哪里
		int num2 = 0; //表示rootp现在位于哪里
		
		while(headp!= null){
			index = 0; //index用来表示对应的sibling是链表的第几个节点
			
			while(headp.next!=null && headp.sibling == null){
				headp = headp.next;
				num1 ++;
			}
			
				headp2 =head;
				while(headp2 != headp.sibling){
					headp2 =headp2.next;
					index ++;
				}
			
			
			
			while(rootp.next!=null && num2<num1){
				rootp = rootp.next;
				rootp.sibling = null;
				num2 ++;
			}
			
				rootp2 = root;
				while(index >0){
					rootp2 = rootp2.next;
					index--;
				}
				
				rootp.sibling = rootp2;
				headp = headp.next;
				num1++;
				rootp = rootp.next;
				num2++;
			}
		
		return root;
	}
	/**
	 * 对应何海涛的方法三，将新复制的节点连接在原节点后面，最后再将链表拆开为两个链表。
	 * @param head
	 * @return
	 */
	public static ComplexNode cloneComplexNodesII(ComplexNode head){  //复制复杂链表
		if(head == null)
			return null;
		
		//先复制节点
		ComplexNode headp = head;
		
		while(headp != null){
			ComplexNode p = new ComplexNode(headp.val);
			p.next = headp.next;
			headp.next = p;
			headp = p.next;
		}
		
		//处理sibling
		headp = head;
		ComplexNode rootp = null; //拆分过程中处于链表的尾部，进行操作。
		rootp  = headp.next;
		
		while(headp !=null){
			if(headp.sibling != null)
				rootp.sibling = headp.sibling.next;
			else
				rootp.sibling = null;
			
			headp = rootp.next;
			if(headp !=null)
			   rootp = headp.next;
		}
		
		//拆链表
		ComplexNode root = null; //要返回的指向新复制的链表的头结点。
		rootp = null;
		
		headp = head;
		root = headp.next;
		headp.next = root.next;
		rootp = root;
		headp = headp.next;
		
		while(headp!=null){
			rootp.next = headp.next;
			rootp = rootp.next;
			headp.next = rootp.next;
			headp = headp.next;
		}
		rootp.next = null;
		return root;
	}
}
