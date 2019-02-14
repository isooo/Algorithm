package ch05;

import java.util.Scanner;

/*
    유클리드의 호제법에 의해 최대 공약수를 비재귀적으로 구합니다.
 */
public class Q02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("최대공약수 구하기");
        System.out.print("x 입력하기 : ");
        int x = sc.nextInt();
        System.out.print("y 입력하기 : ");
        int y = sc.nextInt();
        System.out.println("두 수의 최대공약수는 " + gcd(x, y) + "입니다");
    }

    static int gcd(int x, int y) {

        while (y != 0) {
            int tmp = x;
            x = y;
            y = tmp % y;
            System.out.println("x : " + x + " /// y : " + y);
        }

        return (x);
    }
}
