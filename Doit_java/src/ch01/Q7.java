package ch01;

import java.util.Scanner;

/*
    1, 2, …, n의 합을 구합니다  (식1 + 2 + … + n = 999라고 출력함)
 */

public class Q7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1부터 n까지의 합을 구합니다.");
        System.out.print("n의 값 : ");

        int n = sc.nextInt();

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print(i);
            sum += i;
            if (i < n) System.out.print(" + ");
        }

        System.out.print(" = " + sum);
    }
}
