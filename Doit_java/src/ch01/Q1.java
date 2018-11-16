package ch01;

import java.util.Scanner;

/*
    네 값의 최댓값을 구하는 max4메서드를 작성하세요
 */
public class Q1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("-- 최댓값 구하기 --");
        System.out.print("a의 값 : ");
        int a = sc.nextInt();
        System.out.print("b의 값 : ");
        int b = sc.nextInt();
        System.out.print("c의 값 : ");
        int c = sc.nextInt();
        System.out.print("d의 값 : ");
        int d = sc.nextInt();

        System.out.println("최댓값 : " + max4(a, b, c, d));

    }


    static int max4(int a, int b, int c, int d) {
        int max = a;

        if (b > max) max = b;
        if (c > max) max = c;
        if (d > max) max = d;

        return max;
    }
}
