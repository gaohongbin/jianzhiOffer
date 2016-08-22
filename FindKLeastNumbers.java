/**
 * 题目：输入n个整数，输出其中最小的k个。
 * 例如输入1，2，3，4，5，6，7和8这8个数字，则最小的4个数字为1，2，3和4。
 * @author ghb
 * 思路：设定一个int数组result，大小为K,先将nums数组中的前k个数放入result中，在result数组放满后，每次从nums中取出一个数和
 * result的最大值进行比较，如果大于等于最大值，则从nums中再取出一个；如果小于result的最大值，则和最大值交换，重新计算result
 * 的最大值，直到nums遍历一遍，则result中保存的就是最小的k个数。
 *
 */
public class FindKLeastNumbers {
	public static void main(String[] args){
		int[] nums = {2,3,4,6,7,8,9,7,6,5,4,33,2,3,4,5,6,7,66745,45,3,433,2};
		int k = 5;
		int[] result = findKLeastNumbers_1(nums,9);
		for(int i =0;i<result.length;i++)
			System.out.println(result[i]);
	}
	
	public static int[] findKLeastNumbers_1(int[] nums,int k){
		if(nums == null)
			return null;
		
		int length = nums.length;
		if(length <=k)
			return nums;
		
		int[] result = new int[k];
		
		int max = nums[0];
		int index = 0;
		for(int i=0;i<k;i++)  //先把nums前k个元素放进result里面。
			result[i] = nums[i];
		
		for(int i=0;i<k;i++){  //找到result最大的数
			if(result[i] > max){
				max = result[i];
				index = i;
			}
		}
		
		for(int i=k;i<length;i++){
			if(nums[i] < max){
				result[index] = nums[i];
		        max = result[0];
		        index = 0;
		        for(int j = 0;j<k;j++){
		        	if(result[j] > max){
		        		max = result[j];
		        		index = j;
		        	}
		        }
			}
		}
		return result;
	}
}

