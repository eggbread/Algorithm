package algorithm;

import java.util.Scanner;

public class Main4344 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		for(int i=0;i<n;i++) {
			int m = scan.nextInt();
			int[] arr = new int[m];
			double sum=0;
			for(int j=0;j<m;j++) {
				arr[j]=scan.nextInt();
				sum+=arr[j];
			}
			double count=0;
			sum = sum/m;
			for(int j=0;j<m;j++) {
				if(arr[j]>sum)
					count++;
			}
			System.out.println(String.format("%.3f", count/m*100)+"%");
		}
	}

}
