package algorithm;

import java.util.Scanner;
public class Main16507 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int R=scan.nextInt(),C=scan.nextInt(),Q=scan.nextInt();
		int[][] arr = new int[R+1][C+1];
		for(int i = 1;i<=R;i++) 
			for(int j=1;j<=C;j++) 
				arr[i][j] = scan.nextInt()+arr[i-1][j]+arr[i][j-1]-arr[i-1][j-1];
		for(int i=0;i<Q;i++) {
			int r1 = scan.nextInt(),c1 = scan.nextInt(),r2 = scan.nextInt(),c2 = scan.nextInt();
			System.out.println((arr[r2][c2]-arr[r2][c1-1]-arr[r1-1][c2]+arr[r1-1][c1-1])/((r2-r1+1)*(c2-c1+1)));
		}
	}
}
