package algorithm;

import java.util.Scanner;

public class Main3052 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[10];
		int count=0;
		for(int i=0;i<10;i++) {
			int temp = scan.nextInt()%42;
			boolean found=false;
			for(int j=0;j<count;j++) {
				if(arr[j]==temp) {
					found=true;
					break;
				}
			}
			if(!found) {
				arr[count]=temp;
				count++;
			}
		}
		System.out.println(count);
	}

}
