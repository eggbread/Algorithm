package algorithm;

import java.util.Scanner;

public class Main16503 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String[] arrInput = input.split(" ");
		int one = Integer.parseInt(arrInput[0]);
		int two = Integer.parseInt(arrInput[2]);
		int three = Integer.parseInt(arrInput[4]);
		int firstResult = 0, secondResult = 0;
		firstResult = cal(one,two,arrInput[1]);
		secondResult = cal (two,three,arrInput[3]);
		firstResult = cal(firstResult,three,arrInput[3]);
		secondResult = cal(one,secondResult,arrInput[1]);
		if(firstResult<secondResult) {
			System.out.println(firstResult);
			System.out.println(secondResult);
		}else {
			System.out.println(secondResult);
			System.out.println(firstResult);
		}
	}
	public static int cal(int a, int b,String c) {
		switch (c) {
		case "+":
			return a+b;
		case "-":
			return a-b;
		case "*":
			return a*b;
		case "/":
			return a/b;
		default:
			return 0;
		}
	}

}
