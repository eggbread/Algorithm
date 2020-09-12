package algorithm;

import java.util.Scanner;

public class Main1149 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] result = new int[n][3];
		result[0][0] = scan.nextInt();
		result[0][1] = scan.nextInt();
		result[0][2] = scan.nextInt();
		for(int i=1;i<n;i++) {//입력받은 값중 자신의 색깔을 제외한 두 색깔중 작은 값을 더하여 저장한다.
			int R = scan.nextInt();
			int G = scan.nextInt();
			int B = scan.nextInt();
			for(int j=0;j<3;j++) {
				switch (j) {
				case 0:
					result[i][j]=Math.min(result[i-1][1], result[i-1][2])+R;
					break;
				case 1:
					result[i][j]=Math.min(result[i-1][0], result[i-1][2])+G;					
					break;
				case 2:
					result[i][j]=Math.min(result[i-1][1], result[i-1][0])+B;
					break;

				default:
					break;
				}
			
			}
			if(i==n-1) {//그러면 마지막에 배열의 최솟값은 가장 적은 비용
				System.out.println(Math.min(Math.min(result[i][0], result[i][1]), result[i][2]));
			}
		}
	}

}
