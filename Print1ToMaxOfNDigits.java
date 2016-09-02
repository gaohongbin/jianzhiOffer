package hehaitao;
/**
 * 题目：输入数字n，按顺序输出从1最大的n位10进制数。比如输入3，则输出1、2、3一直到最大的3位数即999。
 * @author hongbin.gao
 *
 */

public class Print1ToMaxOfNDigits {
	public static void main(String[] args){
		int n = 5;
		char[] c = new char[n];
		int i = 0;
		while(i<c.length){
			c[i] = '0';
			i++;
		}
		//System.out.println(c);
		print1ToMaxOfNDigits(c,n);
	}
	
	public static void print1ToMaxOfNDigits(char[] c, int length){ //length表示这道题目的n
		int i = c.length - length;
		boolean flag = false;
		int j=i;
		while(j<c.length && !flag){  //判断应该结束递归
			if(c[j]!='9')
				flag = true;
			j++;
		}
		
		if(!flag)     
			return ;
		
		j=c.length-1;
		int temp =0;
		int index = 1;
		while(j>=i && index !=0){
			temp = (c[j]+index-'0')/10;
			c[j] = (char) ((c[j]+index-'0')%10+'0');
			index = temp;
			j--;
		}
		while(i<c.length && c[i]=='0')  //找到不等于0的c的起始位置
			i++;
		
		while(i<c.length){  //循环输出结果
			System.out.print(c[i]);
			i++;
		}
		System.out.println();
		
		print1ToMaxOfNDigits(c,length);
		return ;
	}

}
 