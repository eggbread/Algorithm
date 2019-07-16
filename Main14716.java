package algorithm;

import java.util.Scanner;

public class Main14716 {
	static boolean[][] checkArr;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt(),n = scan.nextInt();
		checkArr = new boolean[m+2][n+2];
 		for(int i=1;i<=m;i++) 
			for(int j=1;j<=n;j++) 
				if(scan.nextInt()==1) 
					checkArr[i][j]=true;
 		int count = 0;
 		for(int i=1;i<=m;i++) 
			for(int j=1;j<=n;j++) 
				count += find(i,j);

 		System.out.println(count);	
	}
	public static int find(int m, int n) {
		int found =0;
		if(checkArr[m][n]) {
			checkArr[m][n] = false;			
			found=1;
		}else 
			return 0;
		if (checkArr[m][n + 1])//모조리 검색
			find(m,n+1);
		if (checkArr[m + 1][n + 1]) 
			find(m+1,n+1);
		if (checkArr[m + 1][n]) 
			find(m+1,n);
		if (checkArr[m + 1][n - 1]) 
			find(m+1,n-1);
		if (checkArr[m][n - 1]) 
			find(m,n-1);
		if (checkArr[m - 1][n - 1]) 
			find(m-1,n-1);
		if (checkArr[m - 1][n]) 
			find(m-1,n);
		if (checkArr[m - 1][n + 1]) 
			find(m-1,n+1);
		return found;
	}
}
