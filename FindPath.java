package hehaitao;

import java.util.Stack;

/**
 * 题目：输入一个整数和一棵二元树。从树的根结点开始往下访问一直到叶结点所经过的所有结点形成一条路径。打印出和与输入整数相等的所有路径。
 * @author hongbin.gao
 *
 */

public class FindPath {
	public static void main(String[] args){
		//本测试用例和何海涛中的测试用例相同。
		TreeNode root = new TreeNode(10);
		TreeNode p1 = new TreeNode(5);
		TreeNode p2 = new TreeNode(12);
		TreeNode p3 = new TreeNode(4);
		TreeNode p4 = new TreeNode(7);
		
		
		root.left = p1; root.right = p2;
		p1.left = p3; p1.right = p4;
		p2.left = p2.right = null;
		p3.left = null; p3.right = null;
		p4.left = p4.right = null;
		
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		int sum = 22;
		if(root == null && sum ==0)
			return ;
		else{
			stack.push(root);
			sum -= root.val;
			findPath(sum,stack);
		}
	}
	
	public static void findPath(int sum, Stack<TreeNode> stack){
		TreeNode pNode = null;
		
		if(sum == 0 && stack.peek().left == null && stack.peek().right == null){ //如果sum==0,并且到达叶节点,准备输出
			Stack<TreeNode> temp = new Stack<TreeNode>();
			while(!stack.isEmpty()){
				TreeNode p = stack.pop();
				temp.push(p);
			}
			while(!temp.isEmpty()){
				TreeNode p = temp.pop();
				if(!temp.isEmpty())
      				System.out.print(p.val + ",");
				if(temp.isEmpty())
					System.out.println(p.val + ";");
				stack.push(p);
			}
			
			return ;
		}
		
		if(sum != 0 && stack.peek().left == null && stack.peek().right == null)  //如果已经到达叶节点，但是sum！=0，则直接返回，不做处理。
			return ;
		if(stack.peek().left != null){ //如果不是叶节点，并且存在左子树。
			pNode = stack.peek().left;
			sum -= pNode.val;
			stack.push(pNode);
			findPath(sum,stack);
			sum += pNode.val;
			stack.pop();
		}
		if(stack.peek().right != null){  //如果存在右子树，则进行右子树的递归
			pNode = stack.peek().right;
			sum -= pNode.val;
			stack.push(pNode);
			findPath(sum,stack);
			sum += pNode.val;
			stack.pop();
		}
		return ;
	}

}
