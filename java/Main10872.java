package algorithm;

import java.util.Scanner;
public class Main10872 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println(cel(scan.nextInt()));
	}
	public static int cel(int i) {
		if(i<=1) 
			return i;
		return i*cel(i-1);
	}
}
