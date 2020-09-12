package algorithm;
import java.util.Scanner;

public class Main11022 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int i=0;i<n;i++) {
			int A = scan.nextInt();
			int B =scan.nextInt();
			System.out.println("Case #"+(i+1)+": "+A+" + "+B+" = "+(A+B));
		}
	}

}
