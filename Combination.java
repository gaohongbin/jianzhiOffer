package hehaitao;

import java.util.Vector;

/**
 * 题目：输出字符串的所有组合，本题的例子是abcd。
 * @author hongbin.gao
 *
 */
public class Combination {
	public static void main(String[] args){
		String str = "abcd";
		int length = str.length();
		Vector<Character> vec = new Vector<Character>();
		for(int i=1;i<=length;i++){
			combination(str.toCharArray(),0,length-1,i,vec);
		}
	}
	
	public static void combination(char[] c, int low, int high, int length,Vector<Character> vec){
		if(c==null) //如果字符数组为空
			return ;
		
		if(length==0){
			for(int i=0;i<vec.size();i++)
			       System.out.print(vec.elementAt(i));
			System.out.println();
			return ;
		}
		
		if(low>high || (high-low+1)<length)  //当出现不可能的情况时及时停止
			return ;
		
		else{
			combination(c,low+1,high,length,vec); //low位置的字符不算
			
			vec.add(c[low]);//将low位置的字符加入
			combination(c,low+1,high,length-1,vec);
			vec.remove(vec.size()-1);
		}
	}
}
