package algorithm;

import java.util.Scanner;

public class MainB {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("�������� ���� ���� ȯ���մϴ�.!!!");
		while(true) {
			int answer = (int) (Math.random()*100);
			int i=10;
		while(true) {
			if(i==0) {
				System.out.println("���� Ƚ���� ����Ǿ����ϴ�!!!");
			}
			System.out.print("���� ���� Ƚ�� : "+i+"\n���ڸ� �Է����ּ���! : ");
			int input = scan.nextInt();
			if(answer>input) {
				System.out.println(input+"���� ū �����Դϴ�!!!");
			}else if(answer==input) {
				System.out.println("�����Դϴ�!!!");
				System.out.println("�ٽ� �Ͻðڽ��ϱ�? 1:�� 0:�ƴϿ�");
				if(scan.nextInt()==0) {
					System.exit(0);
				}else {
					break;
				}
				break;
			}else {
				System.out.println(input+"���� ���� �����Դϴ�!!!");
			}
			i--;
		}
	}
	}
}
