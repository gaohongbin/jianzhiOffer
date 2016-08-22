/**
 * 题目：输入一个已经按升序排序过的数组和一个数字，在数组中查找两个数，使得它们的和正好是输入的那个数字N。
 * 要求时间复杂度是O(n)。
 * 如果有多对数字的和等于输入的数字，输出任意一对即可
 * @author ghb
 * 思路：因为原数组已经按升序排列，所以用两个指针，一个指针low指向最小的数，另一个指针high指向最大的数，如果两个数之和小于N，
 * 则：low++；如果之和大于N，high--。如果等于则直接输出。
 */

public class FindTwoNumbersWithSum {
	public static void main(String[] args){
		int[] nums = {1,2,4,7,11,15};
		int sum = 15;
		int[] result = findTwoNumbersWithSum_1(nums,sum);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
	public static int[] findTwoNumbersWithSum_1(int[] nums, int sum){
		if(nums == null || nums.length<2)
			return null;
		
		int[] result = new int[2];
		
		int length = nums.length;
		int low = 0;
		int high = length-1;
		while(low<high){
			if(nums[low]+nums[high] == sum){
				result[0] = nums[low];
				result[1] = nums[high];
				return result;
			}
			else if(nums[low] + nums[high] > sum){
				high--;
			}
			else
				low++;
		}
		return null;
	}

}

