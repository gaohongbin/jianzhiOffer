package hehaitao;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 题目：输入两个整数序列。其中一个序列表示栈的push顺序，判断另一个序列有没有可能是对应的pop顺序。
 * 为了简单起见，我们假设push序列的任意两个整数都是不相等的。
 * 
 * 比如输入的push序列是1、2、3、4、5，那么4、5、3、2、1就有可能是一个pop系列。
 * 因为可以有如下的push和pop序列：push 1，push 2，push 3，push 4，pop，push 5，pop，pop，pop，pop，这样得到的pop序列就是4、5、3、2、1。
 * 但序列4、3、5、1、2就不可能是push序列1、2、3、4、5的pop序列。
 * @author hongbin.gao
 * @param <T>
 *
 */

public class IsPossiblePopOrder<T> {
	public static void main(String[] args){
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1); 
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(5);
		list2.add(1);
		list2.add(3);
		list2.add(2);
		list2.add(4);
		
		boolean result = isPossiblePopOrder(list1,list2);
		System.out.println(result);
	}
	
	public static  boolean isPossiblePopOrder(List<Integer> list1, List<Integer> list2){
		Stack<Integer> stack1 = new Stack<Integer>();
		
		int length_1 = list1.size();
		int length_2 = list2.size();
		if(length_1 != length_2)  //如果两个链表长度不相等，直接返回false
			return false;
		
		int i = 0,j=0;
		int top;
		
		while(i<length_1){
			stack1.push(list1.get(i));
			top = stack1.peek().intValue();
			while(j<length_2 && top == list2.get(j).intValue() && !stack1.isEmpty()){
				stack1.pop();
				j++;
				if(!stack1.isEmpty()){
				    top = stack1.peek().intValue();
				}
			}
			i++;
		}
		
		if(stack1.isEmpty())
			return true;
		return false;
	}

}
