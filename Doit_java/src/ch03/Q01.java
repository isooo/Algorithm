package ch03;

import java.util.Scanner;

/*
    선형 검색(보초법：for문을 사용하여 구현)
 */
public class Q01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수 : ");

        int num = sc.nextInt();

        int[] x = new int[num + 1];

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "]의 요소 : ");
            x[i] = sc.nextInt();
        }

        System.out.print("찾고자 하는 값 : ");
        int key = sc.nextInt();

        int idx = seqSearchSen(x, num, key);

        if (idx == -1) {
            System.out.println("해당하는 값은 없습니다.");
        } else {
            System.out.println("해당하는 " + key + "의 키는" + idx + "에 있습니다.");
        }

    }

    static int seqSearchSen(int[] x, int num, int key) {

        int i;

        x[num] = key;       // 보초를 추가

        for (i = 0; i <= num; i++) {
            if (x[i] == key) {
                break;
            }
        }

        return i == num ? -1 : i;
    }

    static int seqSearchSenAnswer(int[] x, int num, int key) {
        int i;

        x[num] = key;

        for (i = 0; x[i] != key; i++)
            ;

        return i == num ? -1 : i;
    }

}
