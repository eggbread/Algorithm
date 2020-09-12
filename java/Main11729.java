package algorithm;

import java.util.Scanner;

public class Main11729 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println(((int)Math.pow(2, n))-1);
		hanoi(1,3,n);
	}
	public static void hanoi(int x,int y,int count) {
		if(count<=0) return;
		
		hanoi(x,6-x-y,count-1);
		System.out.println(x+" "+y);
		hanoi(6-x-y,y,count-1);
	}

}
