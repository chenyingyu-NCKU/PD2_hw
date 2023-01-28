package ptrian;
import java.util.Scanner;

public class PascalTriangle {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		int hight = keyboard.nextInt();
		int wide = hight+1;
		
		long[][] triangle = new long[hight][wide];
		triangle[0][0] = 1;
		triangle[1][0] = 1; triangle[1][1] = 2; triangle[1][2] = 1;
		
		for(int i = 2; i < hight; i++) {
			triangle[i][0] = 1;
			for(int j = 1; j < i+1; j++) {
				triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
			}
			triangle[i][i+1] = 1;
		}
		for(int i = 0; i < wide; i++) {
			System.out.printf(triangle[hight-1][i] + " ");
		}

	}

}
