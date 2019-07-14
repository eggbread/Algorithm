package algorithm;

import java.util.Scanner;

public class Main2588 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int y = scan.nextInt();
		int sum=x*(y%10);
		System.out.println(sum);
		for(int i=1;i<3;i++) {
			int temp = (x * ((y/(int)Math.pow(10, i))%10));
			sum += temp*(int)Math.pow(10, i);
			System.out.println(temp);
		}
		System.out.println(sum);
	}

}
