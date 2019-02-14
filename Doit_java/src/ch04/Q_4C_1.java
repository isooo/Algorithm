package ch04;

import java.util.Scanner;

public class Q_4C_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = 10;
        int[] a = new int[N];
        int cnt = 0;
        int retry;

        System.out.println("------------- 시작 -------------");
        do {
            System.out.printf("%d번째 정수 : ", cnt + 1);
            a[cnt++ % N] = sc.nextInt();
            System.out.print("계속 할까요?  1. 예 / 2. 아니오 : ");
            retry = sc.nextInt();
        } while (retry == 1);

        int i = cnt - N;
        if (cnt - N < 0) i = 0;
        for (; i < cnt; i++) {
            System.out.printf("%2d번째의 정수 : %d\n", i + 1, a[i % N]);
        }
    }
}
