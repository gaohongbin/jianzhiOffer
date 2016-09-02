package hehaitao;
/**
 * 题目描述：一个数组中，出了一个数字外，其他数字都出现了两次，请找出只出现一次的数字
 * @author hongbin.gao
 *
 */

public class FindNumsAppearOnceI {
	public static int findNumsAppearOnce(int[] nums){
		int length = nums.length;
		
		int result = 0;
		for(int i=0;i<length;i++){
			result = result^nums[i];
		}
		return result;
		
	}
	public static void main(String[] args){
		int[] nums = {10};
		int result = findNumsAppearOnce(nums);
		System.out.println(result);
	}

}
