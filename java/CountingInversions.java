package Week04;

import java.io.*;
import java.util.*;

public class CountingInversions {
    public static void main(String[] args) {
        Scanner scan;
        try {
            scan = new Scanner(new File("./data04_inversion.txt"));
            int[] array = Arrays.asList(scan.nextLine().split(",")).stream().mapToInt(Integer::parseInt).toArray();
            Pack result = SORT_AND_COUNT(array, 0, array.length);
            System.out.println("Pack of CountingInversions");
            System.out.println(result.count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Pack SORT_AND_COUNT(int[] arr, int left, int right) {
        if (left == right - 1) {//left가 rigth보다 1작다 즉, 배열요소가 하나이다
            return new Pack(Arrays.copyOfRange(arr, left, right));//이를 반환
        }
        int middle = (left + right) / 2;//divide를 위한 중앙 인덱스 변수
        Pack front = SORT_AND_COUNT(arr, left, middle);//divide 재귀 실행
        Pack back = SORT_AND_COUNT(arr, middle, right);//divide 재귀 실행
        Pack end = Merge(front, back);//divide된 두 배열을 conquer
        end.count += front.count + back.count;//front와 back의 두 count값을 더한다
        return end;
    }

    public static Pack Merge(Pack front, Pack back) {
        int[] temp = new int[front.array.length + back.array.length];//두 배열이 합쳐질 함수
        Pack inversion = new Pack(temp);//객체 함수
        int first = 0, second = 0, n = 0;//두 배열의 비교 위치를 의미하는 인덱스 변수
        for (n = 0; (first < front.array.length && second < back.array.length); n++) {//한쪽이 모두 사용될때까지
            if (front.array[first] > back.array[second]) {//앞에 있는게 뒤에 보다 크면 즉 inversion
                inversion.array[n] = back.array[second++];//배열 삽입
                inversion.count += front.array.length - first;
                //inversion이 있으면 앞 배열의 남은 수 만큼 inversion이므로 그만큼 더한다.
            } else {
                inversion.array[n] = front.array[first++];//배열 삽입
            }
        }
        //두 배열의 개수보다 1개 적게 반복하고 && first와 second가 배열의 길이보다 작아야한다 즉 하나의 배열이 모두 사용되지 않아야한다
        while (n < front.array.length + back.array.length)//하나의 배열이 모두 사용되었을 때 나머지 배열을 넣기위한 반복
            inversion.array[n++] = (first == front.array.length) ? back.array[second++] : front.array[first++];//요소가 남은 배열을 reuslt에 삽입
        return inversion;
    }
}

class Pack {
    int count = 0;//inversion의 개수
    int[] array;//배열
    public Pack(int[] arr) {
        array = arr;//배열을 넣는 객체 생성자
    }
}
