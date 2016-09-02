package hehaitao;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目：输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。
 * 例如，输入”They are students.”和”aeiou”，则删除之后的第一个字符串变成”Thy r stdnts.”。
 * @author hongbin.gao
 *
 */

public class DeleteChars {
	public static void main(String[] args){
		String str1 = "They are students.";
		String str2 = "aeiou";
		String result = deleteChars_1(str1,str2);
		System.out.println(result);
	}
  
	public static String deleteChars_1(String str1,String str2){
		int length_1 = str1.length();
		int length_2 = str2.length();
		
		Set<Character> set = new HashSet<Character>();
		int i=0;
		while(i<length_2){
			set.add(str2.charAt(i));
			i++;
		}
		
		StringBuffer strBuf = new StringBuffer();
		
		i=0;
		int index = 0; //index保存到目前为止str1中一共有几个字符是在str2中的
		while(i<length_1){
			if(!set.contains(str1.charAt(i))){
				strBuf.append(str1.charAt(i));
			}
			i++;
		}
		return strBuf.toString();
	}
}
