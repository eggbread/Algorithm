package algorithm;

import java.util.Scanner;

public class Main2920 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int status = 0;
		for(int i=0;i<7;i++) {
			int temp = scan.nextInt();
			if(n-1==temp) {
				status=1;
			}else if(n+1==temp) {
				status=2;
			}else {
				status=3;
				break;
			}
			n=temp;
		}
		switch(status) {
		case 1:
			System.out.println("descending");
			break;
		case 2:
			System.out.println("ascending");
			break;
		case 3:
			System.out.println("mixed");
			break;
		}
	}

}
