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
		result[1]=arr[1];//ù��°
		result[2]=Math.max(arr[1]+arr[2], arr[2]);//ù°��°,��° ū��
		result[3]=Math.max(arr[2]+arr[3], arr[1]+arr[3]);//ù°��°,��°��° ū��
		for(int i=4;i<=n;i++) {
			result[i]=Math.max(arr[i]+result[i-2], arr[i-1]+arr[i]+result[i-3]);//��ĭ���̶� ��ĭ�� �� ū��
		}
		System.out.println(result[n]);
	}

}
