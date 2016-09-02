package hehaitao;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：顺时针打印矩阵
 * 例如：如果输入如下矩阵：
 * 1、     2、    3、   4、
 * 5、     6、   7、    8、
 * 9、    10、 11、 12、
 * 13、 14、 15、 16、
 * 则依次打印出数字1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10。
 * @author hongbin.gao
 *
 */

public class PrintMatrixClockwisely {
	public static void main(String[] args){
		int rows = 4, columns = 4;
		int[][] nums = new int[rows][columns];
		
		for(int i=0;i<rows;i++){
			for(int j=0;j<columns;j++){
				nums[i][j] = rows*i+j+1;
			}
		}
		List<Integer> list = printMatrixClockwisely(nums);
		for(int i=0; i<list.size();i++){
			System.out.print(list.get(i));
			System.out.print(",");
		}
	}
	
	public static List<Integer> printMatrixClockwisely(int[][] matrix){
		List<Integer> list = new ArrayList<Integer>();
		if(matrix == null)
			return list;
		
		int rows = matrix.length;
		if(rows<1) 
			return list;
		int columns = matrix[0].length;
		
		int r =0, c=0;  //r表示已经遍历的横向的数量。 c表示已经遍历的纵向的数量。
		
		while(r<rows && c<columns){  //当行没有打完或者列没有打完，就不退出循环
			//整个过程一直遵循先打行、再打列的循环。
			//r为偶数时，是从左到右打印一行，r为奇数时，从右往左打印一行，而且r的值还决定打印每一行的起始和结束的下标。
			if((r&1) == 0){
			   for(int i = r/2;i<columns-r/2;i++){
				    list.add(matrix[r/2][i]);
			   }
			}
			else if((r&1)==1){
				for(int i = columns-r/2-2;i>=0+r/2;i--){
					list.add(matrix[rows-1-r/2][i]);
				}
			}
			r++;
			
			//c为偶数时，右边的列从上往下打印；c为奇数时，左边的列从下往上打印
			if((c&1)==0){
				for(int i= (r+1)/2; i<=rows-1-r/2;i++){
					list.add(matrix[i][columns-1-c/2]);
				}
			}
			else if((c&1)==1){
				for(int i= rows -(r+1)/2-1;i>=(r+1)/2;i--){
					list.add(matrix[i][c/2]);
				}
			}
			c++;
		}
		return list;
	}

}
 