package hehaitao;
/**
 * 题目：两个单向链表，找出它们的第一个公共结点。
 * @author hongbin.gao
 *
 */

public class FindFirstCommonNode {
	//head1:  1->2->3->4->5->6->7->8;
	//head2:  5->5->5->5->5->5->6->7->8;后面三个节点为重复节点。
	public static void main(String[] args){
		Node p1 = new Node(1);
		Node p2 = new Node(2);
		Node p3 = new Node(3);
		Node p4 = new Node(4);
		Node p5 = new Node(5);
		Node p6 = new Node(6);
		Node p7 = new Node(7);
		Node p8 = new Node(8);
		
		p1.next = p2; p2.next = p3;
		p3.next = p4; p4.next = p5;
		p5.next = p6; p6.next = p7;
		p7.next = p8; p8.next = null;
		
		Node q1 = new Node(5);
		Node q2 = new Node(5);
		Node q3 = new Node(5);
		Node q4 = new Node(5);
		Node q5 = new Node(5);
		Node q6 = new Node(5);
		
		q1.next = q2; q2.next = q3;
		q3.next = q4; q4.next = q5;
		q5.next = q6; q6.next = p6;
		
		
		Node result = findFirstCommonNode(p1,q1);
		System.out.println(result.val);
	}
	
	public static Node findFirstCommonNode(Node head1, Node head2){
		if(head1 == null || head2 == null)
			return null;
		
		int length_1 = 1;
		int length_2 = 1;
		
		Node pHead1 = head1;
		Node pHead2 = head2;
		
		while(pHead1.next != null){
			length_1 ++;
			pHead1 = pHead1.next;
		}
		
		while(pHead2.next != null){
			length_2 ++;
			pHead2 = pHead2.next;
		}
		
		if(pHead1 != pHead2)  //如果最后一个节点不相同，则直接返回null。
			return null;
		
		pHead1 = head1;
		pHead2 = head2;
		if(length_1>length_2){
			while(length_1>length_2){
				pHead1 = pHead1.next;
				length_1 --;
			}
		}
		else if(length_1 < length_2){
			while(length_1 < length_2){
				pHead2 = pHead2.next;
				length_2 --;
			}
		}
		
		while(pHead1 != pHead2){
			pHead1 = pHead1.next;
			pHead2 = pHead2.next;
		}
		return pHead1;
	}

}
