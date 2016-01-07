
package MathWorks;
import java.util.Arrays;
import java.util.Scanner;

public class MagicSquare {

	public static void main(String args[]) {
		
		//Scanner scan = new Scanner(System.in);

		/*
		* You can enter any nxn matrix below line to check if it is a magic square or not.
		*/
		int[][] matrix = { { 16, 3, 2, 13 }, { 5, 10, 11, 8 }, { 9, 6, 7,12 },
				{ 4, 15, 14, 1 } };

		int rowSum = 0, colSum=0;
		boolean check = false, verify = false;
		int diagSumX = 0, diagSumY=0;
		int len = matrix.length;
		int[] rowSumUp = new int[len];
		int[] colSumUp = new int[len];

		for (int row = 0; row < matrix.length; row++) {
			rowSum = 0;
			for (int column = 0; column < matrix[0].length; column++) {
				rowSum += matrix[row][column];
				rowSumUp[row] = rowSum;
			}
		}
		for (int column = 0; column < matrix[0].length; column++) {
			colSum = 0;
			for (int row = 0; row < matrix.length; row++) {
				colSum += matrix[row][column];
				colSumUp[column] = colSum;
			}
		}
		for (int a = 0, j=0; a < len && j <len; a++, j++) {
			diagSumX += matrix[a][j];
			diagSumY += matrix[a][len-1-j];
			if (diagSumX == diagSumY)
				check = true;
		}
		
		System.out.println(Arrays.toString(rowSumUp));
		System.out.println(Arrays.toString(colSumUp));
		
		if (checkSum(rowSumUp) && checkSum(colSumUp))
			if (rowSumUp[0] != colSumUp[0]) verify = false;
				else verify = true;
		
		System.out.println("It's" +((check && verify) ? "" : " not") + " a Magic Square!");		
	}
	
	public static boolean checkSum(int[] rowSumUp) {

		for (int j = 0, k = rowSumUp.length - 1; j < rowSumUp.length && k >= 0; j++, k--) {
			if (rowSumUp[j] != rowSumUp[k])
				return false;
		}
		return true;
	}
}
