package algorithm;

import java.util.Scanner;

public class Main1010 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int[][] arr = new int[32][32];
		for(int i=1;i<=30;i++) {//1�� 2 ����
			arr[i][i]=1;
			arr[1][i]=i;
			arr[2][i+1]=arr[2][i]+i;
		}
		int start = 3;
		for(int i=0;i<t;i++) {
			int n=scan.nextInt();
			int m=scan.nextInt();
			if(arr[n][m]==0) {//ó��
				while(arr[n][m]==0) {
					for(int o=start;o<=30;o++) {//�������� �Ѵܰ� ���� ū �Ѵܰ� ���� ���̴�
						arr[start][o+1]=arr[start][o]+arr[start-1][o];
					}
					start++;
				}
				System.out.println(arr[n][m]);
			}else {//�Դٰ�
				System.out.println(arr[n][m]);				
			}
		}
	}
}
