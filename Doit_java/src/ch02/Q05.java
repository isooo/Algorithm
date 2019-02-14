package ch02;

import java.util.Scanner;

/*
    배열 b의 모든 요소를 배열 a에 역순으로 copy하는 메소드를 작성하세요.
 */
public class Q05 {

    private static void rcopy(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            b[a.length - i - 1] = a[i];
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("배열 a의 요소 개수 : ");
        int count = sc.nextInt();

        int[] a = new int[count];

        for (int i = 0; i < a.length; i++) {
            System.out.print("a[" + i + "] : ");
            a[i] = sc.nextInt();
        }

        int[] b = new int[count];

        rcopy(a, b);

        System.out.println("--- 역순 저장 완료 ---");
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + "  ");
        }
    }// main()

}
