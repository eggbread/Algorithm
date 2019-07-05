package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class MainA {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		int m=scan.nextInt();
		int[][] array = new int[n][m];
		for(int i=0;i<m;i++) {
			Arrays.asList(scan.nextLine()).stream().mapToInt(Integer::parseInt).toArray();
		}
		
	}
}
