package algorithm;

import java.util.Scanner;

public class Main2579 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		int[] arr = new int[n+1];
		int[] result = new int[n+1];
		boolean found=false;
		for(int i=1;i<=n;i++) {
			arr[i]=scan.nextInt();
		}
		result[1]=arr[1];//첫번째
		result[2]=Math.max(arr[1]+arr[2], arr[2]);//첫째둘째,둘째 큰거
		result[3]=Math.max(arr[2]+arr[3], arr[1]+arr[3]);//첫째셋째,둘째셋째 큰거
		for(int i=4;i<=n;i++) {
			result[i]=Math.max(arr[i]+result[i-2], arr[i-1]+arr[i]+result[i-3]);//두칸전이랑 한칸전 중 큰거
		}
		System.out.println(result[n]);
	}

}
