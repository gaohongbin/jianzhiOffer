/**
 * 题目：在一个字符串中找到第一个只出现一次的字符。如输入abaccdeff，则输出b。
 * @author ghb
 * 思路：先用一个char数组，全部初始化为0，依次遍历字符串中的字符，因为char都是可以转化为int的，所以将char对应的nums[(int)char]++;
 * 这样一次遍历完成后，每个字符出现了几次就统计出来，再遍历字符串一次，如果nums[(int)char] ==1, 则该char只出现了一次，第一个这样的字符就是我们要
 * 找的结果。
 *
 */

public class FirstNotRepeatingChar {
	public static void main(String[] args){
		String str = "abaccdeff";
		char result = firstNotRepeatingChar_1(str);
		System.out.println(result);
	}
	
	public static char firstNotRepeatingChar_1(String str){
		int length = str.length();
		int[] nums = new int[65536];
		int i=0;
		for(i =0;i<65536;i++)
			nums[i]=0;
		
		for(i=0;i<length;i++){
			nums[(int)str.charAt(i)] ++;
		}
		
		for(i=0;i<length;i++){
			if(nums[(int)str.charAt(i)]==1)
				return str.charAt(i);
		}
		return str.charAt(i);
	}

}

