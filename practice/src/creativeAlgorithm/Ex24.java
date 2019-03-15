package creativeAlgorithm;

import java.util.Scanner;

/*
    완전 탐색이라 시간 엄청 오래 걸림
 */

public class Ex24 {
    static int m;           // 거슬러줘야할 돈
    static int[] change;    // 동전의 종류
    static int result;      // 사용된 동전

    // d개의 동전으로 mon원을 채운 상태
    public static void solution(int mon, int d) {
        if(mon > m) {
            return;
        }
        if(mon == m) {
            result = Math.min(result, d);
            return;
        }
        for (int i = 0; i < change.length; i++) {
            solution(mon + change[i], d + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        int n = sc.nextInt();
        change = new int[n];
        sc.nextLine();
        String[] tmp = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            change[i] = Integer.parseInt(tmp[i]);
        }
        result = m;
        solution(0, 0);
        System.out.println(result);
    }
}
