package algorithm;

import java.util.Scanner;

public class Main2753 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int year = scan.nextInt();
		if(year%4==0&&(year%100!=0||year%400==0)) {//4�� ����̰� 100�� ����� �ƴϴ�
			System.out.println(1);
		}else {
			System.out.println(0);	
		}
	}

}
