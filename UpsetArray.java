package learn;

/**
 * 题目：给定一共数组，设计一个即高效又公平的方法，随机打乱这个数组。
 * @author ghb
 * 
 * 思路：随机生成一个(0--length-1)的数，用这个然后将选中的数和末尾的数进行交换，然后第二次生成一个0--length-2的随机数，将选中的数放到
 * 数组的末尾第二个，依次进行，遍历完一遍，就可以打乱数组。
 * 
 *
 */
public class UpsetArray {
	public static void main(String[] args){
		int[] nums = {1,2,3,4,5,6,7,8,9,10,11};
		upsetArray(nums);
		
		for(int i=0;i<nums.length;i++)
		    System.out.println(nums[i]);
	}
	
	public static void upsetArray(int[] nums){
		int length = nums.length;
		int i = length-1;
		int temp;
		int j;
		while(i>0){
			temp = nums[i];
			j= (int)(Math.random()*(i+1));
			nums[i] = nums[j];
			nums[j] = temp;
			i--;
		}
	}
}
