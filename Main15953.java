package algorithm;

import java.util.Scanner;

public class Main15953 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int[] first = new int[22];
		int[] second = new int[32];
		int count=1;
		for(int i=1;i<22;i++) {
			switch(i) {
			case 1:
				first[i]=5000000;
				break;
			case 2:
			case 3:
				first[i]=3000000;
				break;
			case 4:
			case 5:
			case 6:
				first[i]=2000000;
				break;
			case 7:
			case 8:
			case 9:
			case 10:
				first[i]=500000;
				break;
			case 11:
			case 12:
			case 13:
			case 14:
			case 15:
				first[i]=300000;
				break;
			case 16:
			case 17:
			case 18:
			case 19:
			case 20:
			case 21:
				first[i]=100000;
				break;
			}
		}
		for(int i=1;i<32;i++) {
			switch(i) {
			case 1:
				second[i]=5120000;
				break;
			case 2:
			case 3:
				second[i]=2560000;
				break;
			case 4:
			case 5:
			case 6:
			case 7:
				second[i]=1280000;
				break;
			case 8:
			case 9:
			case 10:
			case 11:
			case 12:
			case 13:
			case 14:
			case 15:
				second[i]=640000;
				break;
			case 16:
			case 17:
			case 18:
			case 19:
			case 20:
			case 21:
			case 22:
			case 23:
			case 24:
			case 25:
			case 26:
			case 27:
			case 28:
			case 29:
			case 30:
			case 31:
				second[i]=320000;
				break;
			}
		}
		int t = scan.nextInt();
		for(int i=0;i<t;i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			if(a>21) {
				a=0;
			}
			if(b>31) {
				b=0;
			}
				System.out.println(first[a]+second[b]);
			
		}
	}

}
