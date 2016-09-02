package hehaitao;

/**
 * 输入两棵二叉树A和B，判断树B是不是A的子结构。
 * @author hongbin.gao
 * 
 * 思路：现在A中寻找与B树的根节点值相同的节点，然后再判断这个节点下面是不是与B树相同
 *
 */
/*class TreeNode{  //树节点
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val){
		this.val = val;
	}
}*/

public class HasSubtree {
	public static void main(String[] args){
		TreeNode head1 =new TreeNode(1);
		TreeNode p1 = new TreeNode(8);
		TreeNode p2 = new TreeNode(7);
		TreeNode p3 = new TreeNode(9);
		TreeNode p4 = new TreeNode(2);
		TreeNode p5 = new TreeNode(4);
		TreeNode p6 = new TreeNode(7);
		head1.left = p1; head1.right =p2;
		p2.left = p2.right = null;
		p1.left = p3; p1.right = p4;
		p3.left = p3.right =null;
		p4.left = p5; p4.right = p6;
		p5.left = p5.right = null;
		p6.left = p6.right =null;
		
		TreeNode head2 =new TreeNode(8);
		TreeNode q1 = new TreeNode(9);
		TreeNode q2 = new TreeNode(2);
		head2.left = q1;
		head2.right = q2;
		q1.left = q1.right = null;
		q2.left = q2.right =null;
		
		boolean result = hasSubtree(head1,head2);
		System.out.println(result);
	}
	
	public static boolean hasSubtree(TreeNode root1, TreeNode root2){
		if(root2 == null)  //root2为null
			return true;
		if(root1 == null && root2 != null) //root1为null，root2不为null，之间返回false。
			return false;
		
	    if(subtree(root1,root2)) 
			return true;
	    else
	    	return (hasSubtree(root1.left,root2) || hasSubtree(root1.right, root2));
		
	}
	
	public static boolean subtree(TreeNode root1,TreeNode root2){  //root1最上面是不是和root2相等
		if(root2 == null)
			return true;
		if(root1 == null && root2 != null)
			return false;
		
		if(root1.val != root2.val)
			return false;
		
		if(root1.val == root2.val){
			if(subtree(root1.left, root2.left) && subtree(root1.right,root2.right))
				return true;
			else
				return false;
		}
		else 
			return false;
	}
}
