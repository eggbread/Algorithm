package algorithm;

import java.util.Scanner;

public class Main2562 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int max=0;
		int index=0;
		for(int i=0;i<9;i++) {
			int temp=scan.nextInt();
			if(temp>max) {
				max=temp;
				index=i;
			}
		}

		System.out.println(max);
		System.out.println(index);
	}

}
