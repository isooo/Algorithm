package ch01;

import java.util.Scanner;

/*
    기호문자 *로 피라미드를 출력함
 */

public class Q16 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("피라미드 출력하기");
        System.out.print("몇 단입니까? : ");
        int n = sc.nextInt();
        spira(n);
        spiraAnswer(n);

    }

    static void spira(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > i; j--) {
                System.out.print(' ');
            }
            for (int j = 1; j <= (i - 1) * 2 + 1; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    static void spiraAnswer(int n) {
        for (int i = 1; i <= n; i++) {                    // i행 (i = 1, 2, … ,n)
            for (int j = 1; j <= n - i + 1; j++)        // n-i+1개의 ' '를 나타냄
                System.out.print(' ');
            for (int j = 1; j <= (i - 1) * 2 + 1; j++)    // (i-1)*2+1개의 '*'를 나타냄
                System.out.print('*');
            System.out.println();                        // 개행(줄변환)
        }
    }
}
