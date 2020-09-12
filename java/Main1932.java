package algorithm;

import java.util.Scanner;

public class Main1932 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(),size=0;
		
		for(int i=1;i<=n;i++) {
			size+=i;
		}
		int[] arr = new int[size];
		int[] result = new int[size];
		for(int i=0;i<size;i++) {
			arr[i]=scan.nextInt();
		}
		result[0]=arr[0];
		result[1]=arr[0]+arr[1];
		result[2]=arr[0]+arr[2];
		int level=2;
		for(int i=3;i<size;i++) {//현재 i에서 level을 빼면 내 위의 두 부모이다
			int here = cal(level+1);
			if(here-1==i) {//현재 level의 마지막
				result[i]=result[i-level]+arr[i];
			}
			else if(here==i) {//새로운 level의 처음
				result[i]=result[i-level]+arr[i];
				level++;
			}else {				
				result[i]=Math.max(result[i-level], result[i-level+1])+arr[i];
			}
		}
		int max=result[size-1];
		for(int j=size-2;j>size-level;j--) {
			if(result[j]>max) {
				max=result[j];
			}
		}
		System.out.println(max);
	}
	public static int cal(int l) {
		return (int)(Math.pow(l, 2)-l)/2;
	}
}
