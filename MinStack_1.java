package hehaitao;

import java.util.Stack;

/**
 * 题目：定义栈的数据结构，要求添加一个min函数，能够得到栈的最小元素。要求函数min、push以及pop的时间复杂度都是O(1)。
 * @author hongbin.gao
 *
 */
public class MinStack_1{
	public static void main(String[] args){
			MinStack minStack = new MinStack();
			minStack.push(5);
			minStack.push(4);
			minStack.push(3);
			minStack.push(2);
			minStack.push(1);
			minStack.push(3);
			
			System.out.println(minStack.pop().intValue());
			System.out.println(minStack.minStack().intValue());
			System.out.println(minStack.pop().intValue());
			System.out.println(minStack.minStack().intValue());
		}
}

class MinStack {
	private Stack<Integer> stack_1 = new Stack<Integer>();  //用来正常的执行入栈和出栈操作
	private Stack<Integer> stack_2 = new Stack<Integer>();  //用来保存相应位置的最小值
	
	public void push(Integer node){
		Integer temp = null;
		if(stack_1.size() == 0){
			stack_1.push(node);
			stack_2.push(node);
		}
		else{
			temp = stack_1.peek();
			if(node.intValue() <= temp.intValue()){
				stack_1.push(node);
				stack_2.push(node);
			}
			else{
				stack_1.push(node);
			}
		}
	}
	
	public Integer pop(){
		if(stack_1.isEmpty()){
			System.out.println("stack is empty!");
			return null;
		}
		else{
			Integer temp2 = null;
			temp2 = stack_1.pop();
			if(temp2.intValue() == stack_2.peek().intValue()){
				stack_2.pop();
				return temp2;
			}
			else
				return temp2;
		}
	}
	
	public Integer minStack(){
		return stack_2.peek();
	}
}