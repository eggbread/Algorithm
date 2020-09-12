package algorithm;

import java.util.Scanner;

public class Main1992 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[][]=new int[n][n];
		scan.nextLine();
		for(int i=0;i<n;i++) {
			String temp = scan.nextLine();
			for(int j=0;j<n;j++) {
				arr[i][j]=Character.getNumericValue(temp.charAt(j));
			}
		}

		zip(arr,0,arr.length,0,arr.length);
	}
	public static void zip(int[][] arr,int Left,int RT,int LB,int RB) {
		int sum=0;
		
		for(int i=Left;i<RT;i++) {
			for(int j=LB;j<RB;j++) {
				sum+=arr[i][j];
			}
		}
		if(sum==0) {
			
			System.out.print(0);
			return;
		}else if(sum==(RT-Left)*(RB-LB)){
			
			System.out.print(1);
			return;
		}else {
			System.out.print("(");
			if(RT-Left==2||RB-LB==2) {
				for(int i=Left;i<RT;i++) {
					for(int j=LB;j<RB;j++) {
						System.out.print(arr[i][j]);
					}
				}
				System.out.print(")");
				return;
			}
			zip(arr,Left,(Left+RT)/2,LB,(LB+RB)/2);
			zip(arr,Left,(Left+RT)/2,(LB+RB)/2,RB);
			zip(arr,(Left+RT)/2,RT,LB,(LB+RB)/2);
			zip(arr,(Left+RT)/2,RT,(LB+RB)/2,RB);
			System.out.print(")");
		}
	}
}
