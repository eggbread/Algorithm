package algorithm;

import java.util.Scanner;

public class SCPS1 {
	
		static int Answer;
	    static int[] arr;
		public static void main(String args[]) throws Exception	{
			/*
			   The method below means that the program will read from input.txt, instead of standard(keyboard) input.
			   To test your program, you may save input data in input.txt file,
			   and call below method to read from the file when using nextInt() method.
			   You may remove the comment symbols(//) in the below statement and use it.
			   But before submission, you must remove the freopen function or rewrite comment symbols(//).
			 */		

			/*
			   Make new scanner from standard input System.in, and read data.
			 */
			Scanner sc = new Scanner(System.in);
			//Scanner sc = new Scanner(new FileInputStream("input.txt"));
			arr=new int[1000005];
			arr[1]=0;arr[2]=1;arr[3]=3;
			int T = sc.nextInt();
			for(int test_case = 0; test_case < T; test_case++) {

				// Answer = 0;
				/////////////////////////////////////////////////////////////////////////////////////////////
				/*
				   Implement your algorithm here.
				   The answer to the case will be stored in variable Answer.
				 */
				/////////////////////////////////////////////////////////////////////////////////////////////

	            int n1 = sc.nextInt(),n2=sc.nextInt();
				
				int Answer=0;
				for(int j=n2;j>=n1;j--) {
					int a=cel(j);
					Answer += a;
				}
				
				// Print the answer to standard output(screen).
				System.out.println("Case #"+(test_case+1));
				System.out.println(Answer);
				
			}
		}
		public static int cel(int input) {
			if(input==1) {
				return 0;
			}else if(arr[input]!=0) {
				return arr[input];
			}
			
			if(input%2==0) {
				
				return arr[input]=cel(input/2)+1;
			}else {
				if(arr[input+1]!=0) {
					return arr[input]=arr[input+1]+1;
				}else {
					return arr[input]=cel(input+1)+1;			
				}
			}
		}
	
}
