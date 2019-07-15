package algorithm;

import java.util.Scanner;

public class Main2884 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int H = scan.nextInt();
		int M = scan.nextInt();
		if(M<45) {
			if(H==0) {
				System.out.println(23 + " " + (60-(45-M)));
			}else {
				System.out.println(H-1 + " " + (60-(45-M)));
			}
		}else {
			System.out.println(H + " " + (M-45));
		}
	}

}
