package algorithm;

import java.util.Scanner;

public class Main8958 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
		for(int i=0;i<n;i++) {
			String temp=scan.nextLine();
			int cnt=1;
			int result =0;
			for(int j=0;j<temp.length();j++) {
				if(temp.charAt(j)=='O') {
					result += cnt;
					cnt++;
				}else {
					cnt=1;
				}
			}
			System.out.println(result);
		}
	}

}
