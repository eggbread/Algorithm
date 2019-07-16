package algorithm;


public class Main4673 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] arr = new boolean[10000+1];
		for(int i=1;i<=10000;i++) {
			arr[cel(i)]=true;			
		}
		for(int i=1;i<=10000;i++) {
			if(!arr[i]) {
				System.out.println(i);
			}
		}
	}
	public static int cel(int input) {

		int temp= input +((input%10000)/1000)+((input%1000)/100)+ ((input%100)/10)+(input%10);
		if(temp<=10000) {
			return temp;
		}else {
			return 0;
		}
	}
}
