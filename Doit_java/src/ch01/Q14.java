package ch01;

import java.util.Scanner;

/*
    입력받은 정수로 정사각형 별찍기
 */

public class Q14 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("사각형을 출력합니다.");

/*
		do {
			System.out.print("단수는：");
			n = stdIn.nextInt();
		} while (n <= 0);
*/
        System.out.print("단 수 : ");
        int num = sc.nextInt();

        printSquare(num);
    }

    static void printSquare(int num) {
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                System.out.print('*');
            }
            System.out.println();
        }

    }
}
