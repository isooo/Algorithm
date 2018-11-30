package ch05;

import java.util.Scanner;

/*
    정수 x, y의 최대 공약수를 비재귀적으로 구하여 반환
 */
public class Q03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("최대공약수 구하기");


        System.out.print("정수 몇 개의 최대 공약수를 구할까요?：");
        int count;
        do {
            count = sc.nextInt();
        } while (count <= 1);

        int[] x = new int[count]; // 길이 num인 배열

        for (int i = 0; i < count; i++) {
            System.out.print("x[" + i + "]：");
            x[i] = sc.nextInt();
        }

        System.out.println(">> 최대공약수는 " + gcdArray(x, 0, count) + "입니다");
    }

    static int gcdArray(int[] a, int start, int count) {
        if (count == 1)
            return a[start];
        else if (count == 2)
            return gcd(a[start], a[start + 1]);
        else
            return gcd(a[start], gcdArray(a, start + 1, count - 1));
    }

    static int gcd(int x, int y) {
        while(y != 0) {
            int tmp = x;
            x = y;
            y = tmp % y;
        }
        return (x);
    }

}
