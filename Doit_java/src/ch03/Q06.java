package ch03;

import java.util.Arrays;
import java.util.Scanner;

/*
    Arrays.binarySearch에 의한 이진검색(실패할 때 삽입 포인트를 나타냄)
 */
public class Q06 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = sc.nextInt();
        int[] x = new int[num];

        System.out.println("오름차순으로 입력하세요");
        System.out.print("x[0]의 요소 : ");
        x[0] = sc.nextInt();

        for (int i = 1; i < num; i++) {
            do {
                System.out.print("x[" + i + "]의 요소 : ");
                x[i] = sc.nextInt();
            } while (x[i] < x[i - 1]);
        }

        System.out.print("찾고자 하는 값 : ");
        int value = sc.nextInt();

        int idx = Arrays.binarySearch(x, value);
        if (idx < 0) {
            System.out.println("그 값의 요소가 없습니다.");
            System.out.println("삽입포인트 : " + (idx + 1) * -1);
            System.out.println("반환된 값 : " + idx);
        } else {
            System.out.println("해당하는 " + value + "의 키는 " + idx + "입니다.");
        }
    }


}
