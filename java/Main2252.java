package algorithm;

import java.util.Scanner;

public class Main2252 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[] arr =new int[n];
		arr[0]=scan.nextInt();
		arr[1]=scan.nextInt();

		for (int i = 0; i < m - 1; i++) {
			int found = -1;
			int first = scan.nextInt();
			int second = scan.nextInt();
			for (int j = 0; j < n; j++) {
				if (arr[j] == first||arr[j] == second) {
					
				}
			}
		}
	}

}
