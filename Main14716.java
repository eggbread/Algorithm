package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Main14716 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int n = scan.nextInt();
		int[][] arr = new int[m][n];
 		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				
				arr[i][j]=scan.nextInt();
			}
		}
 		int count=0;
 		boolean mod = false;
 		for(int i=0;i<n;i++) {
 			boolean check=false;
			for(int j=0;j<m;j++) {
				if(arr[j][i]==1) {
					check = true;
					mod = true;
					break;
				}
			}
			if(!check) {
				if(mod) {
					count++;
					mod=false;
				}
			}
		}
 		System.out.println(count);
	}
}
