package algorithm;

import java.util.Scanner;

public class Main1546 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(),max=0;
		int[] arr = new int[n];
		for(int i = 0;i<n;i++) {
			int temp = scan.nextInt();
			arr[i]=temp;
			if(temp>max) {
				max=temp;
			}
		}
		double sum=0;
		for(int i=0;i<n;i++) {
			sum += (double)arr[i]/max*100;
		}
		System.out.println(Math.round(sum/n*100)/100.0);
	}

}
