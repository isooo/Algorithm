package ch01;

import java.util.Scanner;

/*
    세 값의 최솟값을 구하는 min3 메소드를 작성하세요.
 */
public class Q2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("-- 최솟값 구하기 --");
        System.out.print("a의 값 : ");
        int a = sc.nextInt();
        System.out.print("b의 값 : ");
        int b = sc.nextInt();
        System.out.print("c의 값 : ");
        int c = sc.nextInt();

        System.out.println("최솟값 : " + min3(a, b, c));

    }

    static int min3 (int a, int b, int c) {
        int min = a;

        if (b < min) min = b;
        if (c < min) min = c;

        return min;
    }

}
