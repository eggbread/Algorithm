package algorithm;

import java.util.Scanner;

public class Main1026 {

	public static void main(String[] args) {//오름차순정렬과 내림차순정렬의 곱
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] A = new int[n];
		int[] B = new int[n];
		int[] C = {4,1,6,2,4,6};
		for(int i=0;i<n;i++) {
			A[i]=scan.nextInt();
		}
		for(int i=0;i<n;i++) {
			B[i]=scan.nextInt();
		}
		sort(A,0,A.length-1);
		sort(B,0,B.length-1);
		int left  = 0;            
	    int right = B.length - 1; 

	    while (left < right) {
	      int temp = B[left];
	      B[left]  = B[right];    
	      B[right] = temp;

	      left++; right--;         
	    }
	    int sum=0;
	    for(int i=0;i<n;i++) {
	    	sum += A[i]*B[i];
	    }
		System.out.println(sum);
	}
	public static void sort(int[] data, int l, int r){
        int left = l;
        int right = r;
        int pivot = data[(l+r)/2];
        
        do{
            while(data[left] < pivot) left++;
            while(data[right] > pivot) right--;
            if(left <= right){    
                int temp = data[left];
                data[left] = data[right];
                data[right] = temp;
                left++;
                right--;
            }
        }while (left <= right);
        
        if(l < right) sort(data, l, right);
        if(r > left) sort(data, left, r);
    }
}
