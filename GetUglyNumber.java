package hehaitao;
/**
 * 题目：我们把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第1500个丑数。
 * @author hongbin.gao
 *
 */

public class GetUglyNumber {
	public static void main(String[] args){
		int n= 1500;
		int result = getUglyNumber_1(n);
		System.out.println(result);
	}
	
	public static int getUglyNumber_1(int number){
		if(number <= 5)   //如果number则直接返回结果。
			return number;
		
		int[] nums = new int[number];
		nums[0] = 1;
		nums[1] = 2;
		nums[2] = 3;
		nums[3] = 4;
		nums[4] = 5;
		
		int sum = 5; 
		int t2 = 2; //t2表示：nums[t2]是最小的大于nums[sum]的下标
		int t3 = 1; 
		int t5 = 2;
		int temp = 0;
		while(sum<number){
			temp = nums[t2]*2;  //在t2,t3,t5三个中选出一个得到nums[sum]的下标。
			if(temp > nums[t3]*3)
				temp = nums[t3]*3;
			if(temp > nums[t5] *5)
				temp = nums[t5]*5;
			
			nums[sum] = temp; //对nums[sum]进行修改
			
			while(nums[t2]*2 <= nums[sum])
				t2++;
			while(nums[t3]*3 <= nums[sum])
				t3++;
			while(nums[t5]*5 <= nums[sum])
			    t5++;
			
		    sum++;
		}
		return nums[number-1];
	}
}
