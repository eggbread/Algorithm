package algorithm;

import java.math.BigInteger;
import java.util.Scanner;

public class Main11720 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int sum=0;
		scan.nextLine();
		String line = scan.nextLine();
		BigInteger input = new BigInteger(line);
			for(int i=0;i<n;i++) {
				int temp = input.mod(new BigInteger("10")).intValue();
				sum += temp;
				input=input.divide(new BigInteger("10"));
			}
			System.out.println(sum);
		
	}
}
