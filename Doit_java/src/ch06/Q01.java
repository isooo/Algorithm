package ch06;

import java.util.Scanner;

public class Q01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("버블 정렬(버전 1)");
        System.out.print("요솟수 : ");
        int count = sc.nextInt();
        int[] x = new int[count];

        for (int i = 0; i < count; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = sc.nextInt();
        }

        bubbleSort(x, count);

        System.out.println("\t\t오름차순으로 정렬 ------");
        for (int i = 0; i < count; i++) {
            System.out.print(" " + x[i]);
        }
    }

    private static void bubbleSort(int[] x, int count) {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (x[j] > x[j + 1]) {
                    swap(x, j, j + 1);
                }
            }
        }
    }

    static void bubbleSortAnswer(int[] x, int count) {
        for (int i = count - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (x[j] > x[j + 1])
                    swap(x, j, j + 1);
            }
        }
    }

    private static void swap(int[] x, int idx1, int idx2) {
        int tmp = x[idx1];
        x[idx1] = x[idx2];
        x[idx2] = tmp;
    }

}
