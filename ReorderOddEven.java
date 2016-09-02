package hehaitao;
/**
 * 题目：输入一个整数数组，调整数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。要求时间复杂度为O(n)。
 * @author hongbin.gao
 *
 */

public class ReorderOddEven {
public static void main(String[] args){
	   int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
	   reorderOddEven(nums);
	   int i=0;
	   while(i<nums.length){
		   System.out.println(nums[i]);
	       i++;
	   }
   }

   public static void reorderOddEven(int[] nums){
	   if(nums == null || nums.length<=1)
		   return ;
	   
	   int low = 0;
	   int high = nums.length-1;
	   int temp;
	   
	   int flag = nums[0];
	   while(low<high){
		   while(high>low && isEven(nums[high]))
			   high--;
		   
		   while(high>low && !isEven(nums[low])) 
			   low++;
		   
		   temp = nums[low];
		   nums[low] = nums[high];
		   nums[high] = temp;
	   }
   }
   
   public static boolean isEven(int number){
	   return (number&1)==0;
   }
}
