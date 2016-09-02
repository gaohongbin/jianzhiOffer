package hehaitao;
/**
 * 题目：定义字符串的左旋转操作：把字符串前面的若干个字符移动到字符串的尾部。
 * 如把字符串abcdef左旋转2位得到字符串cdefab。请实现字符串左旋转的函数。
 * 要求时间对长度为n的字符串操作的复杂度为O(n)，辅助内存为O(1)。
 * @author hongbin.gao
 *
 */
public class LeftRotateString {
	public static void main(String[] args){
		char[] str = {'a','b','c','d','e','f','g','h'};
		int n = 2;
		leftRotateString(str,7);
		System.out.println(str);
	}
	
	public static void leftRotateString(char[] str, int n){  
		int length = str.length;
		if(n == length || n==0)
			return ;
		
		if(n < 0 || n>length){
			System.out.println("n is not right!");
			return ;
		}
		
		rotate(str,0,n-1);
		rotate(str,n,length-1);
		rotate(str,0,length-1);
	}
	
	public static void rotate(char[] str, int start, int end){
		int length = str.length;
		if(start < 0 || end > length-1 || start > end)
			System.out.println("start or end is not right!");

		if(start == end)
			return ;
		
		char temp; //交换字符时，作为临时变量。
		int mid = (start + end)/2;
		while(start <= mid){
			temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start ++;
			end --;
		}
		return ;
	}
}
 