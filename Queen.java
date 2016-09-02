package hehaitao;
/**
 * 题目：八皇后问题，在8×8的国际象棋上摆放八个皇后，使其不能相互攻击，即任意两个皇后不得处在同一行、同一列或者同一对角斜线上。
 * 下图中的每个黑色格子表示一个皇后，这就是一种符合条件的摆放方法。请求出总共有多少种摆法。
 * @author hongbin.gao
 * 
 * 思路：因为任意两个皇后不得处在同一行，同一列，所以八个皇后位于不同的行，不同的列。用一个长度为8的一维数组a，就可以表示一种情况，
 * 例如a[3]=4表示第三列的皇后在第四行。这样一个数组就是一种情况。
 * 
 * 因为任意两个皇后不能处于同一行、同一列，所以初始化时一维数组初始化为0-7，然后找出所有排列，然后对每种排列进行检查即可。
 */

class Count{  //用来统计一共有多少可能
	int sum=0;
	public Count(int sum){
		this.sum = sum;
	}
	public void setSum(int sum){
		this.sum = sum;
	}
	public int getSum(){
		return this.sum;
	}
}

public class Queen {
	public static void main(String[] args){
        int[] nums = {0,1,2,3,4,5,6,7};
        Count count = new Count(0);  
        int result = queen(nums,0,7,count);
        System.out.println(result);
	}
	
	public static int queen(int[] nums, int low,int high,Count count){
		
		if(low == high){
			if(check(nums)){ //如果检查通过，修改总数
				for(int i=0;i<nums.length;i++)
					System.out.print(nums[i]);
				System.out.println("("+count.getSum()+")");
				
				int sum = count.getSum();
				count.setSum(sum+1);
			}
		}
		
		for(int i=low;i<=high;i++){
			swap(nums,low,i);
			queen(nums,low+1,high,count);
			swap(nums,low,i);
		}
		
		return count.getSum();
		
	}
	
	public static boolean check(int[] nums){ //检查是否满足要求
		int length = nums.length;
		for(int i=0;i<length-1;i++)
			for(int j= i+1;j<length;j++){
				if(j-i == Math.abs(nums[j]-nums[i]))
					return false;
			}
		
		return true;
	}
	
	public static void swap(int[] nums,int i,int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}

