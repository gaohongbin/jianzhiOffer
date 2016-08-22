/**
 * 题目：输入一个整数数组，判断该数组是不是某二元查找树的后序遍历的结果。如果是返回true，否则返回false。
 * @author ghb
 * 
 *        8
 *      /   \
 *     6     10
 *    / \    / \
 *   5   7  9   11
 *   思路：后续遍历满足最后一个值恰好将数组分为两部分，前半部分小于最后的值，后半部分大于最后的值。
 *
 */

public class VerifySquenceOfBST {
	public static void main(String[] args){
		
		int[] nums = {5,7,6,9,11,10,8};
		int length = nums.length;
		
		boolean result = verifySquenceOfBST(nums,0,length-1);
		System.out.println(result);
	}
	
	public static boolean verifySquenceOfBST(int[] nums,int low, int high){
		if(nums == null)
			return true;
		
		int length = nums.length;
		if(length<=1)
			return true;
		
		int left  = 0;
		int right = 0;
		for(int i = 0;i<length-1;i++){
			if(nums[i]<nums[length-1])
				left++;
		}
		
		for(int i= left-1;i<length-1;i++){
			if(nums[i]<nums[length-1])
				return false;
		}
		
		if(verifySquenceOfBST(nums,low,left-1) && verifySquenceOfBST(nums,left,length-2))
			return true;
		return false;
	}

}

