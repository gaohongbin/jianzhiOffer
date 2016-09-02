package learn;
/**
 * 题目：扑克牌，0表示大小王，大小王可以随便顶替，2-10为正常的数字，A用1表示，JQK分别表示11,12,13.
 * 现在给定一个数组，数组中有5个数，看这五个数能否组成连续的序列，0可以随便顶替。
 * 
 * 思路：先将数组排序，计算0的个数zeroNumber，再找出数组中除0以外的最小的数min，和最大的数max，
 * 如果有重复的数字，那肯定返回false，除0以外没有重复的数字，并且max-min+1 == 5 或者max-min+1+zeroNumber ==5，则一定可以组成
 * 顺子。
 */
import java.util.Arrays;

public class IsContinuous {
	public static void main(String[] args){
		int[] nums = {0,0,3,3,7};
		System.out.println(isContinuous(nums));
	}
	
	
	
	public static boolean isContinuous(int[] number){
		if(number == null || number.length <5)
			return false;
		
		Arrays.sort(number); //先进行排序
		int zeroNumber = 0;
		int min = -1;
		int max = number[number.length-1];
		for(int i=0;i<number.length;i++){
			if(number[i] == 0)
				zeroNumber++;
			else if(min == -1 && number[i]!=0)
				min = number[i];
			
			if(i<number.length-1 && number[i]!=0 && number[i]==number[i+1])
				return false;
		}
		if(max-min+1 == 5 || max-min+1+zeroNumber == 5)
			return true;
		return false;
	}
	
	

}
 