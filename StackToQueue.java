package hehaitao;

import java.util.Stack;

/**
 * 题目：用两个栈实现队列
 * @author hongbin.gao
 *
 */
public class StackToQueue{
	public static void main(String[] args){
		Cqueue<Integer> queue = new Cqueue<Integer>();
		queue.appendTail(1);
		queue.appendTail(2);
		queue.deleteHead();
		queue.appendTail(3);
		
		System.out.println(queue.deleteHead());
		System.out.println(queue.deleteHead());
	}
}
class Cqueue<T> {
	private Stack<T> stack_1 = new Stack<T>();  //用来实现从尾部加入一个元素
	private Stack<T> stack_2 = new Stack<T>();  //用来实现从头部取出一个元素
	
	public void appendTail(T node){ // append a element to tail
		T temp = null;
		while(!stack_2.isEmpty()){
			temp =  stack_2.pop();
			stack_1.push((T) temp);
		}
		stack_1.push(node);
	}
	
	public T deleteHead(){
		T temp = null;
		while(!stack_1.isEmpty()){  //如果stack_1不为空，则将元素先全部放在stack_2里面
			temp = (T) stack_1.pop();
			stack_2.push(temp);
		}
		return stack_2.pop();
	}
}
