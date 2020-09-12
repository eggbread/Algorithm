package algorithm;

import java.util.Scanner;

public class Main2577 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int mul = scan.nextInt() * scan.nextInt() * scan.nextInt();
		int[] arr = new int[10];
		int leng = Integer.toString(mul).length();
		for(int i=0;i<leng;i++) {	
			int temp = mul % 10;
			switch (temp) {
			case 0:
				arr[0]++;
				break;
			case 1:
				arr[1]++;
				break;
			case 2:
				arr[2]++;
				break;
			case 3:
				arr[3]++;
				break;
			case 4:
				arr[4]++;
				break;
			case 5:
				arr[5]++;
				break;
			case 6:
				arr[6]++;
				break;
			case 7:
				arr[7]++;
				break;	
			case 8:
				arr[8]++;
				break;
			case 9:
				arr[9]++;
				break;
			}
			mul=mul/10;
		}
		for(int i=0;i<10;i++) {
			System.out.println(arr[i]);
		}
	}

}

