package algorithm;

import java.util.Scanner;

public class Main10818 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		arr[0] = scan.nextInt();
		int min=arr[0];
		int max=arr[0];
		for(int i=1;i<n;i++) {
			int temp=scan.nextInt();
			arr[i]=temp;
			if(temp<min) {
				min=temp;
			}
			if(temp>max) {
				max=temp;
			}
		}
		System.out.println(min + " " + max);
	}

}
