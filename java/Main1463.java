package algorithm;

import java.util.Scanner;

public class Main1463 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int[] arr = new int[x + 2];
		arr[1] = 0;// 1�� ����
		for (int i = 2; i <= x; i++) {
			arr[i] = arr[i - 1] + 1;// ���� i-1�迭�� 1�� ���Ѵ�.
			if (i % 2 == 0) {// 2�� ������ �ش� �迭�� ���� 1�� ���Ѵ�.
				arr[i] = arr[i] > arr[i / 2] + 1 ? arr[i / 2] + 1 : arr[i];
			}
			if (i % 3 == 0) {// 3���� ������ �ش� �迭�� ���� 1�� ���Ѵ�.
				arr[i] = arr[i] > arr[i / 3] + 1 ? arr[i / 3] + 1 : arr[i];
			}
		}
		System.out.println(arr[x]);
	}
}
