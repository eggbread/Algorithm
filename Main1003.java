package algorithm;

import java.util.Scanner;

public class Main1003 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] arr = new int[45][2];//0�� 1�� ������ �����ϴ� �迭
		arr[0][0]=1;
		arr[0][1]=0;
		arr[1][0]=0;
		arr[1][1]=1;
		for(int i=2;i<=40;i++) {
			arr[i][0]=arr[i-1][1];//0�� ������ ������ 1�� �����̰�
			arr[i][1]=arr[i-1][0]+arr[i-1][1];//1�� ������ ������ 0�� 1�� ������ ���� ���̴�.
		}
		for(int j=0;j<n;j++) {
			int input = scan.nextInt();
			System.out.println(arr[input][0]+" "+arr[input][1]);
		}
	}

}
