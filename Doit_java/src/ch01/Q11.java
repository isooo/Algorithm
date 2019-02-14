package ch01;

import java.util.Scanner;

/*
    양의 정수값의 자릿수를 구하여 나타냄
 */

public class Q11 {

    static int lengthOf(int num) {

        int count = 0;

//        while (num % 10 != 0 || num / 10 != 0) {
        while (num > 0) {
            num = num / 10;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = 0;

        do {
            System.out.print("양의 정수를 입력하세요 : ");
            num = sc.nextInt();
        } while (num <= 0);

        System.out.println("그 수는 " + lengthOf(num) + "자리 입니다.");

    }

}
