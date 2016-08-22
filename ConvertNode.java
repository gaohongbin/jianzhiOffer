/**
 * 题目：输入一棵二元查找树，将该二元查找树转换成一个排序的双向链表。要求不能创建任何新的结点，只调整指针的指向。
 * @author hongbin.gao
 *                 8
 *                / \
 *               4   9
 *              / \   \
 *             3   7   10
 *    思路： convertNode_1(TreeNode root)用来将以root为根节点的二叉树转换成双向链表，并返回节点最小的节点的指针。
 *    所以我们用递归的方式，先执行 convertNode_1(TreeNode root.left),再执行 convertNode_1(TreeNode root.right)，有了两个双向链表，
 *    我们只需要把root节点加进去就可以了。
 *               
 */

public class ConvertNode {
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
		
		TreeNode head = convertNode_1(root);  //返回最小节点的指针
		while(true){    //从小到大输出
			System.out.print(head.val);
			if(head.right != null){
				System.out.print("-");
				head = head.right;
			}
			else{
				System.out.println();
				break;
			}
		}
		
		while(true){  //从大到小输出
			System.out.print(head.val);
			if(head.left != null){
				System.out.print("-");
				head = head.left;
			}
			else{
				System.out.println();
				break;
			}
		}
	}
	
	//递归
	public static TreeNode convertNode_1(TreeNode root){
		if(root == null)
			return null;
	   
	   TreeNode left = convertNode_1(root.left);  //找到左子树的最小节点
	   TreeNode pLeft = left;   //pLeft用来找到root.left为根的二叉树的最大节点，因为要与root连接。
	   if(pLeft == null)
		   root.left = null;
	   else{
		   while(pLeft.right != null)
			   pLeft = pLeft.right;
	   }
	   root.left = pLeft;  //修改root.left和pLeft.right
	   if(pLeft != null){
		   pLeft.right = root;
	   }
	   
	   TreeNode right = convertNode_1(root.right);  //找到右子树的最小节点
	   
	   root.right = right;  //修改root.right和right.left
	   
	   if(right != null)  
		   right.left = root;
	   
	   if(left == null)    //返回最终结果
		   return root;
	   return left;
	}
}


