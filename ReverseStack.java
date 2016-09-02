package hehaitao;

import java.util.Stack;

/**
 * 题目：用递归颠倒一个栈。例如输入栈{1, 2, 3, 4, 5}，1在栈顶。颠倒之后的栈为{5, 4, 3, 2, 1}，5处在栈顶。
 * 思路：既然是递归，则我们先把1看做一个整体，余下的2345看做一个整体，然后递归对2345进行处理。
 * @author hongbin.gao
 *
 */
public class ReverseStack {
	/**
	 * 方法一：先将1和2345调换位置，再对2345做调整。 
	 */
	
	public static <T> void reverseStack_1(Stack<T> stack,int low, int high){
		if(stack == null || stack.size() <2)
			return ;
		if(low>high){
			return ;
		}
		
		T top = stack.pop();  //把栈最上面的元素保存下来。
		addReverseStack_1(stack,low,high-1,top); //将top和整个剩余元素调换位置
		reverseStack_1(stack,low,high-1);
	}
	
	public static <T> void addReverseStack_1(Stack<T> stack,int low,int high, T element){
		if(low>high){
			stack.push(element);
		}
		else{
			T top = stack.pop();
			addReverseStack_1(stack,low+1,high,element);
			stack.push(top);
		}
	}
	/**
	 * 方法二：先把1拿出来，栈里只剩2345，然后对2345在做调整，等2345全部调整5432后，把1放到栈底，5432保持不动。
	 * 其实两种方法思想相同，只是写出的代码稍微不同。
	 */
	public static <T> void reverseStack_2(Stack<T> stack){
		if(stack == null || stack.size() <2)
			return ;
		
		T top = stack.pop();
		reverseStack_2(stack);
		addReverseStack_2(stack,top);
	}
	
	public static <T> void addReverseStack_2(Stack<T> stack, T element){
		if(stack.isEmpty()){
			stack.push(element);
		}
		else{
			T top = stack.pop();
			addReverseStack_2(stack,element);
			stack.push(top);
		}
	}
	
	//main方法
	public static void main(String[] args){
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		//reverseStack_1(stack,0,stack.size()-1);
		reverseStack_2(stack);
		
		while(!stack.isEmpty())
			System.out.println(stack.pop());
	}
	

}
