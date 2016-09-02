package hehaitao;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 题目：输入二叉树中的两个结点，输出这两个结点在数中最低的共同父结点。
 * @author hongbin.gao
 *
 */

public class LastCommonParent {
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		TreeNode p1 = new TreeNode(2);
		TreeNode p2 = new TreeNode(3);
		TreeNode p3 = new TreeNode(4);
		TreeNode p4 = new TreeNode(5);
		
		TreeNode p5 = new TreeNode(6);
		
		root.left = p1;  root.right = p2;
		p1.left = p3;  p1.right = p4;
		p2.left = p5;p2.right = null;
		p3.left = p3.right = null;
		p4.left = p4.right = null;
		p5.left = p5.right = null;
		
		TreeNode lastParent = lastCommonParent_2(root,p3,p2);
		System.out.println(lastParent.val);
	}
	/**
	 * 方法一：用普通递归的方式。
	 * @param root
	 * @param p1
	 * @param p2
	 * @return
	 */
	public static TreeNode lastCommonParent_1(TreeNode root, TreeNode p1, TreeNode p2){ //在以root为根的二叉树中寻找p1,p2的共同最低父节点。
		if(root == null)
			return null;
		if(p1 == null && p2 != null)
			return p2;
		if(p1 != null && p2 == null)
			return p1;
		
		if(hasNode(root.left,p1) && hasNode(root.left,p2))
			return lastCommonParent_1(root.left,p1,p2);
		else if(hasNode(root.right, p1) && hasNode(root.right,p2))
			return lastCommonParent_1(root.right,p1,p2);
		else
			return root;
	}
	
	public static boolean hasNode(TreeNode root, TreeNode pNode){ //判断pNode是否在以root为根的二叉树中。
		if(root == null && pNode != null)
			return false;
		if(pNode == null)
			return true;
		
		if(root == pNode)
			return true;
		
		if(hasNode(root.left,pNode) || hasNode(root.right,pNode))
			return true;
		else 
			return false;
	}
	
	/**
	 * 因为方法一使用递归，在对二叉树进行遍历时，会有很多重复的计算，所以时间复杂度较低。
	 * 方法二：如果可以分别从p1,p2出发，找到一条指向root的链表，则我们只需要分析p1--->root和p2--->root的第一个公共节点即可。
	 * 这样虽然空间复杂度多一些，但是时间复杂度降为O(n),是非常可取的。
	 * @param root
	 * @param p1
	 * @param p2
	 * @return
	 */
	public static TreeNode lastCommonParent_2(TreeNode root, TreeNode p1, TreeNode p2){
		LinkedList<TreeNode> linkedList1 = new LinkedList<TreeNode>();
		LinkedList<TreeNode> linkedList2 = new LinkedList<TreeNode>();
		
		boolean flag1 =  linkedTree(root, p1, linkedList1);
		boolean flag2 = linkedTree(root, p2, linkedList2);
		
        int length1 = linkedList1.size();
        int length2 = linkedList2.size();
        int i=0;
        if(length1 <= 0 || length2 <=0)
        	return null;
        
        TreeNode common =null; 
        while(i<length1 && i<length2 && linkedList1.get(i) == linkedList2.get(i)){
        	common = linkedList1.get(i);
        	i++;
        }
        
        return common;
	}
	
	public static boolean linkedTree(TreeNode root, TreeNode p, LinkedList<TreeNode> linkedList){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode temp = null;
		if(root == null)
			return false;
		
		if(p == null)
			return true;
		
		if(root == p){
			linkedList.add(root);
			return true;
		}
		
		if(root != null){
			linkedList.add(root);
			boolean flag = linkedTree(root.left,p,linkedList);
	        if(flag)
	        	return true;
	        else{
	        	if(root.left != null){
	        	   linkedList.removeLast();  //如果左子树不行，则退出来，检测右子树。
	        	   flag = linkedTree(root.right,p,linkedList);
	        	}
	        	else{
	        		flag = linkedTree(root.right,p,linkedList);
	        	}
	        	if(flag)
	        		return true;
	        	else{
	        		if(root.right != null)
	        			linkedList.removeLast();
	        	return false;
	        	}
	        }
		}
		return false;
	}
	
}
