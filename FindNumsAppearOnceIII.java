package hehaitao;
/**
 * 题目：一个int数组，其中除了三个数字只出现一次外，剩余的数字都出现了两次，请找出这三个只出现一次的数字
 * 自己的思路：刚做完FindNumsAppearOnceII，就想到将int数组所有的元素都进行异或处理，是不是可以重复II的思路，但是细想发现即使
 * 三个不同的int，a、b、c进行异或，得到的结果XORresult可能为零。思路出现断层。
 * 何海涛的思路：同样先进行异或处理得到XORresult，虽然XORresult可能为零，但是XORresult再和a、b、c任何一个进行异或，结果也不会为零，
 * 这样XORresult^a,XORresult^b,XORresult^c即为三个不为零的数，如果分别取三个不为零的数的最后一位1为一个整数，这三个数进行异或，异或后的结果，
 * 找到最后一个不为0的位（三个这样的数异或结果肯定不为0），假如现在是m位为1，则f(XORresult^a),f(XORresult^b),f(XORresult^c)中只有一个满足m位为1.
 * 因为如果有三个m位都是1，那么XORresult的m位肯定为与abc的m位相反，即abc三个数的m位相同，如果abc三个数的位相同，且还要与XORresult的m位相反，假设abc三个数的m位均为0，则XORresult的m位为0，不合要求，如果abc三个数的m位均为1，则XORresult的m位为1，所以三个f()都为1的可能性不存在。
 * 所以只有f(XORresult^a),f(XORresult^b),f(XORresult^c)中只有一个满足m位为1.
 * 现在假设XORresult的m位为1，则abc中有两个数的m位为0，一个为1，这个可能。
 * 如果XORresult的m位为0，则abc中只能有一个m位为1，两个m位为0，这个不可能，因为abc中两个数m位为0，一个为1，则XORresult的m位一定为1，不会为0。
 * 所以通过这个可以找出abc里面唯一一个m位为1的数，剩下转化为FindNumsAppearOnceII。
 *
 */

public class FindNumsAppearOnceIII {
	public static int[] findNumsAppearOnceIII(int[] nums){
		int length = nums.length;
		if(length<3)
			return null;
		
		int[] result = new int[3];
		int XORresult = 0;  //nums数组异或
		for(int i=0;i<length;i++){
			XORresult ^= nums[i];
		}
		
		int flag = 0; //计算f(XORresult^a)^f(XORresult^b)^f(XORresult^c)
		for(int i=0;i<length;i++){
			flag ^= lastBitOfOne(XORresult ^ nums[i]);
		}
		
		flag = lastBitOfOne(flag);
		
		result[0] = 0;
		for(int i=0;i<length;i++){
			if(lastBitOfOne(XORresult^nums[i])==flag)
				result[0] ^= nums[i];
			   //循环完成后，flag为abc中的一个数。
		}
		
		
		int[] result2 = findNumsAppearOnceII(nums,result[0]);
		result[1] = result2[0];
		result[2] = result2[1];
		return result;
		
		
	}
	
	public static int lastBitOfOne(int n){  //找出n最后一位不为0的位
		if(n==0)
			return 0;
		int result =1;
		while((n&result)==0){
			result = result<<1;
		}
		
		return result;
	}
	
	public static int[] findNumsAppearOnceII(int[] nums,int a){
		int length = nums.length;
		int[] result = new int[2];
		//AxorB是两个只出现一次的数的异或结果
		int AxorB = 0;
		for(int i =0;i<length;i++){
			AxorB = AxorB ^ nums[i];
		}
		AxorB = AxorB ^ a;
		
		//找到AxorB中为1的最低位
		int lowBit = lastBitOfOne(AxorB);
		
		//按照lowBit将数组分为两部分
		int nums1 =0,nums2 =0;
		for(int i=0;i<length;i++){
			if((lowBit&nums[i])!=0)
				nums1 = nums1^nums[i];
			else
				nums2 = nums2^nums[i];
		}
		
		if((lowBit&a)!=0)
			nums1 = nums1^a;
		else
			nums2 = nums2^a;
		
		result[0] = nums1;
		result[1] = nums2;
		return result;
		
	}
	
	
	public static void main(String[] args){
		int[] nums = {1,1,2,3,4};
		int[] result = findNumsAppearOnceIII(nums);
	    for(int i=0;i<result.length;i++){
	    	System.out.println(result[i]);
	    }
	}
	

}
