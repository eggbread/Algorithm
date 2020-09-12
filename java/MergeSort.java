package Week01;

import java.io.*;
import java.util.*;


public class MergeSort {
    static int count=0;
    public static void main(String[] args) {
        Scanner scan;
        try {
            scan = new Scanner(new File("./src/data02.txt"));
            int[] arrayForMerge = Arrays.asList(scan.nextLine().split(",")).stream().mapToInt(Integer::parseInt).toArray();
            run("MergeSort", arrayForMerge);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void run(String name,int[] array){
        array=MergeSort(array,0,array.length);
        try {
            FileWriter fileWriter = new FileWriter("./hw01_06_201502018_merge.txt");
            for(int n=0;n<array.length;n++)
                fileWriter.write(array[n] + ",");
            fileWriter.write(count+"");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] MergeSort(int[] arr,int left,int right){
        if(left==right-1){//left가 rigth보다 1작다 즉, 배열요소가 하나이다
            return Arrays.copyOfRange(arr,left,right);//이를 반환
        }
        int middle=(left+right)/2;//divide를 위한 중앙 인덱스 변수
        int[] front=MergeSort(arr,left,middle);//divide 재귀 실행
        int[] back=MergeSort(arr,middle,right);//divide 재귀 실행
        return Merge(front,back);//divide된 두 배열은 conquer

    }
    public static int[] Merge(int[] front,int[] back){
        count++;//Merge 카운팅
        int[] result=new int[front.length+back.length];//두 배열이 합쳐질 함수
        int first=0,second=0,n=0;//두 배열의 비교 위치를 의미하는 인덱스 변수
        for(n=0;n<front.length+back.length-1&&(first<front.length&&second<back.length);n++)
            //두 배열의 개수보다 1개 적게 반복하고 && first와 second가 배열의 길이보다 작아야한다 즉 하나의 배열이 모두 사용되지 않아야한다
            result[n]=(front[first]<back[second])?front[first++]:back[second++];//두 배열 중 더 작은 요소를 result에 삽입
        while(n<front.length+back.length)//하나의 배열이 모두 사용되었을 때 나머지 배열을 넣기위한 반복
            result[n++]=(first==front.length)?back[second++]:front[first++];//요소가 남은 배열을 reuslt에 삽입
        return result;
    }
}
