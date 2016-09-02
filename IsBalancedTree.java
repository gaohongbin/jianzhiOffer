package hehaitao;
/**
 * 题目：输入一棵二叉树的根结点，判断该树是不是平衡二叉树。如果某二叉树中任意结点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * @author hongbin.gao
 *
 */
/*class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val){
		this.val = val;
	}
}*/
class Depth{
	int height;
	public Depth(int val){
		height = val;
	}
	public void setHeight(int val){
		height = val;
	}
	public int getHeight(){
		return height;
	}
}
public class IsBalancedTree {
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		TreeNode rootLeft = new TreeNode(2);
		TreeNode rootRight = new TreeNode(3);
		TreeNode p1 = new TreeNode(4);
		TreeNode p2 = new TreeNode(5);
		
		root.left = rootLeft;
		root.right = rootRight;
		rootLeft.left = p1;
		rootLeft.right =null;
		p1.right = null;
		p1.left = p2;
		p2.left = p2.right =null;
		
		rootRight.left = rootRight.right = null;
		
		boolean result = IsBalancedII(root,new Depth(0));
		System.out.println(result);
	}
	
    /**
     * 方法一：递归判断
     * @param root
     * @return
     */
	public static boolean IsBalancedI(TreeNode root){
		if(root == null)
			return true;
		
		boolean left = IsBalancedI(root.left);
		if(!left)
			return false;
		boolean right = IsBalancedI(root.right);
		if(!right)
			return false;
		
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		if(Math.abs(leftHeight - rightHeight)>1)
			return false;
		return true;
	}
	
	public static int height(TreeNode root){
		if(root == null)
			return 0;
		
		int left = height(root.left);
		int right = height(root.right);
		
		return left>right?left+1:right+1;
	}
	
	/**
	 * 方法二：后续遍历，一遍查完整个二叉树
	 * @param root
	 * @return
	 */
	public static boolean IsBalancedII(TreeNode root,Depth depth){
		if(root == null){
			depth.setHeight(0);
			return true;
		}
		
		Depth left = new Depth(0), right = new Depth(0);
		if(IsBalancedII(root.left,left) && IsBalancedII(root.right,right)){
			int diff = left.getHeight() - right.getHeight();
			if(Math.abs(diff)<1){
				depth.setHeight(1 + (left.getHeight()>right.getHeight()?left.getHeight():right.getHeight()));
				return true;
			}
		}
		return false;
			
	}

}
