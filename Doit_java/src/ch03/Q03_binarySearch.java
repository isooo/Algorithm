package ch03;

import java.util.Scanner;

/*

 */
public class Q03_binarySearch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수 : ");

        int n = sc.nextInt();

        int[] a = new int[n];


        System.out.print("x[0]의 요소 : ");
        a[0] = sc.nextInt();

        for (int i = 1; i < n; i++) {
            do {
                System.out.print("x[" + i + "]의 요소 : ");
                a[i] = sc.nextInt();
            } while (a[i] < a[i - 1]);
        }

        System.out.print("찾고자 하는 값 : ");
        int key = sc.nextInt();

        int[] idx = new int[n];

        int count = binarySearchIdx(a, n, key, idx);

        System.out.print(count + "만큼 존재합니다");
        for (int i = 0; i < count; i++) {
            System.out.print(" " + idx[i]);
        }
    }

    static int binarySearchIdx(int[] a, int n, int key, int[] idx) {

        int pl = 0;
        int pr = n - 1;

        int idxKey = 0;

        do {
            int pc = (pl + pr) / 2;

            if (a[pc] == key) {
                idx[idxKey++] = pc;
            } else if (a[pc] < key) {
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }

        } while (pl <= pr);

        return idxKey;
    }

}