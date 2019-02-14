package ch01;

import java.util.Scanner;

/*
    숫자를 늘어놓아 피라미드를 출력
 */

public class Q17 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("숫자 피라미드 출력하기");
        System.out.print("몇 단입니까? : ");
        int n = sc.nextInt();
        nspira(n);

    }

    static void nspira(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > i; j--) {
                // for (int j = 1; j <= n - i + 1; j++)
                System.out.print(' ');
            }
            for (int j = 1; j <= (i - 1) * 2 + 1; j++) {
                System.out.print(i % 10);
            }
            System.out.println();
        }
    }

}
