package algorithm;

import java.util.Scanner;

public class Main9095 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();//반복 횟수
		int[] arr = new int[12];
		arr[1]=1;
		arr[2]=1;
		arr[3]=2;
		for(int j=0;j<c;j++) {			
			int n = scan.nextInt();//입력
			if(n==1) {
				System.out.println(1);
			}else {
				
			for(int i=4;i<=n;i++) {
				arr[i]=arr[i-1]+arr[i-2]+arr[i-3];//전,전전,전전전 더해서 저장
			}
			System.out.println(arr[n]+arr[n-1]+arr[n-2]);//전,전전,현재 더해서 출력
			}
		}
	}

}
