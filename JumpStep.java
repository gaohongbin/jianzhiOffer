package hehaitao;
/**
 * 题目：一个台阶总共有n级，如果一次可以跳1级，也可以跳2级。求总共有多少总跳法，并分析算法的时间复杂度。
 * @author hongbin.gao
 *
 */

public class JumpStep {
   public static void main(String[] args){
	   int n = 20;
	   long result= jumpStep_1(n);
	   System.out.println(result);
   }
   /**
    * 方法一：递归
    * @param n
    * @return
    */
   public static long jumpStep_1(int n){
	   if(n == 1)
		   return 1;
	   if(n == 2)
		   return 2;
	   
	   return jumpStep_1(n-1) + jumpStep_1(n-2);
   }
   
   /**
    * 方法二：两个变量：一个用来保存jumpStep(1),另一个用来保存jumpStep(2)这样一直循环，循环到jumpStep(n-1)
    * 和jumpStep(n-2),最后返回结果。
    */
   public static long jumpStep_2(int n){
	   int num_1 = 1;
	   long n_1 = 1;
	   int num_2 = 2;
	   long n_2 = 2;
	   
	   int num =3;
	   if((n&1) == 1){  //n为奇数
		   while(num_1 != n-2 || num_2 != n-1){
			   if((num&1) == 1){
				   num_1 = num;
				   n_1 = n_1 + n_2;
			   }
			   else if((num&1) == 0){
				   num_2 = num;
				   n_2 = n_1 + n_2; 
			   }
			   num++;
		   }
	   }
	   else if((n&1) == 0){  //n为偶数
		   while(num_1 != n-1 || num_2 != n-2){
			   if((num&1) == 1){
				   num_1 = num;
				   n_1 = n_1 + n_2;
			   }
			   else if((num&1) == 0){
				   num_2 = num;
				   n_2 = n_1 + n_2; 
			   }
			   num++;
		   }
	   }
	   
	   return n_1 + n_2;
   }
   /**
    * 方法三：动态规划，用一个long[n]的数组来保存从1-n步台阶各多少种情况。
    * @param n
    * @return
    */
   public static long jumpStep_3(int n){
	   long[] result = new long[n+1];
	   result[0] = 0;
	   result[1] = 1;
	   result[2] = 2;
	   for(int i=3;i<=n;i++){
		   result[i] = result[i-1]+result[i-2];
	   }
	   return result[n];
   }
}
 