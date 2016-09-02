package hehaitao;
/**
 * 在数组中，数字减去它右边的数字得到一个数对之差。求所有数对之差的最大值。例如在数组{2, 4, 1, 16, 7, 5, 11, 9}中，数对之差的最大值是11，是16减去5的结果。
 * 方法一：分治算法
 * 方法二：将最大差转化为求最大序列和
 * 方法三：动态规划算法
 * 
 *
 */

public class MaxDiff_Solution {
  public static void main(String[] args){
	  int[] nums = {2, 4, 1, 16, 7, 5, 11, 9};
	  int result = maxDiffIII(nums);
	  System.out.println(result);
  }
  
  public static int maxDiffI(int[] nums,int low,int high){  //分治算法
	  if(low>high)
		  return 0;
	  
	  if(low+1==high)
		  return nums[low]-nums[high];
	  
	  int mid = (low+high)/2;
	  
	  int left = maxDiffI(nums,low,mid);
	  int right = maxDiffI(nums,mid+1,high);
	  
	  int maxLeft = nums[low];
	  int minRight = nums[mid+1];
	  for(int i=low;i<=mid;i++)
		  if(nums[i]>maxLeft)
			  maxLeft = nums[i];
	  for(int i=mid+1;i<=high;i++)
		  if(nums[i]<minRight)
			  minRight = nums[i];
	  
	  int result = left;
	  if(right>result)
		  result = right;
	  if(maxLeft - minRight>result)
		  result = maxLeft -minRight;
	  return result;
		  
  }
  
  public static int maxDiffII(int[] nums){
	  int length = nums.length;
	  if(length==2)
		  return nums[0]-nums[1];
	  
	  int[] diff = new int[length-1]; //diff用来保存相邻nums的差
	  /*for(int i=length-1;i>0;i--){
		  diff[i-1]=nums[i-1]-nums[i];
	  }*/
	  for(int i=0;i<length-1;i++){
		  diff[i]=nums[i+1]-nums[i];
	  }
	  
	  int result =Integer.MIN_VALUE;
	  int temp=0;
	  for(int i =0;i<diff.length;i++){
		  temp += diff[i];
		  if(temp > result)
			  result = temp;
		  if(temp < 0)
			  temp = 0;
	  }
	  return result;
  }
  
  /**
   * maxDiffIII为动态规划算法，时间复杂度为O(n),空间复杂度为O(1),所以是最推荐的算法。
   * @param nums
   * @return
   */
  public static int maxDiffIII(int[] nums){
	  if(nums == null)
		  return 0;
	  
	  int length = nums.length;
	  if(length<2)
		  return 0;
	  
	  int max = nums[0];  //用来保存之前出现的最大值
	  int maxDif = nums[0]-nums[1]; //用来保存目前出现的最大差
	  
	  for(int i=2;i<length;i++){
		  if(max<nums[i-1])
			  max = nums[i-1];
		  
		  if(max-nums[i]>maxDif)
			  maxDif = max-nums[i];
	  }
	  return maxDif;
	  
  }
}
