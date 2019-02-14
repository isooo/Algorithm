package ch01;

import java.util.Scanner;

/*
    정수 b에서 정수 a를 뺀 값을 구합니다(b > a가 되도록 입력 받음)
 */
public class Q10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
// 나의 풀이
        System.out.print("a의 값 : ");
        int a = sc.nextInt();
        int b = Integer.MIN_VALUE;
        int count = 0;

        do {
            if (count != 0) System.out.println(a + "보다 큰 값을 입력하세요!");
            System.out.print("b의 값 : ");
            b = sc.nextInt();
            count++;
        } while (a >= b);


// 책 풀이
/*
        while (true) {
            System.out.print("b의 값 : ");
            b = sc.nextInt();
            if (a < b)
                break;
            System.out.println(a + "보다 큰 값을 입력하세요!");
        }
*/

        System.out.println(b + " - " + a + "는 " + (b - a) + "입니다.");

    }
}
