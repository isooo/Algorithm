package ch06;

import java.util.Scanner;

public class Q04 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("버블 정렬(버전 3)");
        System.out.print("요솟수 : ");
        int cnt = sc.nextInt();
        int[] x = new int[cnt];

        for(int i = 0 ; i < cnt ; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = sc.nextInt();
        }
        bubbleSort(x, cnt);
    }

    private static void bubbleSort(int[] x, int cnt) {
        int compare = 0;
        int tot_exchange = 0;

        int tmp = 0;
        int tryCnt = 0;

        while(tmp < cnt - 1) {
            System.out.println("패스 " + ++tryCnt + " : ");
            int last = cnt - 1;
            for(int i = cnt - 1 ; i > tmp ; i--) {
                for(int j = 0 ; j < cnt; j++) {
                    System.out.printf("%3d %c", x[j], (j != i - 1) ? ' ' : (x[i - 1] > x[i]) ? '+' : '-');
                }
                System.out.println();

                compare++;
                if(x[i - 1] > x[i]) {
                    tot_exchange++;
                    swap(x, i - 1, i);
                    last = i;
                }
            }
            tmp = last;
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
