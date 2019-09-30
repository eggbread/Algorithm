package Week02;

import java.math.BigInteger;
import java.util.Scanner;

public class Fibonacci {
    static BigInteger[][] temper={{BigInteger.ONE,BigInteger.ONE},{BigInteger.ONE,BigInteger.ZERO}};
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("방법\n1 : Recursion\n2 : Array\n3 : Recursive squaring");
        int input = scan.nextInt();
        System.out.println("n을 입력하세요");
        int value = scan.nextInt();
        double first=0,last=0;
        first=System.nanoTime();
        switch (input){
            case 1:
                System.out.println("fibonacciByRecursive:");
                for (int i=0;i<=value;i++){
                    double before = System.nanoTime();
                    BigInteger temp = fibonacciByRecursive(new BigInteger(Integer.toString(i)));
                    double after = System.nanoTime()-before;
                    print(i,temp,after);
                }
                break;

            case 2:
                System.out.println("fibonacciByBottomup:");
                for(int i=0;i<=value;i++) {
                    double before = System.nanoTime();
                    BigInteger temp=fibonacciByBottomup(value);
                    double after = System.nanoTime()-before;
                    print(i,temp,after);
                }
                break;
            case 3:
                System.out.println("fibonacciByRecursivesquaring:");
                for(int i=0;i<=value;i++){
                    double before = System.nanoTime();
                    BigInteger temp=fibonacciByRecursivesquaring(i);
                    double after = System.nanoTime()-before;
                    print(i,temp,after);
                }
                break;
        }
        last=System.nanoTime();
        System.out.format("\n합계 시간 : %.12f sec\n",(last-first)/1000000000);
    }

    public static void print(int n,BigInteger val,double time){
//        System.out.format("f<%2d> = %-25s",n,val.toString());
        System.out.format("%.12f \n",time/1000000000);
    }

    public static BigInteger fibonacciByRecursive(BigInteger n){
        if(n.intValue()==0)return BigInteger.ZERO;//0이면 0 리턴
        if(n.intValue()==1)return BigInteger.ONE;//1이면 1 리턴
        return fibonacciByRecursive(n.subtract(BigInteger.ONE)).add(fibonacciByRecursive(n.subtract(BigInteger.TWO)));
        //n-1과 n-2의 합을 리턴
    }

    public static BigInteger fibonacciByBottomup(int n){
        BigInteger[] array=new BigInteger[n+1];//배열 생성
        array[0]=BigInteger.ZERO;array[1]=BigInteger.ONE;//0,1번째 배열 초기화
        for(int i=2;i<=n;i++){//n번 순회
            array[i]=array[i-1].add(array[i-2]);//i-1과 i-2의 합을 i번째 배열에 삽입
        }
        return array[n];
    }

    public static BigInteger fibonacciByRecursivesquaring(int n){
        if(n<2){
            return new BigInteger(Integer.toString(n));//n이 1혹은 0 이라면 그대로 반환
        }
        BigInteger[][] result = pow(temper,n-1);//제곱합수를 n-1만큼 호출
        return result[0][0];//n-1을 제곱하면 행렬의 특징상 0,0은 F(n-1+1)이므로 원하는 f(n)을 얻는다
    }

    public static BigInteger[][] pow(BigInteger[][] arr,int n){
        if(n==1){
            return arr;//1이면 반환
        }else{
            if(n%2==0){//짝수면
                return mul(pow(arr,n/2),pow(arr,n/2));//a^(n/2)*a^(n/2)
            }else{//홀수면
                return  mul(mul(pow(arr,(n-1)/2),pow(arr,(n-1)/2)),temper);
                //a^((n-1)/2)*a^((n-1)/2)*a
            }
        }
    }

    public static BigInteger[][] mul(BigInteger[][] A,BigInteger[][] B){
        BigInteger[][] temp = new BigInteger[2][2];
//        temp[0][0]=A[0][0].multiply(B[0][0]).add(A[0][1].multiply(B[1][0]));
//        temp[0][1]=A[0][0].multiply(B[0][1]).add(A[0][1].multiply(B[1][1]));
//        temp[1][0]=A[1][0].multiply(B[0][0]).add(A[1][1].multiply(B[1][0]));
//        temp[1][1]=A[1][0].multiply(B[0][1]).add(A[1][1].multiply(B[1][1]));
        for( int i=0;i<2;i++)
            for(int j=0;j<2;j++){
                temp[i][j]=BigInteger.ZERO;
                for(int k=0;k<2;k++){
                    temp[i][j]=temp[i][j].add(A[i][k].multiply(B[k][j]));
                }
            }
        return temp;
        //행렬 곱셈 규칙대로 연산 후 반환
    }
}
