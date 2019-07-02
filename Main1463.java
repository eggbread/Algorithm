package algorithm;

import java.util.Scanner;

public class Main1463 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int[] arr = new int[x + 2];
		arr[1] = 0;// 1은 고정
		for (int i = 2; i <= x; i++) {
			arr[i] = arr[i - 1] + 1;// 먼저 i-1배열에 1을 더한다.
			if (i % 2 == 0) {// 2로 나뉘면 해당 배열의 값에 1을 더한다.
				arr[i] = arr[i] > arr[i / 2] + 1 ? arr[i / 2] + 1 : arr[i];
			}
			if (i % 3 == 0) {// 3으로 나뉘면 해당 배열의 값에 1을 더한다.
				arr[i] = arr[i] > arr[i / 3] + 1 ? arr[i / 3] + 1 : arr[i];
			}
		}
		System.out.println(arr[x]);
	}
}
