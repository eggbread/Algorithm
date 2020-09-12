package Week02;

import java.util.Scanner;

public class PoweringNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please insert number a^n");
        System.out.println(power(scan.nextInt(),scan.nextInt()));
    }
    public static int power(int a,int n){
        if(n==1){
            return a;
        }else{
            if(n%2==0){//even
                return power(a,n/2)*power(a,n/2);//a^(n/2)*a^(n/2)
            }else{//odd
                //a^((n-1)/2)*a^((n-1)/2)*a
                return power(a,(n-1)/2)*power(a,(n-1)/2)*a;
            }
        }
    }
}
