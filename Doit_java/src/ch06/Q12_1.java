package ch06;

import java.util.Scanner;

public class Q12_1 {

    // 요소 교환
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }


    // 배열 나누기
    static void quickSort(int[] a, int left, int right) {
        int pl = left;         // 왼쪽
        int pr = right;     // 오른쪽
        int x = a[(pl + pr) / 2];   // 피벗

        do{
            while(a[pl] < x) pl++;
            while(a[pr] > x) pr--;
            if(pl <= pr) {
                swap(a, pl++, pr--);
            }
        } while(pl <= pr);

        if(pr - left > right - pl) {
            int tmp = left;
            left = pl;
            pl = tmp;
            tmp = right;
            right = pr;
            pr = tmp;
        }
        
        if(left < pr) {
            quickSort(a, left, pr);
        }
        if(pl < right) {
            quickSort(a, pl, right);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("요솟수 : ");
        int cnt = sc.nextInt();
        int[] x = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = sc.nextInt();
        }

        quickSort(x, 0, cnt - 1);

        System.out.print("퀵정렬로 오름차순 정렬 완료 : ");
        for(int i = 0 ; i < cnt ; i++) {
            System.out.print(" " + x[i]);
        }
    }
}
