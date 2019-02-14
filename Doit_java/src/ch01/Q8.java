package ch01;

import java.util.Scanner;

/*
    가우스 공식에 의해 1, 2, …, n의 합을 구합니다.
 */
public class Q8 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1부터 n까지의 합을 구합니다.");
        System.out.print("n의 값 : ");

        int n = sc.nextInt();

        int sum = (n + 1) * (n / 2) + (n % 2 == 1 ? (n + 1) / 2 : 0); // 합

        System.out.println("합 : " + (((1 + n) * n) / 2));

    }

}
