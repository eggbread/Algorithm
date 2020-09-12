package algorithm;

import java.util.Scanner;

public class Main14717 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int first=scan.nextInt(),second=scan.nextInt();
		double result=0;
		if(first==second) {
			result = (((double)first+10)/20);
		}else {
			int temp = (first+second)&0x0000000000001111;
			result = temp/20;
		}
		System.out.println(result);
	}
}
