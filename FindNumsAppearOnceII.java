package hehaitao;
/**
 * 题目：在一个int数组中，有两个数只出现了一次，其他的都出现了两次。找出这两个只出现一次的int
 * 时间复杂度O(n),空间复杂度为O(1)
 * 
 * @author hongbin.gao
 *
 */
public class FindNumsAppearOnceII {
	public static void main(String[] args){
		int[] nums={1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,9,8,9,34,67};
		int[] result = findNumsAppearOnceII(nums);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
	
	public static int[] findNumsAppearOnceII(int[] nums){
		int length = nums.length;
		int[] result = new int[2];
		//AxorB是两个只出现一次的数的异或结果
		int AxorB = nums[0];
		for(int i =1;i<length;i++){
			AxorB = AxorB ^ nums[i];
		}
		
		//找到AxorB中为1的最低位
		int lowBit = findLowBit(AxorB);
		
		//按照lowBit将数组分为两部分
		int nums1 =0,nums2 =0;
		for(int i=0;i<length;i++){
			if((lowBit&nums[i])!=0)
				nums1 = nums1^nums[i];
			else
				nums2 = nums2^nums[i];
		}
		result[0] = nums1;
		result[1] = nums2;
		return result;
		
	}
	public static int findLowBit(int params){
		int result =1;
		int index =0;
		while((result&params)==0 && index<32){
			result = result<<1;
			index++;
		}
		return result;
	}

}
