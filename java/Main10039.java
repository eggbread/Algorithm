package algorithm;

import java.util.Scanner;

public class Main10039 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int sum=0;
		for(int i=0;i<5;i++) {
			int temp =scan.nextInt();
			if(temp<40) {
				sum+=40;
			}else {
				sum+=temp;
			}
		}
		System.out.println(sum/5);
	}
}
