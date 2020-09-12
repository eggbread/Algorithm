package algorithm;

import java.util.Scanner;

public class MainB {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("스무고개에 오신 것을 환영합니다.!!!");
		while(true) {
			int answer = (int) (Math.random()*100);
			int i=10;
		while(true) {
			if(i==0) {
				System.out.println("도전 횟수가 종료되었습니다!!!");
			}
			System.out.print("남은 도전 횟수 : "+i+"\n숫자를 입력해주세요! : ");
			int input = scan.nextInt();
			if(answer>input) {
				System.out.println(input+"보다 큰 숫자입니다!!!");
			}else if(answer==input) {
				System.out.println("정답입니다!!!");
				System.out.println("다시 하시겠습니까? 1:네 0:아니오");
				if(scan.nextInt()==0) {
					System.exit(0);
				}else {
					break;
				}
				break;
			}else {
				System.out.println(input+"보다 작은 숫자입니다!!!");
			}
			i--;
		}
	}
	}
}
