package ch01;

import java.util.Scanner;

/*
    정수a, b를 포함하여 그 사이의 모든 정수의 합을 구합니다.
 */

public class Q9 {

    static int sumof (int a, int b) {
        int sum = 0;

        if (a > b) {
            sum = a;
            a = b;
            b = sum;
            sum = 0;
        }
        for (int i = a ; i <= b ; i++) {
            sum += i;
        }
        return sum;
    }

    static int sumofAnswer(int a, int b) {
        int min; // a, b의 작은 쪽의 값
        int max; // a, b의 큰 쪽의 값

        if (a < b) {
            min = a;
            max = b;
        } else {
            min = b;
            max = a;
        }

        int sum = 0; // 합
        for (int i = min; i <= max; i++)
            sum += i;
        return (sum);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("정수 a : ");
        int a = sc.nextInt();
        System.out.print("정수 b : ");
        int b = sc.nextInt();

        System.out.println(a + "에서 " + b + "까지 정수의 합 = " + sumof(a, b));

    }
}
