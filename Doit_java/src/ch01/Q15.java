package ch01;

import java.util.Scanner;

/*
    이등변 삼각형을 출력하기
 */

public class Q15 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("이등변 삼각형 출력하기");
        System.out.print("몇 단 삼각형입니까? : ");
        int n = sc.nextInt();
//        triangleLB(n);
//        triangleLU(n);
//        triangleRU(n);
        triangleRB(n);
    }

    // 왼쪽 아래가 직각인
    static void triangleLB (int n) {
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= i ; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    // 왼쪽 위가 직각인
    static void triangleLU (int n) {
        for (int i = 1 ; i <= n ; i++) {
            for (int j = n ; j >= i ; j--) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    // 오른쪽 위가 직각인
    static void triangleRU (int n) {
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j < i ; j++) {
                System.out.print(' ');
            }
            for (int j = n ; j >= i ; j--) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    // 오른쪽 아래가 직각인
    static void triangleRB (int n) {
        for (int i = 1 ; i <= n ; i++) {
            for (int j = n ; j > i ; j--) {
                System.out.print(' ');
            }
            for (int j = 1 ; j <= i ; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

}
