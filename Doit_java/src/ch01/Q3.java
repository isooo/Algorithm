package ch01;

import java.util.Scanner;

/*
    네 값의 최솟값을 구하는 min4 메소드를 작성하세요.
 */
public class Q3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("-- 최솟값 구하기 --");
        System.out.print("a의 값 : ");
        int a = sc.nextInt();
        System.out.print("b의 값 : ");
        int b = sc.nextInt();
        System.out.print("c의 값 : ");
        int c = sc.nextInt();
        System.out.print("d의 값 : ");
        int d = sc.nextInt();

        System.out.println("최솟값 : " + min4(a, b, c, d));

    }

    static int min4 (int a, int b, int c, int d) {
        int min = a;

        if (b < min) min = b;
        if (c < min) min = c;
        if (d < min) min = d;

        return min;
    }

}
