package hehaitao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题目：输入一颗二元查找树，将该树转换为它的镜像，即在转换后的二元查找树中，左子树的结点都大于右子树的结点。
 * 用递归和循环两种方法完成树的镜像转换
 * @author hongbin.gao
 *                 8
 *                / \
 *               4   9
 *              / \   \
 *             3   7   10
 *
 */
public class MirrorRecursively {
	public static void main(String[] args){
		TreeNode root = new TreeNode(8);
		TreeNode p1 = new TreeNode(4);
		TreeNode p2 = new TreeNode(3);
		TreeNode p3 = new TreeNode(7);
		TreeNode p4 = new TreeNode(9);
		TreeNode p5 = new TreeNode(10);
		
		root.left = p1; root.right = p4;
		p1.left = p2; p1.right = p3;
		p2.left = p2.right = null;
		p3.left = p3.right = null;
		p4.left = null; p4.right = p5;
		p5.left = p5.right = null;
		
		mirrorRecursively_1(root);
		//inorder(root);
	}
	
	//中序遍历，输出二叉树
	public static void inorder(TreeNode root){
		if(root == null)
			return ;
		inorder(root.left);
		System.out.println(root.val);
		inorder(root.right);
	}
	
	//方法一：递归
	public static void mirrorRecursively_1(TreeNode root){
		if(root == null)
			return ;
		
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		mirrorRecursively_1(root.left);
		mirrorRecursively_1(root.right);
	}
	
	//方法二：遍历,就是用队列把节点都装进来，一次遍历每个节点。
	public static void mirrorRecursively_2(TreeNode root){
		if(root == null)
			return ;
		
		Queue<TreeNode> que = new LinkedList<TreeNode>(); 
		List<TreeNode> list = new ArrayList<TreeNode>();
		TreeNode p1 = new TreeNode(1);
		TreeNode p2 = new TreeNode(2);
		list.add(p1);
		list.add(0,p2);
		System.out.println(list.get(0).val);
		System.out.println(list.get(1).val);
		
	}

}
 