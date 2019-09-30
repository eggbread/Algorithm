package Week04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ClosestPair {
    public static void main(String[] args) {
        Scanner scan;
        try {
            File file = new File("./data04_closest.txt");
            scan = new Scanner(file);
            ArrayList<double[]> array = new ArrayList<double[]>();
            while(scan.hasNext()){
                array.add(Arrays.asList(scan.next().split(",")).stream().mapToDouble(Double::parseDouble).toArray());
            }
            Insertionsort(array,0);//sort
            System.out.println("Result of ClosetPair");
            System.out.printf("%.3f",Closet_Pair(array));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static double Closet_Pair(ArrayList<double[]> array) {
        if (array.size() < 4) {//brute force
            double minValue = Double.MAX_VALUE;
            for (int i = 0; i < array.size() - 1; i++) {
                int j = i + 1;
                double temp = calDistance(array.get(i), array.get(j));
                if (minValue > temp) {
                    minValue = temp;
                }
            }
            return minValue;
        }

        int halfLine = array.size() / 2;
        double deltaFront = Closet_Pair(new ArrayList<>(array.subList(0, halfLine)));
        double deltaBack = Closet_Pair(new ArrayList<>(array.subList(halfLine, array.size())));
        double min = deltaFront > deltaBack ? deltaBack : deltaFront;

        ArrayList<double[]> DeleteArray = new ArrayList<>();//Delete
        double xPosition = (array.get(halfLine)[0] + array.get(halfLine - 1)[0]) / 2;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i)[0] <= xPosition + min || array.get(i)[0] >= xPosition - min) {
                DeleteArray.add(array.get(i));
            }
        }

        Insertionsort(DeleteArray, 1);

        double minValue = min;
        for (int n = 0; n < DeleteArray.size() - 1; n++) {
            double yPosition = DeleteArray.get(n)[1];
            int m = n + 1;
            if (DeleteArray.get(m)[1] <= yPosition + min || DeleteArray.get(m)[1] >= yPosition - min) {
                double temp = calDistance(DeleteArray.get(n), DeleteArray.get(m));
                if (temp < minValue) {
                    minValue = temp;
                }
            }
        }
        return minValue;
    }

    public static double calDistance(double[] point1, double[] point2) {
        return Math.sqrt(Math.pow(point1[0] - point2[0], 2) + Math.pow(point1[1] - point2[1], 2));
    }

    public static void Insertionsort(ArrayList<double[]> arr, int index) {
        for (int i = 1; i < arr.size(); i++) {//n번 순회한다
            double[] key = arr.get(i);//현재 순회하는 배열을 key로 지정
            int j = i - 1;//key의 왼쪽 인덱스
            while (j >= 0 && arr.get(j)[index] > key[index]) {//배열의 범위를 벗어나지 않으며 key가 왼쪽의 있는 요소보다 작다면
                arr.set(j + 1, arr.get(j));//key를 왼쪽으로 이동
                j--;
            }
            arr.set(j + 1, key); //왼쪽에 더 큰 요소가 없는 즉 key의 정렬 위치에 삽입
        }
    }
}
