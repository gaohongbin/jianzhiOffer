package hehaitao;
/**
 * 题目：输入一个正整数数组，将它们连接起来排成一个数，输出能排出的所有数字中最小的一个。
 * @author hongbin.gao
 *
 */

public class PrintMinNumber {
	public static void main(String[] args){
		int[] nums = {945,8,7,631,6325,4,3,2,1};
		printMinNumber(nums,0,nums.length-1);
		for(int i = 0;i<nums.length;i++)
		   System.out.println(nums[i]);
	}
	public static void printMinNumber(int[] nums,int low, int high){
		if(high == low || high == low+1)
			return ;
		
		int temp =0;
		
		for(int j = low;j<high;j++){
			int p1 = nums[j];
			int index = j;
			for(int i=j+1;i<=high;i++){
				if(!compareString(p1,nums[i])){
					p1 = nums[i];
					index = i;
				}
			}
			temp = nums[j];
			nums[j] = p1;
			nums[index] = temp;
		}
	}
	public static boolean compareString(int p1, int p2){
		String str1 = new String(p1+""+p2+"");
		String str2 = new String(p2+""+p1+"");
		
		int length = str1.length(); //str1和str2的长度时相同的
		
		int i=0;
		char c1,c2;
		while(i<length){
			c1 = str1.charAt(i);
			c2 = str2.charAt(i);
			if(c1 < c2)  //p1<p2
				return true;
			else if(c1 > c2) //p1>p2
				return false;
			
			i++;
		}
		
		return true;  //如果两个数字例如为321321和321则返回true
	}

}
