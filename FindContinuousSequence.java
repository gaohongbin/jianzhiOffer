package hehaitao;
/**
 * 题目：输入一个正数n，输出所有和为n连续正数序列。
 * 例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以输出3个连续序列1-5、4-6和7-8。
 * @author hongbin.gao
 *
 */

public class FindContinuousSequence {
	public static void main(String[] args){
		int n = 15;
		findContinuousSequence_1(900);
	}
	
	public static void findContinuousSequence_1(int n){
		if(n<3)
			return ;
		int mid = n/2;
		int small = 1;
		int big = 2;
		
		int sum = 3;
		
		while(small <= mid){
			if(sum<n){
				big++;
				sum += big;
			}
			if(sum > n){
				sum -= small;
				small++;
			}
			if(sum == n){
				for(int i = small ;i<=big;i++){
					if(i != big){
					  System.out.print(i+"-");
					}
					else{
						System.out.println(i);
					}
				}
				sum -= small;
				small++;
			}
			
		}
		return ;
	}
}
