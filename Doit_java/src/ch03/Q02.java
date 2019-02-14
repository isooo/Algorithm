package ch03;

import java.util.Scanner;

/*
    선형 검색 (검색과정을 자세히 나타냄)
 */
public class Q02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수 : ");

        int num = sc.nextInt();

        int[] x = new int[num + 1];

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "]의 요소 : ");
            x[i] = sc.nextInt();
        }

        System.out.print("찾고자 하는 값 : ");
        int key = sc.nextInt();

        int idx = seqSearchSenAnswer(x, num, key);

        if (idx == -1) {
            System.out.println("해당하는 값은 없습니다.");
        } else {
            System.out.println("해당하는 " + key + "의 키는 " + idx + "에 있습니다.");
        }

    }

    static int seqSearchSenAnswer(int[] x, int num, int key) {

        System.out.print("   |");
        for (int i = 0; i < num; i++)
            System.out.printf("%4d", i);
        System.out.println();

        System.out.print("---+");
        for (int i = 0; i < 4 * num + 2; i++)
            System.out.print("-");
        System.out.println();

        for (int i = 0; i < num; i++) {
            System.out.print("   |");
            System.out.printf(String.format("%%%ds*\n", (i * 4) + 3), "");  // %%%ds*\n --> %7s*\n
            System.out.printf("%3d|", i);
            for (int j = 0; j < num; j++) {
                System.out.printf("%4d", x[j]);
            }
            System.out.println("\n   |");
            if (x[i] == key)
                return i; // 검색성공
        }
        return -1; // 검색실패
    }

}