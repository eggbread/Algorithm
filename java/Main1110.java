package algorithm;

import java.util.Scanner;

public class Main1110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		int start = A;
		int count=0;
		while(true) {
			String[] temp = new String[2];
			if(A<10) {
				temp[0]="0";
				temp[1]=Integer.toString(A);
			}else {
				temp= Integer.toString(A).split("");
			}
			A = Integer.parseInt(temp[1])*10 + (Integer.parseInt(temp[0]) + Integer.parseInt(temp[1]))%10;
			count++;
			if(start == A) {
				break;
			}
		}
		System.out.println(count);
	}

}