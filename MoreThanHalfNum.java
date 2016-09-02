package hehaitao;
/**
 * 题目：数组中有一个数字出现的次数超过了数组长度的一半，找出这个数字。
 * 思路：假设我们要找的这个数字为a,既然这个数字出现的次数超过了数组长度的一半，则其出现的次数超过了其他所有数字出现的次数之和。
 * 所以，如果随便拿一个数字a和另外一个数字抵消掉，最终数组中留下来的数字肯定是a,如果不是a和另外一个数字相抵消，那么最后留下来的更是a了。
 * 有了这样的思路，我们可以变成，先设定一个数字num = nums[0], count =1 开始扫描数字，当遇到一个数字和num相等，则count++。
 * 不相等，则count--，当count==0时，重新设定num为下一个新数字，count为1。直到nums跑一遍，则num即为要求的结果。
 * @author hongbin.gao
 *
 */
public class MoreThanHalfNum {
	public static void main(String[] args){
		int[] nums = {1,1,1,1,1,1,2,3,4,5,6,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9};
		Integer result  = moreThanHalfNum(nums);
		if(result == null)
			System.out.println("数组不符合要求");
		System.out.println(result);
	}
	
	public static Integer moreThanHalfNum(int[] nums){
		if(nums == null || nums.length ==0)
			return null;
		
		int num = nums[0];
		int count = 1;
		for(int i =1;i<nums.length;i++){
			if(count == 0){
				num = nums[i];
				count ++;
			}
			else if(num == nums[i]){
				count ++;
			}
			else{
				count --;
			}
		}
		return new Integer(num);
	}
}
