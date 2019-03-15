package creativeAlgorithm;

import java.util.Scanner;

/*
    완전 탐색보다 조금 더 빠른 해법
 */

public class Ex24_2 {
    static int m;           // 거슬러줘야할 돈
    static int[] change;    // 동전의 종류
    static int result;      // 사용된 동전

    // k번째 이하의 동전을 cnt개 사용하여 mon을 거슬러준 상태
    public static void solution(int k, int cnt, int mon) {
        System.out.println(k + "번째 이하의 동전을 " + cnt + "개 사용하여 " + mon + " 거슬러준 상태");
        if (k == change.length || mon > m) {
            System.out.println("------------------------------------------");
            return;
        }
        if (mon == m) {
            result = Math.min(result, cnt);
            System.out.println("------------------------------------------");
            return;
        }
        for (int i = 0; mon + change[k] * i <= m; i++) {
            System.out.println("\t\t\t" + mon + " + " + change[k] + " * " + i + " = " + (mon + change[k] * i));
            solution(k + 1, cnt + i, mon + change[k] * i);
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
        solution(0, 0, 0);
        System.out.println(result);
    }
}
