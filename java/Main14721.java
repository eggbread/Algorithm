package algorithm;

import java.util.Scanner;

public class Main14721 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n= scan.nextInt();
		int[][] array=new int[n][2];
		double[] rss = new double[n];
		double min=0;
		for(int a=1;a<=100;a++) {
			for(int b=1;b<=100;b++) {
				int count=0;
				while(count<n) {
					
				}
			}
		}
	}
	public static double calculate(int x,int y,int a,int b,int c) {
		double result = (-a*x+b*y-c)/Math.sqrt(Math.pow(a, 2)+Math.pow(b, 2));
		return result;
	}
}
