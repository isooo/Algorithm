package ch06;

import java.util.Scanner;

public class Q03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("버블 정렬(버전 1)");
        System.out.print("요솟수 : ");
        int nx = sc.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = sc.nextInt();
        }

        bubbleSort(x, nx);

    }

    private static void bubbleSort(int[] x, int n) {
        int compare = 0;
        int tot_exchange = 0;

        for (int i = 0; i < n - 1; i++) {
            System.out.println("패스 " + (i + 1) + " : ");
            int exchange = 0;
            for (int j = n - 1; j > i; j--) {
                for (int m = 0; m < n; m++) {
                    System.out.printf("%3d %c", x[m], (m != j - 1) ? ' ' : (x[j - 1] > x[j]) ? '+' : '-');
                }
                System.out.println();
                compare++;
                if (x[j - 1] > x[j]) {
                    swap(x, j - 1, j);
                    exchange++;
                    tot_exchange++;
                }
            }

            // 패스 최종 배열 출력
            for (int m = 0; m < n; m++)
                System.out.printf("%3d  ", x[m]);
            System.out.println();

            if (exchange == 0) break;
            ;
        }

        System.out.println("비교를 " + compare + "회 했습니다.");
        System.out.println("교환을 " + tot_exchange + "회 했습니다.");
    }

    private static void swap(int[] x, int idx1, int idx2) {
        int tmp = x[idx1];
        x[idx1] = x[idx2];
        x[idx2] = tmp;
    }
}
