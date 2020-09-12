package algorithm;

import java.util.Scanner;

public class Main11726 {
	
	public static void main(String[] args) {//[i-1]+[i-2]¿« «’¿∫ i
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n= scan.nextInt();
		int[] arr = new int[n+2];
		arr[1]=1;
		arr[2]=2;
		for(int i=3;i<=n;i++) {
			arr[i]=(arr[i-1]+arr[i-2])%10007;
		}
		System.out.println(arr[n]);
	}
}

