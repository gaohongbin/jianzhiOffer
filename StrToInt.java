package hehaitao;
/**
 * 题目：输入一个表示整数的字符串，把该字符串转换成整数并输出。例如输入字符串"345"，则输出整数345。
 * @author hongbin.gao
 * 思路：含有字母不行、超过int最大值不行。
 *
 */
public class StrToInt {
	public static void main(String[] args){
		String str = "-00123309";
		long result = strToInt(str);
		System.out.println(result);
	}
	
	public static int strToInt(String str){
		if(str == null){
			System.out.println("str is not int!");
			return 0;
		}
			
		int length = str.length();
		int low = 0;  //如果字符串的前面几个字符为0，例如：000123，则low=3，表示1所在的位置
		int result = 0; //result为要返回的结果
		
		if(length == 0){ //如果字符串的长度为0
			System.out.println("str is not int!");
			return 0;
		}
		
		while(low<length){
			if(low == 0 && (str.charAt(0)=='-' || str.charAt(0)=='+' || str.charAt(0)=='0'))
			    low++;
			else if(low !=0 && str.charAt(low) == '0')
				low++;
			else
				break;
		}
		
		boolean flag = true;  //flag为true表示为正数，false表示负数
		while(length>low && str.charAt(low)>='0' && str.charAt(low) <='9'){
			result = result*10 + str.charAt(low)-'0';
			if(result > Integer.MAX_VALUE){
				System.out.println("str not is int!");
				return 0;
			}
			low++;
		}
		
		if(length==low && str.charAt(0) == '-')
			return 0-result;
		if(length==low && str.charAt(0) == '+')
			return result;
		else{
			System.out.println("str is not int!");
			return 0;
		}
	}
}
