package Week01;

import java.io.*;
import java.util.*;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner scan;
        try {
            scan = new Scanner(new File("./src/data02.txt"));
            int[] arrayForInsertion = Arrays.asList(scan.nextLine().split(",")).stream().mapToInt(Integer::parseInt).toArray();
           run("InsertionSort",arrayForInsertion);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void run(String name,int[] array){
        Insertionsort(array);//정렬 시작
        try {
            FileWriter fileWriter = new FileWriter("./hw01_06_201502018_insertion.txt");
            for(int n=0;n<array.length-1;n++)//정렬된 배열 텍스트파일로 출력
                fileWriter.write(array[n] + ",");
            fileWriter.write(array[array.length-1]+"");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Insertionsort(int[] arr){
        for(int i = 1;i<arr.length;i++){//n번 순회한다
            int key=arr[i];//현재 순회하는 배열을 key로 지정
            int j=i-1;//key의 왼쪽 인덱스
            while(j>=0&&arr[j]>key){//배열의 범위를 벗어나지 않으며 key가 왼쪽의 있는 요소보다 작다면
                arr[j+1]=arr[j];//key를 왼쪽으로 이동
                j--;
            }
            arr[j+1]=key;//왼쪽에 더 큰 요소가 없는 즉 key의 정렬 위치에 삽입
        }
    }
}



