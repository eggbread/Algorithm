package algorithm;

import java.util.Scanner;

public class Main1780 {
	static int minus=0,zero=0,one=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		int[][] arr = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j]=scan.nextInt();
			}
		}
		find(arr,0,n,0,n);
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(one);
	}
	public static void find(int[][] arr,int TP,int BP,int LP,int RP) {
		int start=arr[TP][LP];
		boolean found=cal(arr,TP,BP,LP,RP);
		if(!found) {
			get(start);
			return ;
		}else {
			find(arr,TP,TP+(BP-TP)/3,LP,LP+(RP-LP)/3);
			find(arr,TP,TP+(BP-TP)/3,LP+(RP-LP)/3,LP+((RP-LP)/3)*2);
			find(arr,TP,TP+(BP-TP)/3,LP+((RP-LP)/3)*2,RP);
			find(arr,TP+(BP-TP)/3,TP+((BP-TP)/3)*2,LP,LP+(RP-LP)/3);
			find(arr,TP+(BP-TP)/3,TP+((BP-TP)/3)*2,LP+(RP-LP)/3,LP+((RP-LP)/3)*2);
			find(arr,TP+(BP-TP)/3,TP+((BP-TP)/3)*2,LP+((RP-LP)/3)*2,RP);
			find(arr,TP+((BP-TP)/3)*2,BP,LP,LP+(RP-LP)/3);
			find(arr,TP+((BP-TP)/3)*2,BP,LP+(RP-LP)/3,LP+((RP-LP)/3)*2);
			find(arr,TP+((BP-TP)/3)*2,BP,LP+((RP-LP)/3)*2,RP);
		}
	}
	public static boolean cal(int[][] arr,int TP,int BP,int LP,int RP) {
		int start=arr[TP][LP];
		for(int i=TP;i<BP;i++) {
			for(int j=LP;j<RP;j++) {
				if(arr[i][j]!=start) {
					return true;
				}
			}
		}
		return false;
	}
	public static void get(int start) {
		switch(start) {
		case -1:
			minus++;
			break;
		case 0:
			zero++;
			break;
		case 1:
			one++;
			break;
		}
	}
}
