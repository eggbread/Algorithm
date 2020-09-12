package algorithm;

import java.util.Scanner;

public class Main1065 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int count=0;
		for(int i=1;i<=n;i++) {
			if(cel(i)) {
				count++;
			}
		}
		System.out.println(count);
	}	
	public static boolean cel(int i) {
		if(i<100) {
			return true;
		}else {
			String temp = Integer.toString(i);
			int len = temp.length();
			int[] arr = new int[len];
			for(int j=0;j<len;j++) {
				arr[j]=temp.charAt(j)-'0';
			}
			boolean found=true; 
			int sub=arr[0]-arr[1];
			for(int j=1;j<len-1;j++) {
				if(sub!=arr[j]-arr[j+1]) {
					found=false;
				}
			}
			return found;
		}
	}
}
